package jpdr.apps.bankdemo.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import jpdr.apps.bankdemo.configuration.utils.LocaleUtils;

@Configuration
public class LocaleConfig implements WebMvcConfigurer{
	
	@Bean
	public LocaleResolver localeResolver() {
	    SessionLocaleResolver slr = new SessionLocaleResolver();
	    //slr.setDefaultLocale(Locale.US);
	    //slr.setDefaultLocale(Locale.forLanguageTag("es-ES"));
	    return slr;
	}
	
	@Bean
	public LocaleResolver acceptHeaderLocaleResolver() {
		AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
		return acceptHeaderLocaleResolver;
	}
	
	@Bean
	public LocaleUtils localeUtils() {
		return new LocaleUtils();
	}
	

	
}
