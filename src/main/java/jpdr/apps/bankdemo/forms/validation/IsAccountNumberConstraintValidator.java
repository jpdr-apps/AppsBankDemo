package jpdr.apps.bankdemo.forms.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import jpdr.apps.bankdemo.repositories.AccountRepository;

public class IsAccountNumberConstraintValidator implements ConstraintValidator<ValidateIsAccountNumber, String>{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(value==null) return false;

		try {
			Integer accountNumber = Integer.parseInt(value);
			if (accountNumber == 0 ) return false;
			
			if (accountRepository.findByNumber(accountNumber)!= null) return true;
			
		}
		catch (NumberFormatException e) {
			return false;
		}
		
		return false;
	}

}
