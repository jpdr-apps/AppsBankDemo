package jpdr.apps.bankdemo.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jpdr.apps.bankdemo.entities.Account;

import jpdr.apps.bankdemo.entities.Payment;

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
			String originDocumentId,
			String originFullName,
			Integer destinationAccount, 
			String destinationDocumentId, 
			String destinationFullName,
			double amount,
			String details			
			) throws BankDemoException{
		

		
		
		Account originAccountEntity = accountService.getAccountByNumber(originAccount);
		
		accountService.addTransaction(
				originAccountEntity, 
				TransactionConcept.PAYMENT_DEBIT, 
				amount*-1, 
				String.valueOf(destinationAccount)				
				);
		
		Account destinationAccountEntity = accountService.getAccountByNumber(destinationAccount); 		
		
		accountService.addTransaction(
				destinationAccountEntity, 
				TransactionConcept.PAYMENT_CREDIT, 
				amount, 
				String.valueOf(originAccount)				
				);
		
		
		//Date date = Calendar.getInstance().getTime();
		//DateFormat dateFormat = new SimpleDateFormat(bankDemoConfigProperties.getDateFormatDB());
		//String dateString = dateFormat.format(date);
		
		String dateString = localeService.getCurrentDate();
		
		Payment payment = new Payment(
				dateString,
				originAccount,
				originDocumentId,
				originFullName,
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
	
	public ArrayList<Payment> getReceivedPaymentsByClient(int clientId){
		
		ArrayList<Account> clientAccounts =  (ArrayList<Account>) accountService.getAccounts(clientId).getEntities();		
		
		ArrayList<Payment> payments = new ArrayList<Payment>();
		
		for (int i = 0; i< clientAccounts.size(); i++) {			
			payments.addAll(paymentRepository.findAllByDestinationAccountNumber(clientAccounts.get(i).getNumber()));			
		}
		
		return payments;
		
	}
	
	public String getLocalizedDate(String date ) {
		return localeService.getLocalizedDate(date );		
	}
	
	public char getDecimalSeparator() {
		return localeService.getDecimalSeparator();
	}

}
