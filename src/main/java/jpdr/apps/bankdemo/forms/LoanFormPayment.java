package jpdr.apps.bankdemo.forms;

import java.io.Serializable;

import jpdr.apps.bankdemo.entities.LoanPayment;

public class LoanFormPayment implements Serializable{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 7065604756446042044L;
	private int loandPaymentId;
	private String dueDate;
	private String status;
	private double beginningBalance;
	private double paymentAmount;
	private double principalAmount;
	private double interestAmount;
	private double endingBalance;
	private String paymentDate;
	private int debitAccountNumber;
	
	public LoanFormPayment() {
	
	}
	
	

	public LoanFormPayment(int loandPaymentId, String dueDate, String status, double beginningBalance,
			double paymentAmount, double principalAmount, double interestAmount, double endingBalance, String paymentDate,
			int debitAccountNumber) {		
		this.loandPaymentId = loandPaymentId;
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



	public LoanFormPayment(LoanPayment loanPayment) {
	
		this.loandPaymentId = loanPayment.getLoanPaymentsId().getPaymentId();
		this.dueDate = loanPayment.getDueDate();
		this.status = loanPayment.getStatus();
		this.beginningBalance = loanPayment.getBeginningBalance();
		this.paymentAmount = loanPayment.getPaymentAmount();
		this.principalAmount = loanPayment.getPrincipalAmount();
		this.interestAmount = loanPayment.getInterestAmount();
		this.endingBalance = loanPayment.getEndingBalance();
		this.paymentDate = loanPayment.getPaymentDate();
		this.debitAccountNumber = loanPayment.getDebitAccountNumber();
		
	}

	public int getLoandPaymentId() {
		return loandPaymentId;
	}

	public void setLoandPaymentId(int loandPaymentId) {
		this.loandPaymentId = loandPaymentId;
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
		return "LoanFormPayment [loandPaymentId=" + loandPaymentId + ", dueDate=" + dueDate + ", status=" + status
				+ ", beginningBalance=" + beginningBalance + ", paymentAmount=" + paymentAmount + ", principalAmount="
				+ principalAmount + ", interestAmount=" + interestAmount + ", endingBalance=" + endingBalance
				+ ", paymentDate=" + paymentDate + ", debitAccountNumber=" + debitAccountNumber + "]";
	}

	
	
/*
	@Override	
	public String toString() {
	
		return "[" + 
		String.valueOf(loandPaymentId) + "," +
		dueDate + "," +
		status + "," +
		String.valueOf(beginningBalance) + "," +
		String.valueOf(paymentAmount) + "," +
		String.valueOf(principalAmount) + "," +
		String.valueOf(interestAmount) + "," +
		String.valueOf(endingBalance) + "," +
		paymentDate + "," +
		String.valueOf(debitAccountNumber) + 
		"]"	;
		
	}
	*/
	
}
