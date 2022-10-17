package jpdr.apps.bankdemo.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import jpdr.apps.bankdemo.entities.keys.LoanPaymentsId;

@Entity
@Table(name = "loan_payments")
public class LoanPayment{
	
	@EmbeddedId
	private LoanPaymentsId loanPaymentsId;	
	@Column(name = "due_date")
	private String dueDate;
	@Column(name = "status")
	private String status;
	@Column(name = "beginning_balance", precision = 18, scale = 2)
	private double beginningBalance;
	@Column(name = "payment_amount", precision = 18, scale = 2)
	private double paymentAmount;
	@Column(name = "principal_amount", precision = 18, scale = 2)
	private double principalAmount;
	@Column(name = "interest_amount", precision = 18, scale = 2)
	private double interestAmount;
	@Column(name = "ending_balance", precision = 18, scale = 2)
	private double endingBalance;
	@Column(name = "payment_date")
	private String paymentDate;
	@Column(name = "debit_account_number")
	private int debitAccountNumber;
	
	public LoanPayment() {
	
	}
	
	
	
	public LoanPayment(LoanPaymentsId loanPaymentsId, String dueDate, String status, double beginningBalance,
			double paymentAmount, double principalAmount, double interestAmount, double endingBalance, String paymentDate,
			int debitAccountNumber) {
		 
		this.loanPaymentsId = loanPaymentsId;
		this.dueDate = dueDate;
		this.status = status;
		this.beginningBalance = beginningBalance;
		this.paymentAmount = paymentAmount;
		this.principalAmount = principalAmount;
		this.interestAmount = interestAmount;
		this.endingBalance = endingBalance;
		this.paymentDate = paymentDate;
		this.debitAccountNumber = debitAccountNumber;
	}



	public LoanPayment(LoanPaymentsId loanPaymentsId, String dueDate, String status, double beginningBalance,
			double paymentAmount, double principalAmount, double interestAmount, double endingBalance, String paymentDate) {
		
		this.loanPaymentsId = loanPaymentsId;
		this.dueDate = dueDate;
		this.status = status;
		this.beginningBalance = beginningBalance;
		this.paymentAmount = paymentAmount;
		this.principalAmount = principalAmount;
		this.interestAmount = interestAmount;
		this.endingBalance = endingBalance;
		this.paymentDate = paymentDate;
	}

	public LoanPayment(String dueDate, String status, double beginningBalance,
			double paymentAmount, double principalAmount, double interestAmount, double endingBalance, String paymentDate) {
		
		this.dueDate = dueDate;
		this.status = status;
		this.beginningBalance = beginningBalance;
		this.paymentAmount = paymentAmount;
		this.principalAmount = principalAmount;
		this.interestAmount = interestAmount;
		this.endingBalance = endingBalance;
		this.paymentDate = paymentDate;
	}

	
	
	
	
	
	public LoanPaymentsId getLoanPaymentsId() {
		return loanPaymentsId;
	}

	public void setLoanPaymentsId(LoanPaymentsId loanPaymentsId) {
		this.loanPaymentsId = loanPaymentsId;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getBeginningBalance() {
		return beginningBalance;
	}

	public void setBeginningBalance(double beginningBalance) {
		this.beginningBalance = beginningBalance;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public double getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(double principalAmount) {
		this.principalAmount = principalAmount;
	}

	public double getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(double interestAmount) {
		this.interestAmount = interestAmount;
	}

	public double getEndingBalance() {
		return endingBalance;
	}

	public void setEndingBalance(double endingBalance) {
		this.endingBalance = endingBalance;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getDebitAccountNumber() {
		return debitAccountNumber;
	}

	public void setDebitAccountNumber(int debitAccountNumber) {
		this.debitAccountNumber = debitAccountNumber;
	}

	@Override
	public String toString() {
		return "LoanPayments [loanPaymentsId=" + loanPaymentsId + ", dueDate=" + dueDate + ", status=" + status
				+ ", beginningBalance=" + beginningBalance + ", paymentAmount=" + paymentAmount + ", principalAmount="
				+ principalAmount + ", interestAmount=" + interestAmount + ", endingBalance=" + endingBalance
				+ ", paymentDate=" + paymentDate + ", debitAccountNumber=" + debitAccountNumber + "]";
	}

 
 
	
	

}
