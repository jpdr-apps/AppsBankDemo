package jpdr.apps.bankdemo.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jpdr.apps.bankdemo.entities.converters.StringToLoanPaymentConverter;
import jpdr.apps.bankdemo.entities.converters.StringToLoanPaymentIdConverter;
import jpdr.apps.bankdemo.entities.converters.StringToLoanPaymentsListConverter;

@Configuration
public class ValidationConfig implements WebMvcConfigurer {
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		
		//registry.addConverter(new StringToLoanPaymentConverter());
		//registry.addConverter(new StringToLoanPaymentIdConverter());
		//registry.addConverter(new StringToLoanPaymentsListConverter());
		
	}
	


}
