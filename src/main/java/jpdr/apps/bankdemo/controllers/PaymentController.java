package jpdr.apps.bankdemo.controllers;

import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

import jpdr.apps.bankdemo.components.ClientSessionInfo;
import jpdr.apps.bankdemo.configuration.LocaleConfig;
import jpdr.apps.bankdemo.entities.Account;
import jpdr.apps.bankdemo.entities.Client;
import jpdr.apps.bankdemo.entities.EntitiesList;
import jpdr.apps.bankdemo.entities.Payment;
import jpdr.apps.bankdemo.forms.PaymentForm;
import jpdr.apps.bankdemo.services.AccountService;
import jpdr.apps.bankdemo.services.PaymentService;

@Controller
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	AccountService accountService;

	HttpSession httpSession;
	
	@Resource(name = "clientSessionInfo")
	ClientSessionInfo clientSessionInfo;
	
	@Resource(name = "localeResolver")
	LocaleResolver localeResolver;
	
	@RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountNumber}/paymentBegin")
	public ModelAndView getPaymentBegin(@PathVariable(value = "accountNumber") Integer accountNumber, HttpServletRequest request) {
		
		if (clientSessionInfo == null || clientSessionInfo.getClientId() == -1)	return new ModelAndView("/error/error");
		
		if(accountNumber==null) return new ModelAndView("/error/error");
		
		ArrayList<String> internalAccounts = new ArrayList<String>();

		for (Account a : accountService.getActiveAccounts(clientSessionInfo.getClientId()).getEntities()) {
			if (a.getNumber() != accountNumber) { // la transferencia no puede ser a la misma cuenta destino
				internalAccounts.add(String.valueOf(a.getNumber()));
			}
		}
		ArrayList<String> externalAccounts = new ArrayList<String>();

		for (Account a : accountService.getOtherActiveAccounts(clientSessionInfo.getClientId()).getEntities()) {
			externalAccounts.add(String.valueOf(a.getNumber()));
		}
		
		Account account = accountService.getAccountByNumber(accountNumber);

		if(account==null) return new ModelAndView("/error/error");
		
		Locale locale = localeResolver.resolveLocale(request);
				
		char decimalSeparator = new DecimalFormatSymbols(locale).getDecimalSeparator();
				
		PaymentForm paymentForm = new PaymentForm();
		paymentForm.setOriginAccount(account.getNumber());
		paymentForm.setOriginAccountBalance(account.getBalance());
		paymentForm.setInternalPayment(false);		
		paymentForm.setInternalAccounts(internalAccounts);		
		paymentForm.setExternalAccounts(externalAccounts);
		paymentForm.setDecimalSeparator(decimalSeparator);
		paymentForm.setAmount(0.00f);
		
		ModelAndView modelAndView = new ModelAndView("/accounts/paymentBegin");
		modelAndView.addObject("activeMenu","accounts");
		modelAndView.addObject("paymentForm", paymentForm);

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/accounts/{accountNumber}/paymentConfirm")
	public ModelAndView postConfirmPayment(@ModelAttribute("paymentForm") @Valid PaymentForm paymentForm,
			BindingResult bindingResult, @PathVariable(value = "accountNumber") Integer accountNumber) {

		if (clientSessionInfo == null || clientSessionInfo.getClientId() == -1)	return new ModelAndView("/error/error");
		
		if(accountNumber==null) return new ModelAndView("/error/error");
		
		if (bindingResult.hasErrors()) {

			ModelAndView modelAndView = new ModelAndView("/accounts/paymentBegin", "paymentForm", paymentForm);
			modelAndView.addObject("activeMenu","accounts");
			return modelAndView;
			
		} else {

			Account account = accountService.getAccountByNumber(Integer.valueOf(paymentForm.getDestinationAccount()));
			
			if(account==null) return new ModelAndView("/error/error");
			
			Client client = accountService.getClientByAccountId(account.getId());

			if(client==null) return new ModelAndView("/error/error");
			
			ModelAndView modelAndView = new ModelAndView("/accounts/paymentConfirm");
			paymentForm.setDestinationDocumentId(client.getDocumentId());
			paymentForm.setDestinationFistName(client.getFirstName());
			paymentForm.setDestinationLastName(client.getLastName());
			modelAndView.addObject("activeMenu","accounts");			
			modelAndView.addObject("accountNumber", accountNumber);
			modelAndView.addObject("paymentForm", paymentForm);
			return modelAndView;
		}

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/accounts/paymentSubmit")
	public ModelAndView postSubmitPayment(
			@ModelAttribute("paymentForm") @Valid PaymentForm paymentForm,
			BindingResult bindingResult, HttpServletRequest request) {
		
		if (clientSessionInfo == null || clientSessionInfo.getClientId() == -1)	return new ModelAndView("/error/error");
		
		if (bindingResult.hasErrors()) return new ModelAndView("/error/error");
		
		Payment payment = paymentService.addPayment(
				paymentForm.getOriginAccount(),
				paymentForm.getDestinationAccount(), 
				paymentForm.getDestinationDocumentId(),
				paymentForm.getDestinationFistName() + " " +
				paymentForm.getDestinationLastName(),
				paymentForm.getAmount(), 
				paymentForm.getDetails(),
				request
				);
		
		ModelAndView modelAndView = new ModelAndView("/accounts/paymentResults");
		modelAndView.addObject("activeMenu","accounts");
		modelAndView.addObject("payment", payment);

		return modelAndView;
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/payments")
	public ModelAndView getPayments(HttpServletRequest request) {
		
		if (clientSessionInfo == null || clientSessionInfo.getClientId() == -1)	return new ModelAndView("/error/error");
		
		EntitiesList<Payment> sentPayments = new EntitiesList<Payment>(paymentService.getSentPaymentsByClient(clientSessionInfo.getClientId()));		
		EntitiesList<Payment> receivedPayments = new EntitiesList<Payment>(paymentService.getRecivedPaymentsByClient(clientSessionInfo.getClientId()));
		
		Locale locale = localeResolver.resolveLocale(request);
				
		char decimalSeparator = new DecimalFormatSymbols(locale).getDecimalSeparator();
				
		ModelAndView modelAndView = new ModelAndView("/payments/listPayments");
		modelAndView.addObject("activeMenu","payments");
		modelAndView.addObject("sentPayments", sentPayments);
		modelAndView.addObject("receivedPayments", receivedPayments);
		modelAndView.addObject("decimalSeparator", decimalSeparator);

		return modelAndView;
	}
	
	

}
