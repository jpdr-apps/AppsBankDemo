package jpdr.apps.bankdemo.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;


@ConfigurationProperties( prefix = "bankdemo.properties")
@ConfigurationPropertiesScan 
public class BankDemoConfigProperties {
	
	private String dateFormatDB = "yyyy-MM-dd";
	private String defaultLanguage = "esp";
	
	public BankDemoConfigProperties() {
	
	}

	public String getDateFormatDB() {
		return dateFormatDB;
	}

	public void setDateFormatDB(String dateFormatDB) {
		this.dateFormatDB = dateFormatDB;
	}

	public String getDefaultLanguage() {
		return defaultLanguage;
	}

	public void setDefaultLanguage(String defaultLanguage) {
		this.defaultLanguage = defaultLanguage;
	}
	
	
	
	

}
