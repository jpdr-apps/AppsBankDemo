package jpdr.apps.bankdemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "product_types")
public class ProductTypes {
	
	@Transient
	public static final int PRODUCT_TYPE_ACCOUNT = 1;
	@Transient
	public static final int PRODUCT_TYPE_LOAN = 2;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	
	public ProductTypes() {	
	}

	public ProductTypes(String name) {
		 
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductTypes [id=" + id + ", name=" + name + "]";
	}
	
	

}
