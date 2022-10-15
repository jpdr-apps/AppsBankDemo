package jpdr.apps.bankdemo.forms.validation;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import jpdr.apps.bankdemo.components.ClientSessionInfo;
import jpdr.apps.bankdemo.security.ClientsLogin;
import jpdr.apps.bankdemo.security.ClientsLoginRepository;

public class UsernameNotExistsConstraintValidator implements ConstraintValidator<ValidateUsernameNotExists, String>{
	
	@Autowired
	ClientsLoginRepository clientsLoginRepository;
	
	@Resource(name = "clientSessionInfo")
	ClientSessionInfo clientSessionInfo;	
	

	public void initialize( ValidateUsernameNotExists validateUsernameNotExists ) {
		
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if(value==null) return false;

		ClientsLogin newClientsLogin = clientsLoginRepository.findById(value).orElse(null);
		
		if( newClientsLogin == null) {
			return true;
		}else {
			
			if(clientSessionInfo==null) return false;
			
			//if(clientSessionInfo.getClientId()==null) return false;
			
			ClientsLogin currentClientsLogin = clientsLoginRepository.findByClientId(clientSessionInfo.getClientId());
			
			if(currentClientsLogin == null) return false;
			
			if ( newClientsLogin.getUsername().equals(currentClientsLogin.getUsername()) ) return true;
				
		}
		
		
		return false;
	}

}
