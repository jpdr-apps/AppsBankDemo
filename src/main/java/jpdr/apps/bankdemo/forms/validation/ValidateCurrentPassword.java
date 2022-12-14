package jpdr.apps.bankdemo.forms.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CurrentPasswordConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateCurrentPassword {

	public String message() default "{ValidateClassCurrentPassword.message}";
	
	public Class<?>[] groups() default {};  
	
	public Class<? extends Payload>[] payload() default {}; 
	
}
