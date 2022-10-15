package jpdr.apps.bankdemo.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import jpdr.apps.bankdemo.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer>{
	
	@Query(value = "SELECT max(id) FROM Payment")
	public Integer getMaxId();

	public ArrayList<Payment> findAllByOriginAccountNumber(int number);
	
	public ArrayList<Payment> findAllByDestinationAccountNumber(int number);

}
