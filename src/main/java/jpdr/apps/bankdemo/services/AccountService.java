package jpdr.apps.bankdemo.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.persistence.Transient;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;

import jpdr.apps.bankdemo.configuration.properties.BankDemoConfigProperties;
import jpdr.apps.bankdemo.configuration.utils.LocaleUtils;
import jpdr.apps.bankdemo.entities.Account;
import jpdr.apps.bankdemo.entities.Client;
import jpdr.apps.bankdemo.entities.EntitiesList;
import jpdr.apps.bankdemo.entities.ProductTypes;
import jpdr.apps.bankdemo.entities.Transaction;
import jpdr.apps.bankdemo.entities.TransactionConcept;

import jpdr.apps.bankdemo.repositories.AccountRepository;
import jpdr.apps.bankdemo.services.exceptions.BankDemoException;
import jpdr.apps.bankdemo.services.exceptions.NotActiveAccountException;
import jpdr.apps.bankdemo.services.exceptions.NotEnoughFundsAccountException;
import jpdr.apps.bankdemo.services.exceptions.NotFoundAccountException;

@Service
public class AccountService {

	@Transient
	public static final int INITIAL_ACCOUNT_NUMBER = 1025550;

	@Transient
	public static final double WELCOME_AMOUNT = 10000.00d;

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private ClientsProductsService clientsProductsService;		
	@Autowired
	private LocaleService localeService;
	


	public AccountService() {
	}

	public Account getAccount(int id) {
		return accountRepository.findById(id).orElse(null);
	}

	public EntitiesList<Account> getAccounts(int clientId) {

		ArrayList<Account> accounts = accountRepository.findAllWithClientId(clientId);

		EntitiesList<Account> clientAccounts = new EntitiesList<Account>();

		if (accounts != null) {
			clientAccounts.setEntities(accounts);
		}

		return clientAccounts;
	}

	public EntitiesList<Account> getActiveAccounts(int clientId) {

		ArrayList<Account> accounts = accountRepository.findAllWithClientIdAndStatus(clientId, "ACTIVE");

		EntitiesList<Account> clientAccounts = new EntitiesList<Account>();

		if (accounts != null) {
			clientAccounts.setEntities(accounts);
		}

		return clientAccounts;
	}

	public EntitiesList<Account> getOtherActiveAccounts(int clientId) {

		ArrayList<Account> accounts = accountRepository.findAllWithClientIdNotLikeAndStatusEquals(clientId, "ACTIVE");

		EntitiesList<Account> otherAccounts = new EntitiesList<Account>();

		if (accounts != null) {
			otherAccounts.setEntities(accounts);
		}

		return otherAccounts;

	}

	public Account openAccount(int clientId, HttpServletRequest request) throws BankDemoException {

		int number = getNextAccountNumber();
		
		//Date date = Calendar.getInstance().getTime();
		////DateFormat dateFormat = new SimpleDateFormat(Transaction.DATE_FORMAT_STRING);
		//DateFormat dateFormat = new SimpleDateFormat(bankDemoConfigProperties.getDateFormatDB());
		//String dateString = dateFormat.format(date);
		
		String dateString = localeService.getCurrentDate();

		Account account = new Account(number, dateString);
		accountRepository.save(account);

		clientsProductsService.addProduct(ProductTypes.PRODUCT_TYPE_ACCOUNT, clientId, account.getId());
		
		//account = addTransaction(account, TransactionConcept.WELCOME_CREDIT, WELCOME_AMOUNT, localeService.getLocalizedMessage("welcomeToBankdemo", request),request);//"Welcome to BankDemo"
		account = addTransaction(account, TransactionConcept.WELCOME_CREDIT, WELCOME_AMOUNT, "",request);//"Welcome to BankDemo"
		
		return account;
	}

	public void closeAccount(int accountNumber) {
		Account account = accountRepository.findByNumber(accountNumber);
		account.setStatus("CLOSED");
		accountRepository.save(account);
	}

	public int getNextAccountNumber() {

		Integer number = accountRepository.getNextAccountNumber();

		if (number == null) {
			number = INITIAL_ACCOUNT_NUMBER;
		} else {
			number++;
		}
		return (int) number;
	}

	public ArrayList<Transaction> getTransactions(Integer accountNumber) {

		Account account = accountRepository.findByNumber(accountNumber);
		return transactionService.getTransactions(account.getId());
		/* 
		EntitiesList<Transaction> transactions = transactionService.getTransactions(account.getId());
		return transactions;
		
		*/

	}

	public Account getAccountByNumber(Integer accountNumber) {
		return accountRepository.findByNumber(accountNumber);
	}

	public Client getClientByAccountId(Integer accountId) {
		return clientService.getClientByProductTypeAndProductId(ProductTypes.PRODUCT_TYPE_ACCOUNT, accountId);
	}

	public Account addTransaction(Account account, int concept, double amount, String details, HttpServletRequest request) throws BankDemoException {

		//Date date = Calendar.getInstance().getTime();
		/////DateFormat dateFormat = new SimpleDateFormat(Transaction.DATE_FORMAT_STRING);
		//DateFormat dateFormat = new SimpleDateFormat(bankDemoConfigProperties.getDateFormatDB());
		//String dateString = dateFormat.format(date);

		String dateString = localeService.getCurrentDate();
		
		Account checkAcount = accountRepository.findById(account.getId()).orElse(null);
		
		if(checkAcount==null) throw new NotFoundAccountException(localeService.getLocalizedMessage(NotFoundAccountException.getMessageKey(), request));		
		if (checkAcount.getStatus().equals("ACTIVE")==false) throw new NotActiveAccountException(localeService.getLocalizedMessage(NotActiveAccountException.getMessageKey(),request));
		if ((checkAcount.getBalance() + amount) < 0) throw new NotEnoughFundsAccountException(localeService.getLocalizedMessage(NotEnoughFundsAccountException.getMessageKey(),request));
		
		transactionService.addTransaction(dateString, account, concept, amount, details);
		account.setBalance(account.getBalance() + amount);
		accountRepository.save(account);

		return account;

	}

	public String getTransactionConcept(int conceptId, HttpServletRequest request) {

		return transactionService.getTransactionConcept(
				conceptId,
				localeService.getLocalizedMessage("bankDemo.language.message",request))
				.getConcept();

	}

	public String getLocalizedDate(String date, HttpServletRequest request) {
		return localeService.getLocalizedDate(date, request);		
	}
	
	
	public double getClientAccountsBalance(int clientId) {
		
		Double balance = accountRepository.getClientAccountsBalance(clientId); 
		
		if ( balance == null ) return 0.0;
		
		return balance; 
	}
	

}
