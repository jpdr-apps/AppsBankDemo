package jpdr.apps.bankdemo.services;

import org.springframework.beans.factory.annotation.Autowired;

import jpdr.apps.bankdemo.security.BankDemoUserDetailsService;

public class MyDataService {
	
	
	@Autowired
	BankDemoUserDetailsService bankDemoUserDetailsService;
	
	@Autowired
	ClientService clientService;
	
 

}
