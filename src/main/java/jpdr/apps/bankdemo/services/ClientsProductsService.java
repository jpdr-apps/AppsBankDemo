package jpdr.apps.bankdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpdr.apps.bankdemo.entities.ClientsProducts;
import jpdr.apps.bankdemo.repositories.ClientsProductsRepository;

@Service
public class ClientsProductsService {
	
	@Autowired
	ClientsProductsRepository clientsProductsRepository;
	
	public ClientsProductsService() {	
	}
	
	public void addProduct(int productType, int clientId, int productId) {
		ClientsProducts clientsProducts = new ClientsProducts(productType, clientId, productId);
		clientsProductsRepository.save(clientsProducts);
	}

}
