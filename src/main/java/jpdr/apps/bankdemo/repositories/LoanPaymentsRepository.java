package jpdr.apps.bankdemo.repositories;

import java.util.ArrayList;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import jpdr.apps.bankdemo.entities.LoanPayment;
import jpdr.apps.bankdemo.entities.keys.LoanPaymentsId;

public interface LoanPaymentsRepository extends CrudRepository<LoanPayment, LoanPaymentsId> {
	
	@Query(value = "FROM LoanPayment as a "
			+ "WHERE a.loanPaymentsId.loanId = ?1" )								
	public ArrayList<LoanPayment> findAllByLoanId(int loanId);

	/*
	@Query(value = "FROM LoanPayment as a " 
			+ "WHERE a.loanPaymentsId.loanId = ?1 "
			+ "and a.status = 'ACTIVE' "
			+ "ORDER BY a.loanPaymentsId.loanId, a.loanPaymentsId.paymenId" )	
	public LoanPayment getNextActivePaymentFromLoan(int loanId, Pageable pageable);
	*/
	public LoanPayment findFirst1ByLoanPaymentsIdLoanIdAndStatusOrderByLoanPaymentsId(int loanId, String status);
	
}
