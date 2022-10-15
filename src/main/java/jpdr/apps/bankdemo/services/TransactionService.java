package jpdr.apps.bankdemo.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpdr.apps.bankdemo.entities.Account;
import jpdr.apps.bankdemo.entities.Transaction;
import jpdr.apps.bankdemo.entities.TransactionConcept;
import jpdr.apps.bankdemo.entities.keys.TransactionConceptId;
import jpdr.apps.bankdemo.repositories.TransactionConceptRepository;
import jpdr.apps.bankdemo.repositories.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	TransactionConceptRepository transactionConceptRepository;
	
	public TransactionService() {}
		
	public void addTransaction(String dateString, Account account, int conceptId, double amount, String detail) {
		
		Transaction transaction = new Transaction(
				dateString,
				account.getId(),				
				conceptId,
				amount,
				detail,
				account.getBalance(),
				account.getBalance()+amount);		
		
		transactionRepository.save(transaction);
		
	}
	
	public ArrayList<Transaction> getTransactions (Integer accountId){
		return  transactionRepository.findByAccountId(accountId);			
	}

	public TransactionConcept getTransactionConcept(int conceptId, String language) {
		return transactionConceptRepository.findById(new TransactionConceptId(conceptId, language)).orElse(null);
	}

	
	

	
}
