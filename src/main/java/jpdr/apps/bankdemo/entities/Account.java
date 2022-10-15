package jpdr.apps.bankdemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="number")
	private int number;
	@Column(name="balance", precision = 18, scale = 2)
	private double balance;
	@Column(name="status")
	private String status;
	@Column(name="date_opening")
	private String dateOpening;
	@Column(name="date_closure")
	private String dateClosure;
	
	public Account() {}
	
	public Account(int number, double balance, String status, String dateOpening, String dateClosure) {
		this.number = number;
		this.balance = balance;
		this.status = status;
		this.dateOpening = dateOpening;
		this.dateClosure = dateClosure;
	}

	public Account(String dateOpening) {				
		this.balance = 0;
		this.status = "ACTIVE";
		this.dateOpening = dateOpening;		
	}

	public Account(int number, String dateOpening) {		
		this.number = number;
		this.balance = 0;
		this.status = "ACTIVE";
		this.dateOpening = dateOpening;		
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getDateOpening() {
		return dateOpening;
	}

	public void setDateOpening(String dateOpening) {
		this.dateOpening = dateOpening;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getDateClosure() {
		return dateClosure;
	}



	public void setDateClosure(String dateClosure) {
		this.dateClosure = dateClosure;
	}



	@Override
	public String toString() {
		return "Account [id=" + id + ", number=" + number + ", balance=" + balance + ", status=" + status
				+ ", dateOpening=" + dateOpening + ", dateClosure=" + dateClosure + "]";
	}


	
	

}
