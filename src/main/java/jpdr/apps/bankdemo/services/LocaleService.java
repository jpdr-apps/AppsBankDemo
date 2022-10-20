package jpdr.apps.bankdemo.services;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jpdr.apps.bankdemo.configuration.utils.LocaleUtils;

@Service
public class LocaleService {
	
	@Resource(name ="localeUtils")
	LocaleUtils localeUtils;
	
	public String getLocalizedMessage(String message) {		
		return localeUtils.getLocalizedMessage(message);
	}

	public String getLocalizedDate(String date) {		
		return localeUtils.getLocalizedDate(date);
	}

	public String getCurrentDate() {
		return localeUtils.getCurrentDate();
	}

	public char getDecimalSeparator() {		
		return localeUtils.getDecimalSeparator();
	}

	public String formatDateForDB(String date) {		
		return localeUtils.formatDateForDB(date);
	}
	
	public String getCurrentLanguage() {
		return localeUtils.getCurrentLanguage();
	}

	public void setCurrentLanguage(String language) {
		localeUtils.setCurrentLanguage(language);
	}
	
	public String getDefaultLanguage() {
		return localeUtils.getDefaultLanguage();
	}


}
