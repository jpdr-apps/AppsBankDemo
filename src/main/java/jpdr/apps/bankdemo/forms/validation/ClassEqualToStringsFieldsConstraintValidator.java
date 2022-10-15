package jpdr.apps.bankdemo.forms.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class ClassEqualToStringsFieldsConstraintValidator
		implements ConstraintValidator<ValidateClassEqualToStringsFields, Object> {

	private String fieldBase;
	private String fieldMatch;

	public void initialize(ValidateClassEqualToStringsFields validateClassEqualToStringsFields) {
		this.fieldBase = validateClassEqualToStringsFields.fieldBase();
		this.fieldMatch = validateClassEqualToStringsFields.fieldMatch();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {

		String fieldBaseValue = (String) new BeanWrapperImpl(value).getPropertyValue(fieldBase);
		String fieldMatchValue = (String) new BeanWrapperImpl(value).getPropertyValue(fieldMatch);

		if (fieldBaseValue != null && fieldMatchValue != null) {

			if (fieldBaseValue.getClass().equals(fieldMatchValue.getClass())) {
				if (fieldBaseValue.equals(fieldMatchValue)) {
					return true;
				} 
			}
		}

		return false;
	}
}
