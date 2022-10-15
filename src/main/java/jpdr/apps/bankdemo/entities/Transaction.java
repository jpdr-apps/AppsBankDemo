package jpdr.apps.bankdemo.entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "transactions")
public class Transaction {
	
	@Transient
	public static final String DATE_FORMAT_STRING = "yyyy-MM-dd";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="date")
	private String date;
	@Column(name="account_id")
	private int accountId;	
	@Column(name="concept_id")	
	private int conceptId;	
	@Column(name="amount", precision = 18, scale = 2)
	private double amount;
	@Column(name="details")
	private String details;
	@Column(name="previous_balance", precision = 18, scale = 2)
	private double previousBalance;
	@Column(name="result_balance", precision = 18, scale = 2)
	private double resultBalance;
	
	public Transaction() {
	
	}

 

	public Transaction(String date, int accountId, int conceptId, double amount, String details, double previousBalance,
			double resultBalance) {
 
		this.date = date;
		this.accountId = accountId;
		this.conceptId = conceptId;
		this.amount = amount;
		this.details = details;
		this.previousBalance = previousBalance;
		this.resultBalance = resultBalance;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getLocalizedDate(String datePatternUser, String datePatternDB) {
		
		DateFormat dateFormat = new SimpleDateFormat(datePatternDB);

		Calendar calendar = Calendar.getInstance(); 
				
		try {
			calendar.setTime(dateFormat.parse(this.date));			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		dateFormat = new SimpleDateFormat(datePatternUser);
		
		return dateFormat.format(calendar.getTime());

	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getResultBalance() {
		return resultBalance;
	}

	public void setResultBalance(double resultBalance) {
		this.resultBalance = resultBalance;
	}

	public double getPreviousBalance() {
		return previousBalance;
	}

	public void setPreviousBalance(double previousBalance) {
		this.previousBalance = previousBalance;
	}

	public String getDetails() {
		return details;
	}



	public void setDetails(String details) {
		this.details = details;
	}



	public int getConceptId() {
		return conceptId;
	}



	public void setConceptId(int conceptId) {
		this.conceptId = conceptId;
	}



	@Override
	public String toString() {
		return "Transaction [date=" + date + ", accountId=" + accountId + ", conceptId=" + conceptId + ", amount="
				+ amount + ", details=" + details + ", previousBalance=" + previousBalance + ", resultBalance="
				+ resultBalance + "]";
	}





 
 


	
	

}
