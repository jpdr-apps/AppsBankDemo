package jpdr.apps.bankdemo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import jpdr.apps.bankdemo.entities.ClientsProducts;

public interface ClientsProductsRepository extends CrudRepository<ClientsProducts, Integer>{

	public ArrayList<ClientsProducts> findAllByProductTypeAndClientId(Integer productType, Integer clientId);
		
}
