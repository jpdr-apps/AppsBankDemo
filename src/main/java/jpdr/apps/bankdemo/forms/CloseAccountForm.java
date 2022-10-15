package jpdr.apps.bankdemo.forms;

public class CloseAccountForm {
	
	private int accountNumber;
	
	public CloseAccountForm() {}
	
	public CloseAccountForm(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "CloseAccountForm [accountNumber=" + accountNumber + "]";
	}
	
	
	

}
