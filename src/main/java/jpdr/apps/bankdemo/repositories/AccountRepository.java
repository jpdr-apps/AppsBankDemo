package jpdr.apps.bankdemo.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import jpdr.apps.bankdemo.entities.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {
	
	@Query(value = "SELECT max(number) FROM Account")
	public Integer getNextAccountNumber();
	
	@Query(value = "FROM Account as a , ClientsProducts as b "
			+ "WHERE b.productId = a.id and "
			+ "b.clientId = ?1 and "
			+ "b.productType = 1") //accounts
	public ArrayList<Account> findAllWithClientId(Integer clientId);
	
	@Query(value = "FROM Account as a , ClientsProducts as b "
			+ "WHERE b.productId = a.id and "
			+ "b.clientId = ?1 and "
			+ "b.productType = 1 and "  //accounts
			+ "a.status = ?2") 
	public ArrayList<Account> findAllWithClientIdAndStatus(Integer clientId, String status);
	
	public Account findByNumber(Integer number);
	
	@Query(value = "FROM Account as a , ClientsProducts as b "
			+ "WHERE b.productId = a.id and "
			+ "b.clientId != ?1 and "
			+ "b.productType = 1 and "  //accounts
			+ "a.status = ?2")
	public ArrayList<Account> findAllWithClientIdNotLikeAndStatusEquals(Integer clientId, String status);

	@Query(value = "SELECT SUM(a.balance) FROM Account as a , ClientsProducts as b "
			+ "WHERE b.productId = a.id and "
			+ "b.clientId = ?1 and "
			+ "b.productType = 1 and " 
			+ "a.status = 'ACTIVE'") //accounts
	public Double getClientAccountsBalance(Integer clientId);
	
}
