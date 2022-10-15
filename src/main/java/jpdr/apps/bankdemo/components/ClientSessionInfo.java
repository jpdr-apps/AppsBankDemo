package jpdr.apps.bankdemo.components;

public class ClientSessionInfo {
	
	private int clientId;
	private String firstName;
	private String lastName;	

	public ClientSessionInfo() {
		this.clientId = -1;
	}

	public ClientSessionInfo(int clientId, String firstName, String lastName) {		 
		this.clientId = clientId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
 

	@Override
	public String toString() {
		return "ClientSessionInfo [clientId=" + clientId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

 
	
	
}
