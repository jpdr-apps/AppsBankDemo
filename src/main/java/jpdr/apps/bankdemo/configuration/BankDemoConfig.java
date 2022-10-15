package jpdr.apps.bankdemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import jpdr.apps.bankdemo.configuration.properties.BankDemoConfigProperties;

@Configuration
public class BankDemoConfig {

	@Bean
	public BankDemoConfigProperties bankDemoConfigProperties() {
		return new BankDemoConfigProperties();
	}
 
	
}
