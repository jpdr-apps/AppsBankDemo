package jpdr.apps.bankdemo.forms.validation;

import java.util.Locale;

import javax.validation.MessageInterpolator;

public class BankDemoMessageInterpolator implements MessageInterpolator{

	private final MessageInterpolator defaultInterpolator;
	
	public BankDemoMessageInterpolator(MessageInterpolator messageInterpolator) {
		this.defaultInterpolator = messageInterpolator;
	}
	
	@Override
	public String interpolate(String messageTemplate, Context context) {		
		return defaultInterpolator.interpolate(messageTemplate, context, Locale.getDefault());
	}

	@Override
	public String interpolate(String messageTemplate, Context context, Locale locale) {
		return defaultInterpolator.interpolate(messageTemplate, context, locale);
	}

}
