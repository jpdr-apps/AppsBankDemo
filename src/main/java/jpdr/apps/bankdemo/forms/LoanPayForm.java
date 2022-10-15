package jpdr.apps.bankdemo.forms;

import java.util.ArrayList;

public class LoanPayForm {
		
	private int loanNumber;
	private int paymentId;
	private String dueDate;
	private double paymentAmount;
	private double loanBalance;
	private ArrayList<String> internalAccounts;
	private int debitAccountNumber;
	private double debitAccountBalance;
	
	private String paymentDate;		
	private double beginningBalance;
	private double principalAmount;
	private double interestAmount;
	private double endingBalance;	
	
	
	public LoanPayForm() {	
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(int loanNumber) {
		this.loanNumber = loanNumber;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public double getBeginningBalance() {
		return beginningBalance;
	}

	public void setBeginningBalance(double beginningBalance) {
		this.beginningBalance = beginningBalance;
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

	public ArrayList<String> getInternalAccounts() {
		return internalAccounts;
	}

	public void setInternalAccounts(ArrayList<String> internalAccounts) {
		this.internalAccounts = internalAccounts;
	}

	public int getDebitAccountNumber() {
		return debitAccountNumber;
	}

	public void setDebitAccountNumber(int debitAccountNumber) {
		this.debitAccountNumber = debitAccountNumber;
	}

	public double getDebitAccountBalance() {
		return debitAccountBalance;
	}

	public void setDebitAccountBalance(double debitAccountBalance) {
		this.debitAccountBalance = debitAccountBalance;
	}
	
	

	public double getLoanBalance() {
		return loanBalance;
	}

	public void setLoanBalance(double loanBalance) {
		this.loanBalance = loanBalance;
	}

	@Override
	public String toString() {
		return "LoanPayForm [loanNumber=" + loanNumber + ", paymentId=" + paymentId + ", dueDate=" + dueDate
				+ ", paymentAmount=" + paymentAmount + ", loanBalance=" + loanBalance + ", internalAccounts="
				+ internalAccounts + ", debitAccountNumber=" + debitAccountNumber + ", debitAccountBalance="
				+ debitAccountBalance + ", paymentDate=" + paymentDate + ", beginningBalance=" + beginningBalance
				+ ", principalAmount=" + principalAmount + ", interestAmount=" + interestAmount + ", endingBalance="
				+ endingBalance + "]";
	}

 
	
	
	

}
