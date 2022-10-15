package jpdr.apps.bankdemo.forms.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = DecimalConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateAsDecimal {
	
	public String message() default "{ValidateAsDecimal.message}";
	
	public Class<?>[] groups() default {};  
	
	public Class<? extends Payload>[] payload() default {};  
	
	int integerDigits();
	int fractionalDigits();

}
