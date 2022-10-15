package jpdr.apps.bankdemo.forms.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ClassLessEqualToDoubleFieldsConstraintValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateClassLessEqualToDoubleFields {
	
	public String message() default "{ValidateClassLessEqualToDoubleFields.message}";
	
	String fieldBase();
	String fieldMatch();
	
	
	@Target({ElementType.TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@interface List {
		ValidateClassLessEqualToDoubleFields[] value();
	}
	
	public Class<?>[] groups() default {};  
	
	public Class<? extends Payload>[] payload() default {};  

}
