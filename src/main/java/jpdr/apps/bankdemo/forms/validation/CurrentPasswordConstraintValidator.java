package jpdr.apps.bankdemo.forms.validation;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;


import jpdr.apps.bankdemo.components.ClientSessionInfo;
import jpdr.apps.bankdemo.security.ClientsLogin;
import jpdr.apps.bankdemo.security.ClientsLoginRepository;

public class CurrentPasswordConstraintValidator implements ConstraintValidator<ValidateCurrentPassword, String>{

	@Autowired
	ClientsLoginRepository clientsLoginRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Resource(name = "clientSessionInfo")
	ClientSessionInfo clientSessionInfo;	
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
				
		if(value==null) return false;

		if(clientSessionInfo==null) return false;
		
		//if(clientSessionInfo.getClientId()==null) return false;
		
		ClientsLogin clientsLogin = clientsLoginRepository.findByClientId(clientSessionInfo.getClientId());
		
		if(clientsLogin==null) return false;
		
		if( passwordEncoder.matches(value, clientsLogin.getPassword() ) )  return true;
		
		return false;
	}

}
