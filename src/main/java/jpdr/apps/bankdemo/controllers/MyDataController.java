package jpdr.apps.bankdemo.controllers;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import jpdr.apps.bankdemo.components.ClientSessionInfo;
import jpdr.apps.bankdemo.entities.Client;
import jpdr.apps.bankdemo.forms.MyDataForm;
import jpdr.apps.bankdemo.forms.validation.groups.RegisterFormValidationSecuence;
import jpdr.apps.bankdemo.security.BankDemoUserDetailsService;
import jpdr.apps.bankdemo.security.ClientsLogin;
import jpdr.apps.bankdemo.services.ClientService;

@Controller
public class MyDataController {

	@Autowired
	BankDemoUserDetailsService bankDemoUserDetailsService;
	
	@Autowired
	ClientService clientService;
	
	@Resource (name = "localeResolver")
	SessionLocaleResolver sessionLocaleResolver;
	
	@Resource(name = "clientSessionInfo")
	ClientSessionInfo clientSessionInfo;
	
/*	
	@RequestMapping(method = RequestMethod.GET, value = "/myData")
	public ModelAndView getMyData() {
		
		if(clientSessionInfo==null) return new ModelAndView("/error/error");
		//if(clientSessionInfo.getClientId()==null) return new ModelAndView("/error/error");
	
		Client client = clientService.getClientById(clientSessionInfo.getClientId());
		
		if(client==null) return new ModelAndView("/error/error");
		
		ClientsLogin clientsLogin = bankDemoUserDetailsService.getClientsLoginByClientId(clientSessionInfo.getClientId());
		
		if(clientsLogin==null) return new ModelAndView("/error/error");
		
		MyDataForm myDataForm = new MyDataForm();
		myDataForm.setFirstName(client.getFirstName());
		myDataForm.setLastName(client.getLastName());
		myDataForm.setDocumentId(client.getDocumentId());		
		
		ModelAndView modelAndView = new ModelAndView("/myData/listMyData");
		modelAndView.addObject("myDataForm",myDataForm);
		modelAndView.addObject("showModal",false);
		return modelAndView;
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/myData")
	public ModelAndView postMyData(@ModelAttribute("myDataForm") @Validated(RegisterFormValidationSecuence.class) MyDataForm myDataForm ,  BindingResult bindingResult) {
		if(clientSessionInfo==null) return new ModelAndView("/error/error");
		//if(clientSessionInfo.getClientId()==null) return new ModelAndView("/error/error");
		
		if(bindingResult.hasErrors()) {			
			ModelAndView modelAndView = new ModelAndView("/mydata/listMyData");		
			modelAndView.addObject("myDataForm",myDataForm);
			modelAndView.addObject("showModal",false);
			return modelAndView;
		}else {			
			
			Client client = clientService.getClientById(clientSessionInfo.getClientId());
			client.setFirstName(myDataForm.getFirstName());
			client.setLastName(myDataForm.getLastName());
			client.setDocumentId(myDataForm.getDocumentId());
			client.setDateBirth(client.getDateBirth());
			
			clientService.updateClient(client);
			
			ModelAndView modelAndView = new ModelAndView("/mydata/listMyData");
			modelAndView.addObject("myDataForm",myDataForm);
			modelAndView.addObject("showModal",true);
			return modelAndView;
		}		
		
	}

*/
	
}
