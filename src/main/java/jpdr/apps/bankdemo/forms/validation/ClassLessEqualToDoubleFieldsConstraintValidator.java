package jpdr.apps.bankdemo.forms.validation;

import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class ClassLessEqualToDoubleFieldsConstraintValidator
		implements ConstraintValidator<ValidateClassLessEqualToDoubleFields, Object> {

	private String fieldBase;
	private String fieldMatch;

	public void initialize(ValidateClassLessEqualToDoubleFields validateClassLessEqualToDoubleFields) {
		this.fieldBase = validateClassLessEqualToDoubleFields.fieldBase();
		this.fieldMatch = validateClassLessEqualToDoubleFields.fieldMatch();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {

		Double fieldBaseValue = (Double) new BeanWrapperImpl(value).getPropertyValue(fieldBase);
		Double fieldMatchValue = (Double) new BeanWrapperImpl(value).getPropertyValue(fieldMatch);

		if (fieldBaseValue != null && fieldMatchValue != null) {

			if (fieldBaseValue.getClass().equals(fieldMatchValue.getClass())) {
				
				try {
					BigDecimal bigDecimalBaseValue = new BigDecimal(Double.valueOf(fieldBaseValue));
					BigDecimal bigDecimalMatchValue = new BigDecimal(Double.valueOf(fieldMatchValue));
					if( bigDecimalBaseValue.compareTo(bigDecimalMatchValue) <= 0 ) {
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
