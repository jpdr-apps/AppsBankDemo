package jpdr.apps.bankdemo.forms.validation;

import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class ClassEqualToFloatFieldsConstraintValidator
		implements ConstraintValidator<ValidateClassEqualToFloatFields, Object> {

	private String fieldBase;
	private String fieldMatch;

	public void initialize(ValidateClassEqualToFloatFields validateClassEqualToFloatFields) {
		this.fieldBase = validateClassEqualToFloatFields.fieldBase();
		this.fieldMatch = validateClassEqualToFloatFields.fieldMatch();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {

		Float fieldBaseValue = (Float) new BeanWrapperImpl(value).getPropertyValue(fieldBase);
		Float fieldMatchValue = (Float) new BeanWrapperImpl(value).getPropertyValue(fieldMatch);

		if (fieldBaseValue != null && fieldMatchValue != null) {

			if (fieldBaseValue.getClass().equals(fieldMatchValue.getClass())) {
				
				try {
					BigDecimal bigDecimalBaseValue = new BigDecimal(Float.valueOf(fieldBaseValue));
					BigDecimal bigDecimalMatchValue = new BigDecimal(Float.valueOf(fieldMatchValue));
					if( bigDecimalBaseValue.compareTo(bigDecimalMatchValue) == 0 ) {
						return true;
					}
				} catch (NumberFormatException nfe) {
					return false;
				}
			}
		}

		return false;
	}
}
