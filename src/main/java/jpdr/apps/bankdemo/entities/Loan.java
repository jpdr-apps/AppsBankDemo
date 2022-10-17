package jpdr.apps.bankdemo.entities;

import java.util.ArrayList;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "loans")
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	@Column(name ="number")
	private int number;
	@Column(name ="issue_date")
	private String issueDate;
	@Column(name ="status")
	private String status;
	@Column(name ="loan_amount", precision = 18, scale = 2)
	private double loanAmount;	
	@Column(name ="term")
	private int term;	
	@Column(name ="periods")
	private int periods;
	@Column(name ="interest_rate", precision = 18, scale = 2)
	private double interestRate;
	@Column(name ="interest_amount", precision = 18, scale = 2)
	private double interestAmount;
	@Column(name ="credit_account_number")
	private int creditAccountNumber;
	@Column(name ="balance_interest", precision = 18, scale = 2)
	private double balanceInterest;
	@Column(name ="balance_principal", precision = 18, scale = 2)
	private double balancePrincipal;
	@Column(name ="balance_total", precision = 18, scale = 2)
	private double balanceTotal;
	@Column(name ="remaining_periods", precision = 18, scale = 2)
	private int remainingPeriods;
	@Column(name ="next_due_date")
	private String nextDueDate;

	
	
	@Transient
	private String loanPaymentsJSON;
	
	@Transient
	private ArrayList<LoanPayment> loanPayments;
	
	
	public Loan() {
	
	}

	public Loan(int number, String issueDate, String status, double loanAmount, int term, double interestRate) {		
		this.number = number;
		this.issueDate = issueDate;
		this.status = status;
		this.loanAmount = loanAmount;
		this.term = term;
		this.periods = this.term * 12;
		this.remainingPeriods = this.periods;
		this.interestRate = interestRate;
	}



	public Loan(String issueDate, String status, double loanAmount, int term, int periods,
			double interestRate, int creditAccountNumber) {				
		this.issueDate = issueDate;
		this.status = status;
		this.loanAmount = loanAmount;
		this.term = term;
		this.periods = periods;
		this.remainingPeriods = this.periods;
		this.interestRate = interestRate;
		this.creditAccountNumber = creditAccountNumber;
	}
	
	
	

	public Loan(int number, String issueDate, String status, double loanAmount, int term, int periods,
			double interestRate, double interestAmount, int creditAccountNumber, double balanceInterest, double balancePrincipal,
			double balanceTotal, int remainingPeriods, String nextDueDate) {

		this.number = number;
		this.issueDate = issueDate;
		this.status = status;
		this.loanAmount = loanAmount;
		this.term = term;
		this.periods = periods;
		this.interestRate = interestRate;
		this.interestAmount = interestAmount;
		this.creditAccountNumber = creditAccountNumber;
		this.balanceInterest = balanceInterest;
		this.balancePrincipal = balancePrincipal;
		this.balanceTotal = balanceTotal;
		this.remainingPeriods = remainingPeriods;
		this.nextDueDate = nextDueDate;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
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

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getBalanceInterest() {
		return balanceInterest;
	}

	public void setBalanceInterest(double balanceInterest) {
		this.balanceInterest = balanceInterest;
	}

	public double getBalancePrincipal() {
		return balancePrincipal;
	}

	public void setBalancePrincipal(double balancePrincipal) {
		this.balancePrincipal = balancePrincipal;
	}

	public double getBalanceTotal() {
		return balanceTotal;
	}

	public void setBalanceTotal(double balanceTotal) {
		this.balanceTotal = balanceTotal;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public int getCreditAccountNumber() {
		return creditAccountNumber;
	}

	public void setCreditAccountNumber(int creditAccountNumber) {
		this.creditAccountNumber = creditAccountNumber;
	}

	public String getLoanPaymentsJSON() {
		return loanPaymentsJSON;
	}

	public void setLoanPaymentsJSON(String loanPaymentsJSON) {
		this.loanPaymentsJSON = loanPaymentsJSON;
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
	
	
/*
	public List<LoanPayment> getLoanPayments(){
				
		try {
			return new ObjectMapper().readValue(this.loanPaymentsJSON, new TypeReference<List<LoanPayment>>(){} );
		} catch (JsonMappingException e) {			
			e.printStackTrace();
			return null;
		} catch (JsonProcessingException e) {		
			e.printStackTrace();
			return null;
		}
				
	}
	*/
/*	
	public void setLoanPayments(List<LoanPayment> loanPayments) {

		try {
			this.loanPaymentsJSON = new ObjectMapper().writeValueAsString(loanPayments);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
	}
*/
	
	public double getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(double interestAmount) {
		this.interestAmount = interestAmount;
	}

	public ArrayList<LoanPayment> getLoanPayments(){
		
		return this.loanPayments;
				
	}
	

	public void setLoanPayments(ArrayList<LoanPayment> loanPayments) {
		this.loanPayments = loanPayments;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", number=" + number + ", issueDate=" + issueDate + ", status=" + status
				+ ", loanAmount=" + loanAmount + ", term=" + term + ", periods=" + periods + ", interestRate="
				+ interestRate + ", interestAmount=" + interestAmount + ", creditAccountNumber=" + creditAccountNumber
				+ ", balanceInterest=" + balanceInterest + ", balancePrincipal=" + balancePrincipal + ", balanceTotal="
				+ balanceTotal + ", remainingPeriods=" + remainingPeriods + ", nextDueDate=" + nextDueDate
				+ ", loanPaymentsJSON=" + loanPaymentsJSON + ", loanPayments=" + loanPayments + "]";
	}






 

}
