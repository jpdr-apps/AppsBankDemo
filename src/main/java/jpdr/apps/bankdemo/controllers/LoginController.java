package jpdr.apps.bankdemo.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import jpdr.apps.bankdemo.components.ClientSessionInfo;

import jpdr.apps.bankdemo.entities.Client;
import jpdr.apps.bankdemo.entities.ClientSettings;
import jpdr.apps.bankdemo.forms.LoginForm;

import jpdr.apps.bankdemo.forms.RegisterForm;
import jpdr.apps.bankdemo.forms.validation.groups.RegisterFormValidationSecuence;
import jpdr.apps.bankdemo.security.BankDemoUserDetailsService;

import jpdr.apps.bankdemo.services.ClientService;
import jpdr.apps.bankdemo.services.LocaleService;

@Controller
public class LoginController {
	
	@Autowired
	BankDemoUserDetailsService bankDemoUserDetailsService;
	
	@Autowired
	ClientService clientService;
		
	@Autowired
	LocaleService localeService;
		
	@Resource(name = "clientSessionInfo")
	ClientSessionInfo clientSessionInfo;
	
	@RequestMapping(method = RequestMethod.GET, value="/login")
	public ModelAndView login(@RequestParam(name = "lang", required = false )  String language) {
		
		String param = language != null ? "?lang=" + language : "" ;
	
		localeService.setCurrentLanguage(language);
				
		ModelAndView modelAndView = new ModelAndView("/login/loginBegin");
		modelAndView.addObject("loginForm",new LoginForm());		
		return modelAndView;
	}

	
	@RequestMapping(method = RequestMethod.GET, value="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication!=null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}		
		return "redirect:/login";
	}

	
	
	@RequestMapping(method = RequestMethod.GET, value="/register")
	public ModelAndView registerBegin() {					
	
		ModelAndView modelAndView = new ModelAndView("/login/registerBegin");		
		modelAndView.addObject("registerForm",new RegisterForm());
		return modelAndView;
		
	}

	@RequestMapping(method = RequestMethod.POST, value="/register")
	public ModelAndView registerSubmit(@ModelAttribute("registerForm") @Validated(RegisterFormValidationSecuence.class) RegisterForm registerForm ,  BindingResult bindingResult, HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("/error/error");	
		
		if(bindingResult.hasErrors()) {			
			modelAndView = new ModelAndView("/login/registerBegin");		
			modelAndView.addObject("registerForm",registerForm);					
		}else {			
			Client client = clientService.addClient(registerForm);
			
			if(client!=null) {			
				
				bankDemoUserDetailsService.addClient(registerForm,client.getId());
				
				ClientSettings clientSettings = new ClientSettings(client.getId(),localeService.getCurrentLanguage(request));
				clientService.saveSettings(clientSettings);
				
				modelAndView = new ModelAndView("/login/registerResult");						
			}
		}
		return modelAndView;	
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/registerResult")
	public String registerResult(HttpServletRequest request) {			
		return "/login/registerResult";
	}
	
	
	
/*	
	@RequestMapping(method = RequestMethod.GET, value = "/myUserAccount")
	public ModelAndView getMyData() {
		
		if (clientSessionInfo == null) return new ModelAndView("/error/error");
			
		Client client = clientService.getClientById(clientSessionInfo.getClientId());
		
		if(client==null) return new ModelAndView("/error/error");
		
		ClientsLogin clientsLogin = bankDemoUserDetailsService.getClientsLoginByClientId(clientSessionInfo.getClientId());
		
		if(clientsLogin==null) return new ModelAndView("/error/error");
		
		MyUserAccountForm myUserAccountForm = new MyUserAccountForm();
		myUserAccountForm.setUsername(clientsLogin.getUsername());
				
		ModelAndView modelAndView = new ModelAndView("/login/userAccountUpdate");
		modelAndView.addObject("myUserAccountForm",myUserAccountForm);
		modelAndView.addObject("showModal",false);
		return modelAndView;
	}
*/	
/*	
	@RequestMapping(method = RequestMethod.POST, value = "/myUserAccount")
	public ModelAndView postMyData(@ModelAttribute("myUserAccountForm") @Validated(RegisterFormValidationSecuence.class) MyUserAccountForm myUserAccountForm ,  BindingResult bindingResult) {
		
		if (clientSessionInfo == null) return new ModelAndView("/error/error");
 		
		if(bindingResult.hasErrors()) {			
			ModelAndView modelAndView = new ModelAndView("/login/userAccountUpdate");		
			modelAndView.addObject("myUserAccountForm",myUserAccountForm);
			modelAndView.addObject("showModal",false);
			return modelAndView;
		}else {			

			bankDemoUserDetailsService.updateClient(myUserAccountForm, clientSessionInfo.getClientId());
			
			ModelAndView modelAndView = new ModelAndView("/login/userAccountUpdate");
			modelAndView.addObject("myUserAccountForm",myUserAccountForm);
			modelAndView.addObject("showModal",true);
			return modelAndView;
		}		
		
	}

*/
	
	@ExceptionHandler
	public ModelAndView handleException(Exception ex) {
				
		ModelAndView modelAndView = new ModelAndView("/error/errorCommon");		
 		return modelAndView;
	}

}
