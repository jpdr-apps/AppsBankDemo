package jpdr.apps.bankdemo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import jpdr.apps.bankdemo.entities.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer>{
	
	public ArrayList<Transaction> findByAccountId(Integer accountId);

}
