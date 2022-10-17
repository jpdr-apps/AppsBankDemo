package jpdr.apps.bankdemo.controllers;

import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import jpdr.apps.bankdemo.components.ClientSessionInfo;
import jpdr.apps.bankdemo.entities.Client;
import jpdr.apps.bankdemo.entities.ClientSettings;
import jpdr.apps.bankdemo.forms.MyDataForm;
import jpdr.apps.bankdemo.forms.MyUserAccountForm;
import jpdr.apps.bankdemo.forms.SettingsForm;
import jpdr.apps.bankdemo.forms.validation.groups.RegisterFormValidationSecuence;
import jpdr.apps.bankdemo.security.BankDemoUserDetailsService;
import jpdr.apps.bankdemo.security.ClientsLogin;
import jpdr.apps.bankdemo.services.ClientService;
import jpdr.apps.bankdemo.services.LocaleService;

@Controller
public class SettingsController {
	
	
	@Autowired
	BankDemoUserDetailsService bankDemoUserDetailsService;
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	LocaleService localeService;
	
	@Resource(name = "clientSessionInfo")
	ClientSessionInfo clientSessionInfo;
	
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/settings")
	public ModelAndView getMyData() {
		
		if (clientSessionInfo == null || clientSessionInfo.getClientId() == -1)	return new ModelAndView("/error/error");
		
 		Client client = clientService.getClientById(clientSessionInfo.getClientId());
		
		if(client==null) return new ModelAndView("/error/error");
		
		ClientsLogin clientsLogin = bankDemoUserDetailsService.getClientsLoginByClientId(clientSessionInfo.getClientId());
		
		if(clientsLogin==null) return new ModelAndView("/error/error");
		
		MyDataForm myDataForm = new MyDataForm();
		myDataForm.setFirstName(client.getFirstName());
		myDataForm.setLastName(client.getLastName());
		myDataForm.setDocumentId(client.getDocumentId());
		
		MyUserAccountForm myUserAccountForm = new MyUserAccountForm();
		myUserAccountForm.setUsername(clientsLogin.getUsername());
		
		ClientSettings clientSettings = clientService.getClientSettings(client.getId());		
		
		SettingsForm settingsForm = new SettingsForm(clientSettings.getLanguage());
		
		TreeMap<String, String> languages = new TreeMap<String, String>();
		languages.put("esp", "Español");		
		languages.put("eng", "English");
		
		ModelAndView modelAndView = new ModelAndView("/settings/listSettings");
		modelAndView.addObject("activeMenu","settings");		
		modelAndView.addObject("myDataForm",myDataForm);
		modelAndView.addObject("myUserAccountForm",myUserAccountForm);
		modelAndView.addObject("settingsForm", settingsForm);
		modelAndView.addObject("languages",languages);
		modelAndView.addObject("activeTab","myData");
		modelAndView.addObject("showModal",false);		
		
		return modelAndView;
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/settings/myData")
	public ModelAndView postMyData(
			@ModelAttribute("myDataForm") @Validated(RegisterFormValidationSecuence.class) MyDataForm myDataForm ,  			
			BindingResult bindingResult) {
		
		if (clientSessionInfo == null || clientSessionInfo.getClientId() == -1)	return new ModelAndView("/error/error");
		
		if(bindingResult.hasErrors()) {			
			
			Client client = clientService.getClientById(clientSessionInfo.getClientId());
			
			if(client==null) return new ModelAndView("/error/error");
			
			ClientsLogin clientsLogin = bankDemoUserDetailsService.getClientsLoginByClientId(clientSessionInfo.getClientId());
			
			if(clientsLogin==null) return new ModelAndView("/error/error");
			
			MyUserAccountForm myUserAccountForm = new MyUserAccountForm();
			myUserAccountForm.setUsername(clientsLogin.getUsername());
			
			ClientSettings clientSettings = clientService.getClientSettings(client.getId());		
			
			TreeMap<String, String> languages = new TreeMap<String, String>();
			languages.put("esp", "Español");		
			languages.put("eng", "English");
			
			SettingsForm settingsForm = new SettingsForm(clientSettings.getLanguage());
			ModelAndView modelAndView = new ModelAndView("/settings/listSettings");
			modelAndView.addObject("activeMenu","settings");					
			modelAndView.addObject("myDataForm",myDataForm);
			modelAndView.addObject("myUserAccountForm",myUserAccountForm);
			modelAndView.addObject("settingsForm", settingsForm);
			modelAndView.addObject("languages","languages");
			modelAndView.addObject("activeTab","myData");			
			modelAndView.addObject("showModal",false);	
			return modelAndView;
		}else {			
			
			Client client = clientService.getClientById(clientSessionInfo.getClientId());
			client.setFirstName(myDataForm.getFirstName());
			client.setLastName(myDataForm.getLastName());
			client.setDocumentId(myDataForm.getDocumentId());
			client.setDateBirth(client.getDateBirth());
			
			clientService.updateClient(client);
						
			ClientsLogin clientsLogin = bankDemoUserDetailsService.getClientsLoginByClientId(clientSessionInfo.getClientId());
			
			if(clientsLogin==null) return new ModelAndView("/error/error");
			
			MyUserAccountForm myUserAccountForm = new MyUserAccountForm();
			myUserAccountForm.setUsername(clientsLogin.getUsername());
			
			ClientSettings clientSettings = clientService.getClientSettings(client.getId());		
			
			SettingsForm settingsForm = new SettingsForm(clientSettings.getLanguage());
			
			
			TreeMap<String, String> languages = new TreeMap<String, String>();
			languages.put("esp", "Español");		
			languages.put("eng", "English");
			
			ModelAndView modelAndView = new ModelAndView("/settings/listSettings");
			modelAndView.addObject("activeMenu","settings");						
			modelAndView.addObject("myDataForm",myDataForm);
			modelAndView.addObject("myUserAccountForm",myUserAccountForm);
			modelAndView.addObject("settingsForm", settingsForm);
			modelAndView.addObject("languages", languages);
			modelAndView.addObject("activeTab","myData");
			modelAndView.addObject("showModal",true);
			return modelAndView;
		}		
		
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/settings/userAccount")
	public ModelAndView postUserAccount(@ModelAttribute("myUserAccountForm") @Validated(RegisterFormValidationSecuence.class) MyUserAccountForm myUserAccountForm ,  BindingResult bindingResult) {
		
		if (clientSessionInfo == null || clientSessionInfo.getClientId() == -1)	return new ModelAndView("/error/error");
		
 		if(bindingResult.hasErrors()) {	
			
			Client client = clientService.getClientById(clientSessionInfo.getClientId());
			
			if(client==null) return new ModelAndView("/error/error");
			
			ClientsLogin clientsLogin = bankDemoUserDetailsService.getClientsLoginByClientId(clientSessionInfo.getClientId());
			
			if(clientsLogin==null) return new ModelAndView("/error/error");
			
			MyDataForm myDataForm = new MyDataForm();
			myDataForm.setFirstName(client.getFirstName());
			myDataForm.setLastName(client.getLastName());
			myDataForm.setDocumentId(client.getDocumentId());
			
			ClientSettings clientSettings = clientService.getClientSettings(client.getId());		
			
			SettingsForm settingsForm = new SettingsForm(clientSettings.getLanguage());
			
			
			TreeMap<String, String> languages = new TreeMap<String, String>();
			languages.put("esp", "Español");		
			languages.put("eng", "English");
			
			ModelAndView modelAndView = new ModelAndView("/settings/listSettings");
			modelAndView.addObject("activeMenu","settings");					
			modelAndView.addObject("myDataForm",myDataForm);
			modelAndView.addObject("myUserAccountForm",myUserAccountForm);
			modelAndView.addObject("settingsForm", settingsForm);
			modelAndView.addObject("languages", languages);
			modelAndView.addObject("activeTab","userAccount");
			modelAndView.addObject("showModal",false);
			return modelAndView;
					
		}else {			

			bankDemoUserDetailsService.updateClient(myUserAccountForm, clientSessionInfo.getClientId());
			
			
			Client client = clientService.getClientById(clientSessionInfo.getClientId());
			
			if(client==null) return new ModelAndView("/error/error");
			
			ClientsLogin clientsLogin = bankDemoUserDetailsService.getClientsLoginByClientId(clientSessionInfo.getClientId());
			
			if(clientsLogin==null) return new ModelAndView("/error/error");
			
			MyDataForm myDataForm = new MyDataForm();
			myDataForm.setFirstName(client.getFirstName());
			myDataForm.setLastName(client.getLastName());
			myDataForm.setDocumentId(client.getDocumentId());
			
			ClientSettings clientSettings = clientService.getClientSettings(client.getId());		
			
			SettingsForm settingsForm = new SettingsForm(clientSettings.getLanguage());

			
			TreeMap<String, String> languages = new TreeMap<String, String>();
			languages.put("esp", "Español");		
			languages.put("eng", "English");
			
			
			ModelAndView modelAndView = new ModelAndView("/settings/listSettings");
			modelAndView.addObject("activeMenu","settings");					
			modelAndView.addObject("myDataForm",myDataForm);
			modelAndView.addObject("myUserAccountForm",myUserAccountForm);
			modelAndView.addObject("settingsForm", settingsForm);
			modelAndView.addObject("languages", languages);
			modelAndView.addObject("activeTab","userAccount");
			modelAndView.addObject("showModal",true);
			return modelAndView;
		}		
		
	}
	
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/settings/options")
	public ModelAndView postOptions(@ModelAttribute("settingsForm") @Validated(RegisterFormValidationSecuence.class) SettingsForm settingsForm ,  BindingResult bindingResult) {
		
		if (clientSessionInfo == null || clientSessionInfo.getClientId() == -1)	return new ModelAndView("/error/error");
		
 		if(bindingResult.hasErrors()) {	
			
			Client client = clientService.getClientById(clientSessionInfo.getClientId());
			
			if(client==null) return new ModelAndView("/error/error");
			
			ClientsLogin clientsLogin = bankDemoUserDetailsService.getClientsLoginByClientId(clientSessionInfo.getClientId());
			
			if(clientsLogin==null) return new ModelAndView("/error/error");
			
			MyDataForm myDataForm = new MyDataForm();
			myDataForm.setFirstName(client.getFirstName());
			myDataForm.setLastName(client.getLastName());
			myDataForm.setDocumentId(client.getDocumentId());
						
			MyUserAccountForm myUserAccountForm = new MyUserAccountForm();
			myUserAccountForm.setUsername(clientsLogin.getUsername());
			
			
			TreeMap<String, String> languages = new TreeMap<String, String>();
			languages.put("esp", "Español");		
			languages.put("eng", "English");
						
			ModelAndView modelAndView = new ModelAndView("/settings/listSettings");
			modelAndView.addObject("activeMenu","settings");					
			modelAndView.addObject("myDataForm",myDataForm);
			modelAndView.addObject("myUserAccountForm",myUserAccountForm);
			modelAndView.addObject("settingsForm", settingsForm);
			modelAndView.addObject("languages", languages);
			modelAndView.addObject("activeTab","options");
			modelAndView.addObject("showModal",false);
			return modelAndView;
					
		}else {			

			ClientSettings clientSettings = new ClientSettings();
			clientSettings.setClientId(clientSessionInfo.getClientId());
			clientSettings.setLanguage(settingsForm.getLanguage());
			
			clientService.saveSettings(clientSettings);
			
			localeService.setCurrentLanguage(clientSettings.getLanguage());			
			
			Client client = clientService.getClientById(clientSessionInfo.getClientId());
			
			if(client==null) return new ModelAndView("/error/error");
			
			ClientsLogin clientsLogin = bankDemoUserDetailsService.getClientsLoginByClientId(clientSessionInfo.getClientId());
			
			if(clientsLogin==null) return new ModelAndView("/error/error");
			
			MyDataForm myDataForm = new MyDataForm();
			myDataForm.setFirstName(client.getFirstName());
			myDataForm.setLastName(client.getLastName());
			myDataForm.setDocumentId(client.getDocumentId());
			
			MyUserAccountForm myUserAccountForm = new MyUserAccountForm();
			myUserAccountForm.setUsername(clientsLogin.getUsername());
					
			
			TreeMap<String, String> languages = new TreeMap<String, String>();
			languages.put("esp", "Español");		
			languages.put("eng", "English");
						
			
			ModelAndView modelAndView = new ModelAndView("/settings/listSettings");
			modelAndView.addObject("activeMenu","settings");					
			modelAndView.addObject("myDataForm",myDataForm);
			modelAndView.addObject("myUserAccountForm",myUserAccountForm);
			modelAndView.addObject("settingsForm", settingsForm);
			modelAndView.addObject("languages", languages);
			modelAndView.addObject("activeTab","options");
			modelAndView.addObject("showModal",true);
			return modelAndView;
		}		
		
	}

	@ExceptionHandler
	public ModelAndView handleException(Exception ex) {
				
		ModelAndView modelAndView = new ModelAndView("/error/errorCommon");
 		return modelAndView;
	}

}
