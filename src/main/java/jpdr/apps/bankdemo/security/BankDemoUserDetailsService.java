package jpdr.apps.bankdemo.security;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jpdr.apps.bankdemo.forms.LoginForm;
import jpdr.apps.bankdemo.forms.MyUserAccountForm;
import jpdr.apps.bankdemo.forms.RegisterForm;

@Service
public class BankDemoUserDetailsService implements UserDetailsService{

	@Autowired
	ClientsLoginRepository clientsLoginRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		final ClientsLogin clientsLogin = clientsLoginRepository.findById(username).orElse(null);
		
		if(clientsLogin==null) {
			throw new UsernameNotFoundException(username);
		}
		
		UserDetails userDetails = User
				.withUsername(clientsLogin.getUsername())
				.password(clientsLogin.getPassword())
				.authorities("USER").build();
		
		return userDetails;
	}
	
	public void addClient(RegisterForm registerForm, int clientId) {
		
		String username = registerForm.getUsername();
		String encodedPassword = passwordEncoder.encode(registerForm.getPassword());
		 		
		ClientsLogin clientsLogin = new ClientsLogin(username,encodedPassword,1,clientId);
		
		clientsLoginRepository.save(clientsLogin);
				
	}
	
	public ClientsLogin getClientsLoginByUsername(String username) {
		
		return clientsLoginRepository.findById(username).orElse(null);
		
	}
	
	public ClientsLogin getClientsLoginByClientId(int clientId) {
		return clientsLoginRepository.findByClientId(clientId);
	}
	
	public void updateClient(MyUserAccountForm myUserAccountForm, int clientId) {
		
		String username = myUserAccountForm.getUsername();
		String encodedPassword = passwordEncoder.encode(myUserAccountForm.getNewPassword());
		
		ClientsLogin clientsLogin = new ClientsLogin(username,encodedPassword,1,clientId);
		
		clientsLoginRepository.save(clientsLogin);
		
	}

}
