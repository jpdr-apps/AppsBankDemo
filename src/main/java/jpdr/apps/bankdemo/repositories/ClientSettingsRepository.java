package jpdr.apps.bankdemo.repositories;

import org.springframework.data.repository.CrudRepository;

import jpdr.apps.bankdemo.entities.ClientSettings;

public interface ClientSettingsRepository extends CrudRepository<ClientSettings, Integer>{

}
