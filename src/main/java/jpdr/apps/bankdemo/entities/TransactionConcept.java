package jpdr.apps.bankdemo.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import jpdr.apps.bankdemo.entities.keys.TransactionConceptId;

@Entity
@Table(name = "transaction_concepts")
public class TransactionConcept {
	
	@Transient
	public static final int PAYMENT_DEBIT = 1000;
	@Transient
	public static final int LOAN_DEBIT = 1001;
	@Transient
	public static final int LOAN_CREDIT = 5000;
	@Transient
	public static final int PAYMENT_CREDIT = 5001;
	@Transient
	public static final int WELCOME_CREDIT = 5002;		
	
	@EmbeddedId		
	private TransactionConceptId id;
	@Column(name="concept")
	private String concept;

	public TransactionConcept() {	
	}
	
	
	
	public TransactionConceptId getId() {
		return id;
	}



	public void setId(TransactionConceptId id) {
		this.id = id;
	}



	public String getConcept() {
		return concept;
	}



	public void setConcept(String concept) {
		this.concept = concept;
	}



	@Override
	public String toString() {
		return "TransactionConcept [id=" + id + ", concept=" + concept + "]";
	}


	
}
