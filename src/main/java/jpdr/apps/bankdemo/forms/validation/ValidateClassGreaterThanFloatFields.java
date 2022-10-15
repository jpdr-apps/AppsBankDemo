package jpdr.apps.bankdemo.forms.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ClassGreaterThanFloatFieldsConstraintValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateClassGreaterThanFloatFields {
	
	public String message() default "{ValidateClassGreaterThanFloatFields.message}";
	
	String fieldBase();
	String fieldMatch();
	
	
	@Target({ElementType.TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@interface List {
		ValidateClassGreaterThanFloatFields[] value();
	}
	
	public Class<?>[] groups() default {};  
	
	public Class<? extends Payload>[] payload() default {};  

}
