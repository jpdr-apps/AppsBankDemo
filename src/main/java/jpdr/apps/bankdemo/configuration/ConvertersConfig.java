package jpdr.apps.bankdemo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jpdr.apps.bankdemo.entities.converters.StringToLoanFormPaymentListConverter;

@Configuration
public class ConvertersConfig implements WebMvcConfigurer{

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToLoanFormPaymentListConverter());
    }
	
}
