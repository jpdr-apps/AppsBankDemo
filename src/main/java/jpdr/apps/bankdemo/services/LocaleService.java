package jpdr.apps.bankdemo.services;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import jpdr.apps.bankdemo.configuration.utils.LocaleUtils;

@Service
public class LocaleService {
	
	//@Resource(name = "bankDemoConfigProperties")
	//BankDemoConfigProperties bankDemoConfigProperties;

	@Resource(name ="localeUtils")
	LocaleUtils localeUtils;
	
	//@Resource(name = "localeResolver")
	//LocaleResolver localeResolver;

	public String getLocalizedMessage(String message, HttpServletRequest request) {		
		return localeUtils.getLocalizedMessage(message, request);
	}

	public String getLocalizedDate(String date, HttpServletRequest request) {		
		return localeUtils.getLocalizedDate(date, request);
	}

	public String getCurrentDate() {
		return localeUtils.getCurrentDate();
	}

	public char getDecimalSeparator(HttpServletRequest request) {		
		return localeUtils.getDecimalSeparator(request);
	}

	public String formatDateForDB(String date, HttpServletRequest request) {		
		return localeUtils.formatDateForDB(date, request);
	}
	
	public String getCurrentLanguage(HttpServletRequest request) {
		return localeUtils.getCurrentLanguage(request);
	}

	public void setCurrentLanguage(String language) {
		localeUtils.setCurrentLanguage(language);
	}
	
	public String getDefaultLanguage() {
		return localeUtils.getDefaultLanguage();
	}


}
