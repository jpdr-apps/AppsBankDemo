package jpdr.apps.bankdemo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import jpdr.apps.bankdemo.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Integer>{
	
	@Query(value = "SELECT max(id) FROM Client")
	public Integer getMaxClientId();
	
	
	@Query(value = "FROM Client as a , ClientsProducts as b "
			+ "WHERE a.id = b.clientId and "					
			+ "b.productType = ?1 and "
			+ "b.productId = ?2" )
	public Client findClientWithProductTypeAndProductId ( int productType, int productId );

}
