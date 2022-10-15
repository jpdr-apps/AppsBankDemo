package jpdr.apps.bankdemo.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpdr.apps.bankdemo.configuration.properties.BankDemoConfigProperties;
import jpdr.apps.bankdemo.entities.Client;
import jpdr.apps.bankdemo.entities.ClientSettings;
import jpdr.apps.bankdemo.entities.Transaction;
import jpdr.apps.bankdemo.forms.RegisterForm;
import jpdr.apps.bankdemo.forms.SettingsForm;
import jpdr.apps.bankdemo.repositories.ClientRepository;
import jpdr.apps.bankdemo.repositories.ClientSettingsRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ClientSettingsRepository clientSettingsRepository;
	
	@Autowired
	private BankDemoConfigProperties bankDemoConfigProperties;
	
	public ClientService() {}
	
	public Client getClientById(int id) {		
		return clientRepository.findById(id).orElse(null);
	}
	
	public Client getClientByProductTypeAndProductId(int productType, int productId) {
		return clientRepository.findClientWithProductTypeAndProductId(productType, productId);
	}

	public int getMaxClientId() {
		return clientRepository.getMaxClientId();		
	}

	public Client addClient(RegisterForm registerForm) {
		
		Client client = new Client(
				registerForm.getFirstName(),
				registerForm.getLastName(),
				registerForm.getDocumentId(),
				"1950-01-01"
				);
		clientRepository.save(client);
		return client;
		
	}

	public void updateClient(Client client) {

		clientRepository.save(client);
		
	}
	
	public void saveSettings(ClientSettings clientSettings) {
		
		clientSettingsRepository.save(clientSettings);
		
	}
	
	public ClientSettings getClientSettings(int clientId) {
		ClientSettings clientSettings = clientSettingsRepository.findById(clientId).orElse(null);
		if ( clientSettings == null ) {
			clientSettings = new ClientSettings(clientId, bankDemoConfigProperties.getDefaultLanguage());
			clientSettingsRepository.save(clientSettings);
		}
		return clientSettings;
	}
	
}
