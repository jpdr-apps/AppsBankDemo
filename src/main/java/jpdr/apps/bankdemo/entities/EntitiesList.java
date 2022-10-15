package jpdr.apps.bankdemo.entities;

import java.util.ArrayList;
import java.util.List;

public class EntitiesList<T> {
	
	List<T> entities = new ArrayList<T>();
	
	public EntitiesList() {	}

	public EntitiesList(List<T> entities) {	
		this.entities = entities;
	}

	public List<T> getEntities() {
		return entities;
	}

	public void setEntities(List<T> entities) {
		this.entities = entities;
	}

	@Override
	public String toString() {
		return "EntitiesList [entities=" + entities + "]";
	}

}
