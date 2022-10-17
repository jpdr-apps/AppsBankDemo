package jpdr.apps.bankdemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients_products")
public class ClientsProducts {
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="product_type")
	private int productType;
	@Column(name="client_id")
	private int clientId;	
	@Column(name="product_id")
	private int productId;
	
	public ClientsProducts() {
	
	}
	
	
	 
	public ClientsProducts(int productType, int clientId, int productId) {
 
		this.productType = productType;
		this.clientId = clientId;
		this.productId = productId;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "ClientsProducts [id=" + id + ", productType=" + productType + ", clientId=" + clientId + ", productId="
				+ productId + "]";
	}

 

	 
 
	

}
