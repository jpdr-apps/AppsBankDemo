package jpdr.apps.bankdemo.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpdr.apps.bankdemo.configuration.properties.BankDemoConfigProperties;
import jpdr.apps.bankdemo.entities.Account;
import jpdr.apps.bankdemo.entities.EntitiesList;
import jpdr.apps.bankdemo.entities.Payment;
import jpdr.apps.bankdemo.entities.Transaction;
import jpdr.apps.bankdemo.entities.TransactionConcept;
import jpdr.apps.bankdemo.repositories.PaymentRepository;
import jpdr.apps.bankdemo.services.exceptions.BankDemoException;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private LocaleService localeService;

	public Payment addPayment (			
			Integer originAccount, 
			Integer destinationAccount, 
			String destinationDocumentId, 
			String destinationFullName,
			double amount,
			String details,
			HttpServletRequest request
			) throws BankDemoException{
		

		
		
		Account originAccountEntity = accountService.getAccountByNumber(originAccount);
		
		accountService.addTransaction(
				originAccountEntity, 
				TransactionConcept.PAYMENT_DEBIT, 
				amount*-1, 
				String.valueOf(destinationAccount),
				request
				);
		
		Account destinationAccountEntity = accountService.getAccountByNumber(destinationAccount); 		
		
		accountService.addTransaction(
				destinationAccountEntity, 
				TransactionConcept.PAYMENT_CREDIT, 
				amount, 
				String.valueOf(originAccount),
				request
				);
		
		
		//Date date = Calendar.getInstance().getTime();
		//DateFormat dateFormat = new SimpleDateFormat(bankDemoConfigProperties.getDateFormatDB());
		//String dateString = dateFormat.format(date);
		
		String dateString = localeService.getCurrentDate();
		
		Payment payment = new Payment(
				dateString,
				originAccount,
				destinationAccount,
				destinationDocumentId,
				destinationFullName,						
				amount,
				details				
		);
		
		paymentRepository.save(payment);
		
		
	
		return payment;		
		
	}
	
	public ArrayList<Payment> getSentPaymentsByClient(int clientId){
		
		ArrayList<Account> clientAccounts =  (ArrayList<Account>) accountService.getAccounts(clientId).getEntities();		
		
		ArrayList<Payment> payments = new ArrayList<Payment>();
		
		for (int i = 0; i< clientAccounts.size(); i++) {			
			payments.addAll(paymentRepository.findAllByOriginAccountNumber(clientAccounts.get(i).getNumber()));
			
		}
		
		return payments;
		
	}
	
	public ArrayList<Payment> getRecivedPaymentsByClient(int clientId){
		
		ArrayList<Account> clientAccounts =  (ArrayList<Account>) accountService.getAccounts(clientId).getEntities();		
		
		ArrayList<Payment> payments = new ArrayList<Payment>();
		
		for (int i = 0; i< clientAccounts.size(); i++) {			
			payments.addAll(paymentRepository.findAllByDestinationAccountNumber(clientAccounts.get(i).getNumber()));			
		}
		
		return payments;
		
	}

}
