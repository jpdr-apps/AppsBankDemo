package jpdr.apps.bankdemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients_settings")
public class ClientSettings {
	
	@Id	
	@Column(name="client_id")
	private int clientId;
	@Column(name="language")
	private String language;

	public ClientSettings() {
		 
	}

	public ClientSettings(int clientId, String language) {
		 
		this.clientId = clientId;
		this.language = language;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "ClientSettings [clientId=" + clientId + ", language=" + language + "]";
	}
	
	
	
	

}
