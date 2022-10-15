package jpdr.apps.bankdemo.views;

public class HomeView {
	
	private String clientFirstName;
	private double accountsBalance;
	private double loansBalance;
	
	public HomeView() {
	
	}

	public String getClientFirstName() {
		return clientFirstName;
	}

	public void setClientFirstName(String clientFirstName) {
		this.clientFirstName = clientFirstName;
	}

	public double getAccountsBalance() {
		return accountsBalance;
	}

	public void setAccountsBalance(double accountsBalance) {
		this.accountsBalance = accountsBalance;
	}

	public double getLoansBalance() {
		return loansBalance;
	}

	public void setLoansBalance(double loansBalance) {
		this.loansBalance = loansBalance;
	}

	@Override
	public String toString() {
		return "HomeForm [clientFirstName=" + clientFirstName + ", accountsBalance=" + accountsBalance
				+ ", loansBalance=" + loansBalance + "]";
	}
	
	

}
