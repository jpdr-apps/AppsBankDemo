package jpdr.apps.bankdemo.configuration.utils;

import java.text.DateFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import jpdr.apps.bankdemo.configuration.properties.BankDemoConfigProperties;

public class LocaleUtils {
	
	@Resource(name="messageSource")
	private MessageSource messageSource;
	
	@Resource(name = "localeResolver")
	LocaleResolver localeResolver;
	
	@Resource (name = "localeResolver")
	SessionLocaleResolver sessionLocaleResolver;
	
	@Resource(name = "bankDemoConfigProperties")
	BankDemoConfigProperties bankDemoConfigProperties;
	
	public LocaleUtils() {}
	
	public String getLocalizedDate(String dateValue, HttpServletRequest request) {
		
		/*
		DateFormat dateFormat = new SimpleDateFormat(
				bankDemoConfigProperties.getDateFormatDB()
				);
*/
		LocalDate localDate = LocalDate.parse(dateValue);
		
		
		/*dateFormat = new SimpleDateFormat(				
				getLocalizedMessage("dateFormatUser",request)				
				);
		
		return dateFormat.format(calendar.getTime());*/

		return localDate.format(DateTimeFormatter.ofPattern(getLocalizedMessage("dateFormatUser",request)));
		
	}
	
	public String getLocalizedMessage(String key, HttpServletRequest request) {	
		Locale locale = localeResolver.resolveLocale(request);
		return messageSource.getMessage(key, null, locale);
		
	}
	
	public String getCurrentLanguage(HttpServletRequest request) {
		Locale locale = localeResolver.resolveLocale(request);
		return messageSource.getMessage("bankDemo.language.message", null, locale);		
	}
	
	
	public void setCurrentLanguage(String language) {
		
		if(language!=null) {			
			if(language.equals("esp")) {
				sessionLocaleResolver.setDefaultLocale(Locale.forLanguageTag("es-ES"));
				LocaleContextHolder.setLocale(Locale.forLanguageTag("es-ES"));
			}else {
				sessionLocaleResolver.setDefaultLocale(Locale.US);
				LocaleContextHolder.setLocale(Locale.US);
			}
		}else {
			sessionLocaleResolver.setDefaultLocale(Locale.forLanguageTag("es-ES"));
			LocaleContextHolder.setLocale(Locale.forLanguageTag("es-ES"));
		}		
		
	}
	
	
	
	
	
	public String getCurrentDate() {		
		LocalDate localDate = LocalDate.now();
		String pattern = bankDemoConfigProperties.getDateFormatDB();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern); 
		return localDate.format(formatter);
		
	}
	
	public String formatDateForDB(String dateString, HttpServletRequest request) {
		
		String currentPattern = getLocalizedMessage("dateFormatUser",request);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(currentPattern);
		
		LocalDate localDate = LocalDate.parse(dateString, formatter);
		
		formatter = DateTimeFormatter.ofPattern(bankDemoConfigProperties.getDateFormatDB());		

		return localDate.format(formatter);
		
	}

	public char getDecimalSeparator(HttpServletRequest request) {
		return new DecimalFormatSymbols(localeResolver.resolveLocale(request)).getDecimalSeparator();
	}
	
	public String getDefaultLanguage() {
		return bankDemoConfigProperties.getDefaultLanguage();
	}
	



}
