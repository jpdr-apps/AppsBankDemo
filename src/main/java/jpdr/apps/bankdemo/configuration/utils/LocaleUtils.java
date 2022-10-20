package jpdr.apps.bankdemo.configuration.utils;


import java.text.DecimalFormatSymbols;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.LocaleResolver;


import jpdr.apps.bankdemo.configuration.properties.BankDemoConfigProperties;

public class LocaleUtils {
	
	@Resource(name="messageSource")
	private MessageSource messageSource;
		
	@Autowired
	LocaleResolver localeResolver;
	
	@Autowired
	HttpServletRequest httpServletRequest;
	
	@Autowired
	HttpServletResponse httpServletResponse;
	
	@Resource(name = "bankDemoConfigProperties")
	BankDemoConfigProperties bankDemoConfigProperties;
	
	public LocaleUtils() {}
	
	public String getLocalizedDate(String dateValue) {
		
		if (dateValue != null) {
			
			if ( dateValue.equals("") == false ) {
			
			LocalDate localDate = LocalDate.parse(dateValue);
			return localDate.format(DateTimeFormatter.ofPattern(getLocalizedMessage("dateFormatUser")));
			
			}
		}
		
		return "";
	}
	
	public String getLocalizedMessage(String key) {
		Locale locale = localeResolver.resolveLocale(httpServletRequest);
		return messageSource.getMessage(key, null, locale);
		
	}
	
	public String getCurrentLanguage() {
		Locale locale = localeResolver.resolveLocale(httpServletRequest);
		return messageSource.getMessage("bankDemo.language.message", null, locale);		
	}
	
	
	public void setCurrentLanguage(String language) {

		if(language!=null) {		

			switch (language){
				case "esp": {
					localeResolver.setLocale(httpServletRequest, httpServletResponse, Locale.forLanguageTag("es-ES"));
					LocaleContextHolder.setLocale(Locale.forLanguageTag("es-ES"));
					break;
				}
				case "eng": {
					localeResolver.setLocale(httpServletRequest, httpServletResponse, Locale.US);
					LocaleContextHolder.setLocale(Locale.US);
					break;
				}			
				default:
					localeResolver.setLocale(httpServletRequest, httpServletResponse, Locale.forLanguageTag("es-ES"));
					LocaleContextHolder.setLocale(Locale.forLanguageTag("es-ES"));				
					break;
			}
		}
		
	}
	
	
	
	
	
	public String getCurrentDate() {		
		LocalDate localDate = LocalDate.now();
		String pattern = bankDemoConfigProperties.getDateFormatDB();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern); 
		return localDate.format(formatter);
		
	}
	
	public String formatDateForDB(String dateString) {
		
		if ( dateString != null  ) {
			
			if ( dateString.equals("") == false ) {
			
				String currentPattern = getLocalizedMessage("dateFormatUser");
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern(currentPattern);
				
				LocalDate localDate = LocalDate.parse(dateString, formatter);
				
				formatter = DateTimeFormatter.ofPattern(bankDemoConfigProperties.getDateFormatDB());		
		
				return localDate.format(formatter);
		
			}
		}
		
		return "";
		
	}

	public char getDecimalSeparator() {
		return new DecimalFormatSymbols(localeResolver.resolveLocale(httpServletRequest)).getDecimalSeparator();
	}
	
	public String getDefaultLanguage() {
		return bankDemoConfigProperties.getDefaultLanguage();
	}
	



}
