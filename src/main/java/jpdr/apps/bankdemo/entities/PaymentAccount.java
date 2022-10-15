package jpdr.apps.bankdemo.entities;

public class PaymentAccount {
	
	private int number;
	private double balance;
	
	public PaymentAccount() {}

	public PaymentAccount(int number, double balance) {		
		this.number = number;
		this.balance = balance;
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

	@Override
	public String toString() {
		return "PaymentAccount [number=" + number + ", balance=" + balance + "]";
	}
	
	
	

}
