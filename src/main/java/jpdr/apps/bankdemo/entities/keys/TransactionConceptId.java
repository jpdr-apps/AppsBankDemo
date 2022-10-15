package jpdr.apps.bankdemo.entities.keys;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class TransactionConceptId implements Serializable{

	/**
	 *
	 */
	@Transient
	private static final long serialVersionUID = -2491431580842098357L;
	
	@Column(name = "id")
	private int id;
	@Column(name = "language")
	private String language;
	
	public TransactionConceptId() {
	
	}

	public TransactionConceptId(int id, String language) {
		super();
		this.id = id;
		this.language = language;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, language);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionConceptId other = (TransactionConceptId) obj;
		return id == other.id && Objects.equals(language, other.language);
	}

	@Override
	public String toString() {
		return "TransactionConceptId [id=" + id + ", language=" + language + "]";
	}
	
	

}
