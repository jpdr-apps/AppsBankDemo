package jpdr.apps.bankdemo.forms;

import java.util.ArrayList;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;



import jpdr.apps.bankdemo.entities.Loan;

import jpdr.apps.bankdemo.forms.validation.ValidateAsDecimal;
import jpdr.apps.bankdemo.forms.validation.ValidateIsAccountNumber;

public class LoanForm {

	
	private int number;
	private String issueDate;
	private String status;
	private char decimalSeparator;
	@Positive
	@ValidateAsDecimal(integerDigits = 18,fractionalDigits = 2)
	private double loanAmount;
	@Min(value = 1)
	@Max(value = 20)
	private int term;
	private int periods;
	private double interestRate;
	private ArrayList<String> internalAccounts;
	@ValidateIsAccountNumber
	private String creditAccountNumber;	
	private double balanceInterest;
	private double balancePrincipal;
	private double balanceTotal;
	private int remainingPeriods;
	private String nextDueDate;
	
	private LoanFormPaymentsList loanFormPayments;
	
	public LoanForm() {
	
	}
	
	public LoanForm(Loan loan, char decimalSeparator, ArrayList<String> internalAccounts) {
		this.issueDate = loan.getIssueDate();
		this.status = loan.getStatus();
		this.decimalSeparator = decimalSeparator;
		this.loanAmount = loan.getLoanAmount();
		this.term = loan.getTerm();
		this.periods = loan.getPeriods();
		this.interestRate = loan.getInterestRate();
		this.internalAccounts = internalAccounts;
		this.creditAccountNumber= String.valueOf(loan.getCreditAccountNumber());
		this.balanceInterest = loan.getBalanceInterest();
		this.balancePrincipal = loan.getBalancePrincipal();		
		this.balanceTotal = loan.getBalanceTotal();		
		this.remainingPeriods = loan.getRemainingPeriods();
		this.nextDueDate = loan.getNextDueDate();
		
	}



	public LoanForm(int number, String issueDate, String status, char decimalSeparator, double loanAmount, int term, int periods,
			double interestRate, String creditAccountNumber, double balanceInterest,
			double balancePrincipal, double balanceTotal, int remainingPeriods, String nextDueDate) {
 
		this.number = number;
		this.issueDate = issueDate;
		this.status = status;
		this.decimalSeparator = decimalSeparator;
		this.loanAmount = loanAmount;
		this.term = term;
		this.periods = periods;
		this.interestRate = interestRate;
		this.creditAccountNumber = creditAccountNumber;
		this.balanceInterest = balanceInterest;
		this.balancePrincipal = balancePrincipal;
		this.balanceTotal = balanceTotal;
		this.remainingPeriods = remainingPeriods;
		this.nextDueDate = nextDueDate;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public char getDecimalSeparator() {
		return decimalSeparator;
	}

	public void setDecimalSeparator(char decimalSeparator) {
		this.decimalSeparator = decimalSeparator;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public int getPeriods() {
		return periods;
	}

	public void setPeriods(int periods) {
		this.periods = periods;
	}

	public double getInterestRate() {
		return interestRate;
	}



	public ArrayList<String> getInternalAccounts() {
		return internalAccounts;
	}

	public void setInternalAccounts(ArrayList<String> internalAccounts) {
		this.internalAccounts = internalAccounts;
	}

	public String getCreditAccountNumber() {
		return creditAccountNumber;
	}
	
	public int getCreditAccountNumberAsInteger() {		
		try {
			return Integer.parseInt(creditAccountNumber); 
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public void setCreditAccountNumber(String creditAccountNumber) {
		this.creditAccountNumber = creditAccountNumber;
	}

	public double getBalanceInterest() {
		return balanceInterest;
	}
 

	public double getBalanceTotal() {
		return balanceTotal;
	}

 

	public LoanFormPaymentsList getLoanFormPayments() {
		return loanFormPayments;
		
	}

	public void setLoanFormPayments(LoanFormPaymentsList loanFormPayments) {
		this.loanFormPayments = loanFormPayments;
		
	}
	
	
		

	public double getBalancePrincipal() {
		return balancePrincipal;
	}

	public void setBalancePrincipal(double balancePrincipal) {
		this.balancePrincipal = balancePrincipal;
	}

	public int getRemainingPeriods() {
		return remainingPeriods;
	}

	public void setRemainingPeriods(int remainingPeriods) {
		this.remainingPeriods = remainingPeriods;
	}

	public String getNextDueDate() {
		return nextDueDate;
	}

	public void setNextDueDate(String nextDueDate) {
		this.nextDueDate = nextDueDate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public void setBalanceInterest(double balanceInterest) {
		this.balanceInterest = balanceInterest;
	}

	public void setBalanceTotal(double balanceTotal) {
		this.balanceTotal = balanceTotal;
	}
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LoanForm [number=" + number + ", issueDate=" + issueDate + ", status=" + status + ", decimalSeparator="
				+ decimalSeparator + ", loanAmount=" + loanAmount + ", term=" + term + ", periods=" + periods
				+ ", interestRate=" + interestRate + ", internalAccounts=" + internalAccounts + ", creditAccountNumber="
				+ creditAccountNumber + ", balanceInterest=" + balanceInterest + ", balancePrincipal="
				+ balancePrincipal + ", balanceTotal=" + balanceTotal
				+ ", remainingPeriods=" + remainingPeriods + ", nextDueDate=" + nextDueDate + ", loanFormPayments="
				+ loanFormPayments + "]";
	}

	
	
}
