package jpdr.apps.bankdemo.forms;

public class TransactionFormEntity {
	
	private String date;
	private String concept;
	private String details;
	private double amount;
	private double balance;	
	
	public TransactionFormEntity() {
	
	}

	public TransactionFormEntity(String date, String concept, String details, double amount, double balance) {
 
		this.date = date;
		this.concept = concept;
		this.details = details;
		this.amount = amount;
		this.balance = balance;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "TransactionFormEntity [date=" + date + ", concept=" + concept + ", details=" + details + ", amount="
				+ amount + ", balance=" + balance + "]";
	}
	
	

}
