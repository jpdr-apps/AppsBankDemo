package jpdr.apps.bankdemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {
	
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="date")
	private String date;
	@Column(name="origin_account_number")
	private int originAccountNumber;
	@Column(name="destination_account_number")
	private int destinationAccountNumber;	
	@Column(name="destination_document_id")
	private String destinationDocumentId;
	@Column(name="destination_full_name")
	private String destinationFullName;
	@Column(name="amount", precision = 18, scale = 2)
	private double amount;
	@Column(name="details")
	private String details;
	
	public Payment() {}

	

	public Payment(String date, int originAccountNumber, int destinationAccountNumber, String destinationDocumentId,
			String destinationFullName, double amount, String details) {
		 
		this.date = date;
		this.originAccountNumber = originAccountNumber;
		this.destinationAccountNumber = destinationAccountNumber;
		this.destinationDocumentId = destinationDocumentId;
		this.destinationFullName = destinationFullName;
		this.amount = amount;
		this.details = details;
	}



	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getOriginAccountNumber() {
		return originAccountNumber;
	}

	public void setOriginAccountNumber(int originAccountNumber) {
		this.originAccountNumber = originAccountNumber;
	}

	public int getDestinationAccountNumber() {
		return destinationAccountNumber;
	}

	public void setDestinationAccountNumber(int destinationAccountNumber) {
		this.destinationAccountNumber = destinationAccountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public String getDestinationDocumentId() {
		return destinationDocumentId;
	}

	public void setDestinationDocumentId(String destinationDocumentId) {
		this.destinationDocumentId = destinationDocumentId;
	}

	public String getDestinationFullName() {
		return destinationFullName;
	}

	public void setDestinationFullName(String destinationFullName) {
		this.destinationFullName = destinationFullName;
	}



	@Override
	public String toString() {
		return "Payment [id=" + id + ", date=" + date + ", originAccountNumber=" + originAccountNumber
				+ ", destinationAccountNumber=" + destinationAccountNumber + ", destinationDocumentId=" + destinationDocumentId
				+ ", destinationFullName=" + destinationFullName + ", amount=" + amount + ", details=" + details + "]";
	}

 
	
	

}
