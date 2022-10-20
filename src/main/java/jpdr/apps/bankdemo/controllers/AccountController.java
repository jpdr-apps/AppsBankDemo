package jpdr.apps.bankdemo.controllers;

import java.util.ArrayList;


import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import jpdr.apps.bankdemo.components.ClientSessionInfo;

import jpdr.apps.bankdemo.entities.Account;

import jpdr.apps.bankdemo.entities.EntitiesList;

import jpdr.apps.bankdemo.entities.Transaction;
import jpdr.apps.bankdemo.forms.CloseAccountForm;
import jpdr.apps.bankdemo.forms.TransactionFormEntity;
import jpdr.apps.bankdemo.services.AccountService;
import jpdr.apps.bankdemo.services.exceptions.BankDemoException;

@Controller
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@Resource(name = "clientSessionInfo")
	ClientSessionInfo clientSessionInfo;
	
	@RequestMapping(method = RequestMethod.GET, value = "/accounts")
	public ModelAndView getAccounts() {

		if (clientSessionInfo == null || clientSessionInfo.getClientId() == -1)	return new ModelAndView("/error/error");

		EntitiesList<Account> accounts = accountService.getActiveAccounts(clientSessionInfo.getClientId());
//
		if (accounts == null)
			return new ModelAndView("/error/error");

		ModelAndView modelAndView = new ModelAndView("/accounts/listAccounts");
		modelAndView.addObject("activeMenu","accounts");
		modelAndView.addObject("accounts", accounts);

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/accounts/openAccountConfirm")
	public ModelAndView postOpenAccountConfirm() {

		if (clientSessionInfo == null || clientSessionInfo.getClientId() == -1)	return new ModelAndView("/error/error");
		
		ModelAndView modelAndView = new ModelAndView("/accounts/openAccountConfirm");
		modelAndView.addObject("activeMenu","accounts");
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/accounts/openAccountSubmit")
	public ModelAndView postOpenAccountSubmit() throws BankDemoException{

		if (clientSessionInfo == null || clientSessionInfo.getClientId() == -1)	return new ModelAndView("/error/error");
		
		Account account = accountService.openAccount(clientSessionInfo.getClientId());

		if (account == null)
			return new ModelAndView("/error/error");

		ModelAndView modelAndView = new ModelAndView("/accounts/openAccountResult");
		modelAndView.addObject("activeMenu","accounts");
		modelAndView.addObject("account", account);
		modelAndView.addObject("welcomeAmount", AccountService.WELCOME_AMOUNT);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountNumber}/closeAccountConfirm")
	public ModelAndView getCloseAccountConfirm(@PathVariable(value = "accountNumber") Integer accountNumber) {

		if (clientSessionInfo == null || clientSessionInfo.getClientId() == -1)	return new ModelAndView("/error/error");		
		
		CloseAccountForm closeAccountForm = new CloseAccountForm(accountNumber);

		ModelAndView modelAndView = new ModelAndView("/accounts/closeAccountConfirm");
		modelAndView.addObject("activeMenu","accounts");
		modelAndView.addObject("closeAccountForm", closeAccountForm);
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/accounts/closeAccountSubmit")
	public ModelAndView postCloseAccountSubmit(
			@ModelAttribute("closeAccountForm") @Valid CloseAccountForm closeAccountForm, BindingResult bindingResult) {

		if (clientSessionInfo == null || clientSessionInfo.getClientId() == -1)	return new ModelAndView("/error/error");
		
		if (bindingResult.hasErrors())
			return new ModelAndView("/error/error");

		accountService.closeAccount(closeAccountForm.getAccountNumber());

		ModelAndView modelAndView = new ModelAndView("/accounts/closeAccountResult");
		modelAndView.addObject("activeMenu","accounts");
		modelAndView.addObject("closeAccountForm", closeAccountForm);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountNumber}/listTransactions")
	public ModelAndView getTransactions(@PathVariable(value = "accountNumber") Integer accountNumber) {

		if (clientSessionInfo == null || clientSessionInfo.getClientId() == -1)	return new ModelAndView("/error/error"); 	
		
		ArrayList<Transaction> transactionsArray = accountService.getTransactions(accountNumber);

		ArrayList<TransactionFormEntity> transactionsFormEntitiesList = new ArrayList<TransactionFormEntity>();
		
		int transactionsArraySize = transactionsArray.size();
		
		for(int i=0; i<transactionsArraySize;i++) {
			
			String localizedConcept = accountService.getTransactionConcept(
					transactionsArray.get(i).getConceptId() 
					); 
			
			String localizedDate = accountService.getLocalizedDate(
					transactionsArray.get(i).getDate() 
					);

			transactionsFormEntitiesList.add(
					new TransactionFormEntity(
							localizedDate,
							localizedConcept,
							transactionsArray.get(i).getDetails(),
							transactionsArray.get(i).getAmount(),							
							transactionsArray.get(i).getResultBalance()
							)
					);
			
		}
				
		EntitiesList<TransactionFormEntity> transactions = new EntitiesList<TransactionFormEntity>(transactionsFormEntitiesList);

		ModelAndView modelAndView = new ModelAndView("/accounts/listTransactions");
		modelAndView.addObject("activeMenu","accounts");
		modelAndView.addObject("accountNumber", accountNumber);
		modelAndView.addObject("transactions", transactions);		

		return modelAndView;
	}
	
	@ExceptionHandler(BankDemoException.class)
	public ModelAndView handleException(BankDemoException ex) {
				
		ModelAndView modelAndView = new ModelAndView("/error/errorInternal");
		modelAndView.addObject("activeMenu","home");
		modelAndView.addObject("exception",ex);
		return modelAndView;
	}

	@ExceptionHandler
	public ModelAndView handleException(Exception ex) {
				
		ModelAndView modelAndView = new ModelAndView("/error/errorCommon");
		modelAndView.addObject("activeMenu","home");
		//modelAndView.addObject("exception",ex);
		return modelAndView;
	}
	

}
