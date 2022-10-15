package jpdr.apps.bankdemo.repositories;

import org.springframework.data.repository.CrudRepository;

import jpdr.apps.bankdemo.entities.TransactionConcept;
import jpdr.apps.bankdemo.entities.keys.TransactionConceptId;

public interface TransactionConceptRepository extends CrudRepository<TransactionConcept, TransactionConceptId>{

}
