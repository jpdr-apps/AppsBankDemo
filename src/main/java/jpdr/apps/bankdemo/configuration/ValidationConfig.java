package jpdr.apps.bankdemo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class ValidationConfig implements WebMvcConfigurer {
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		
		//registry.addConverter(new StringToLoanPaymentConverter());
		//registry.addConverter(new StringToLoanPaymentIdConverter());
		//registry.addConverter(new StringToLoanPaymentsListConverter());
		
	}
	


}
