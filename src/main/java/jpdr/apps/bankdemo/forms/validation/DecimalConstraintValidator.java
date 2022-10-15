package jpdr.apps.bankdemo.forms.validation;

import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DecimalConstraintValidator implements ConstraintValidator<ValidateAsDecimal, Double> {

	private int integerDigits;
	private int fractionalDigits;
	
	public void initialize( ValidateAsDecimal validateAsDecimal ) {
		
		this.integerDigits = validateAsDecimal.integerDigits();
		this.fractionalDigits = validateAsDecimal.fractionalDigits();
	}
	
	@Override
	public boolean isValid(Double value, ConstraintValidatorContext context) {
		
		if(value==null) {
			return false;
		}

		try {
			BigDecimal bigDecimal = new BigDecimal(Double.toString(value));
			//System.out.println(value);
			///System.out.println(bigDecimal);
			int integerPart = bigDecimal.intValue();
			
			if(String.valueOf(integerPart).length() > integerDigits ) {
				//System.out.println(String.valueOf(integerPart).length());
				//System.out.println(String.valueOf(integerDigits));
				return false;
			}
			if(bigDecimal.subtract(new BigDecimal(integerPart)).toPlainString().length() > fractionalDigits + 2) {
				System.out.println(new BigDecimal(integerPart).toPlainString());
				System.out.println(bigDecimal.subtract(new BigDecimal(integerPart)).toPlainString());
				System.out.println(fractionalDigits+2);
				return false;
			}
		} catch (NumberFormatException nfe) {
			return false;
		}

		return true;
	}

}
