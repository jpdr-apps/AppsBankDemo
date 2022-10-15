package jpdr.apps.bankdemo.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import jpdr.apps.bankdemo.entities.Loan;

public interface LoanRepository extends CrudRepository<Loan, Integer>{

	@Query(value = "SELECT max(number) FROM Loan")	
	public Integer getNextLoanNumber();

	
	@Query(value = "FROM Loan as a , ClientsProducts as b "
			+ "WHERE b.productId = a.id and "
			+ "b.clientId = ?1 and "
			+ "b.productType = 2 and "  //accounts
			+ "a.status = ?2") 
	public ArrayList<Loan> findAllWithClientIdAndStatus(Integer clientId, String string);
	
	public Loan findByNumber(Integer loanNumber);

	@Query(value = "SELECT SUM(a.balanceTotal) FROM Loan as a , ClientsProducts as b "
			+ "WHERE b.productId = a.id and "
			+ "b.clientId = ?1 and "
			+ "b.productType = 2 and "  //accounts
			+ "a.status = 'ACTIVE'")
	public Double getClientLoansBalance(int clientId);

}
