package jpdr.apps.bankdemo.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name =  "clients_login")
public class ClientsLogin {
	
	@Id		
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="enabled")
	private int enabled;
	@Column(name="client_id")
	private int clientId;
	
	public ClientsLogin() {
		 
	}

	public ClientsLogin(String username, String password, int enabled, int clientId) {
		 
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.clientId = clientId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	
	public int getClientId() {
		return clientId;
	}



	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "ClientsLogin [username=" + username + ", password=" + password + ", enabled=" + enabled + ", clientId="
				+ clientId + "]";
	}
	

	

}
