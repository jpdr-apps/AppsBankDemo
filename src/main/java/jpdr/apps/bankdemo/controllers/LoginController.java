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
	public ModelAndView registerSubmit(@ModelAttribute("registerForm") @Validated(RegisterFormValidationSecuence.class) RegisterForm registerForm ,  BindingResult bindingResult) {
		
		ModelAndView modelAndView = new ModelAndView("/error/error");	
		
		if(bindingResult.hasErrors()) {			
			modelAndView = new ModelAndView("/login/registerBegin");		
			modelAndView.addObject("registerForm",registerForm);					
		}else {			
			Client client = clientService.addClient(registerForm);
			
			if(client!=null) {			
				
				bankDemoUserDetailsService.addClient(registerForm,client.getId());
				
				ClientSettings clientSettings = new ClientSettings(client.getId(),localeService.getCurrentLanguage());
				clientService.saveSettings(clientSettings);
				
				modelAndView = new ModelAndView("/login/registerResult");						
			}
		}
		return modelAndView;	
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/registerResult")
	public String registerResult() {			
		return "/login/registerResult";
	}
	
	
	@ExceptionHandler
	public ModelAndView handleException(Exception ex) {
				
		ModelAndView modelAndView = new ModelAndView("/error/errorCommon");		
 		return modelAndView;
	}

}
