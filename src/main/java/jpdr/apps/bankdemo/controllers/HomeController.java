package jpdr.apps.bankdemo.controllers;


import java.util.Locale;

import javax.annotation.Resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jpdr.apps.bankdemo.components.ClientSessionInfo;
import jpdr.apps.bankdemo.entities.Account;
import jpdr.apps.bankdemo.entities.Client;
import jpdr.apps.bankdemo.entities.ClientSettings;
import jpdr.apps.bankdemo.entities.EntitiesList;
import jpdr.apps.bankdemo.security.BankDemoUserDetailsService;
import jpdr.apps.bankdemo.security.ClientsLogin;
import jpdr.apps.bankdemo.services.AccountService;
import jpdr.apps.bankdemo.services.ClientService;
import jpdr.apps.bankdemo.services.LoanService;
import jpdr.apps.bankdemo.services.LocaleService;
import jpdr.apps.bankdemo.views.HomeView;



@Controller
public class HomeController {
	
	@Autowired
	BankDemoUserDetailsService bankDemoUserDetailsService;
	
	@Autowired
	ClientService clientService;
	
	@Resource(name = "clientSessionInfo")
	ClientSessionInfo clientSessionInfo;

	@Autowired
	AccountService accountService;
	
	@Autowired
	LoanService loanService;
	
	@Autowired
	LocaleService localeService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public ModelAndView slash() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		User authUser = (User) authentication.getPrincipal();
		
		if (authUser==null) return new ModelAndView("/error");
		
		String username = authUser.getUsername();
		
		ClientsLogin clientsLogin = bankDemoUserDetailsService.getClientsLoginByUsername(username); 
		
		if(clientsLogin==null) return new ModelAndView("/error");
		
		Client client = clientService.getClientById(clientsLogin.getClientId());
		
		if(client==null) return new ModelAndView("/error");
				
		clientSessionInfo.setClientId(client.getId());
		clientSessionInfo.setFirstName(client.getFirstName());
		clientSessionInfo.setLastName(client.getLastName());		
		
		ClientSettings clientSettings = clientService.getClientSettings(client.getId());
		
		localeService.setCurrentLanguage(clientSettings.getLanguage());
		
		double accountsBalance = accountService.getClientAccountsBalance(clientSessionInfo.getClientId());			
		double loansBalance = loanService.getClientLoansBalance(clientSessionInfo.getClientId());
		
		HomeView homeView = new HomeView();
		homeView.setClientFirstName(clientSessionInfo.getFirstName());
		homeView.setAccountsBalance(accountsBalance);
		homeView.setLoansBalance(loansBalance);
		
		ModelAndView modelAndView = new ModelAndView("/home");
		modelAndView.addObject("activeMenu","home");
		modelAndView.addObject("homeView",homeView);
		
		return modelAndView;
	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/home")
	public ModelAndView home() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		User authUser = (User) authentication.getPrincipal();
		
		if (authUser==null) return new ModelAndView("/error");
		
		String username = authUser.getUsername();
		
		ClientsLogin clientsLogin = bankDemoUserDetailsService.getClientsLoginByUsername(username); 
		
		if(clientsLogin==null) return new ModelAndView("/error");
		
		Client client = clientService.getClientById(clientsLogin.getClientId());
		
		if(client==null) return new ModelAndView("/error");
				
		clientSessionInfo.setClientId(client.getId());
		clientSessionInfo.setFirstName(client.getFirstName());
		clientSessionInfo.setLastName(client.getLastName());		
		
		ClientSettings clientSettings = clientService.getClientSettings(client.getId());
		
		localeService.setCurrentLanguage(clientSettings.getLanguage());
		
		double accountsBalance = accountService.getClientAccountsBalance(clientSessionInfo.getClientId());			
		double loansBalance = loanService.getClientLoansBalance(clientSessionInfo.getClientId());
		
		HomeView homeView = new HomeView();
		homeView.setClientFirstName(clientSessionInfo.getFirstName());
		homeView.setAccountsBalance(accountsBalance);
		homeView.setLoansBalance(loansBalance);
		
		ModelAndView modelAndView = new ModelAndView("/home");
		modelAndView.addObject("activeMenu","home");
		modelAndView.addObject("homeView",homeView);
		
		return modelAndView;
	}
	
}
