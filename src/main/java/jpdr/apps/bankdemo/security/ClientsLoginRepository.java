package jpdr.apps.bankdemo.security;

import org.springframework.data.repository.CrudRepository;
 
public interface ClientsLoginRepository extends CrudRepository<ClientsLogin , String> {
	
	public ClientsLogin findByClientId(int clientId);

}
