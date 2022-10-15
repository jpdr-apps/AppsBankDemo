package jpdr.apps.bankdemo.forms.validation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import jpdr.apps.bankdemo.entities.Account;
import jpdr.apps.bankdemo.services.AccountService;
import jpdr.apps.bankdemo.services.LocaleService;

@Component
public class AccountValidations {
	
	@Autowired
	LocaleService localeService;
	
	@Autowired
	AccountService accountService;
	
	public void validateFunds( int accountNumber, double amount, HttpServletRequest request  ,BindingResult bindingResult) {
		
		Account account = accountService.getAccountByNumber(accountNumber);
		
		if ( account.getBalance() < amount ) {
			bindingResult.addError(
					new FieldError("LoanPayForm", "debitAccountNumber", localeService.getLocalizedMessage("bankDemoException.NotEnoughFundsAccountException.message", request))
					);	
		}
		
	}

}
