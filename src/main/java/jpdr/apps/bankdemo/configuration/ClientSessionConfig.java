package jpdr.apps.bankdemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import jpdr.apps.bankdemo.components.ClientSessionInfo;

@Configuration
public class ClientSessionConfig {
	
	@Bean
	@SessionScope
	public ClientSessionInfo clientSessionInfo() {
		return new ClientSessionInfo();
	}
	

}
