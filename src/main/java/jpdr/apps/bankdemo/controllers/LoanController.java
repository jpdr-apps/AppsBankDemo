package jpdr.apps.bankdemo.controllers;

import java.util.ArrayList;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
import jpdr.apps.bankdemo.entities.Loan;
import jpdr.apps.bankdemo.entities.LoanPayment;

import jpdr.apps.bankdemo.forms.LoanForm;
import jpdr.apps.bankdemo.forms.LoanFormPaymentsList;
import jpdr.apps.bankdemo.forms.LoanPayForm;
import jpdr.apps.bankdemo.forms.validation.AccountValidations;
import jpdr.apps.bankdemo.services.AccountService;
import jpdr.apps.bankdemo.services.LoanService;
import jpdr.apps.bankdemo.services.LocaleService;

@Controller
public class LoanController {

	public static final Double LOAN_INTEREST_RATE = 5.0d;

	@Autowired
	private LoanService loanService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private LocaleService localeService;
	
	@Resource(name = "clientSessionInfo")
	ClientSessionInfo clientSessionInfo;

	//@Resource(name = "messageSource")
	//MessageSource messageSource;

	@Autowired
	private AccountValidations accountValidations;
	
	@RequestMapping(method = RequestMethod.GET, value = "/loans")
	public ModelAndView getListLoans(HttpServletRequest request) {

		if (clientSessionInfo == null || clientSessionInfo.getClientId() == -1)	return new ModelAndView("/error/error");
		
		EntitiesList<LoanForm> loanForms = loanService.getActiveLoans(clientSessionInfo.getClientId(), request);

		if (loanForms == null)
			return new ModelAndView("/error/error");

		ModelAndView modelAndView = new ModelAndView("/loans/listLoans");
		modelAndView.addObject("activeMenu","loans");
		modelAndView.addObject("loanForms", loanForms);
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/loans/loanBegin")
	public ModelAndView postLoanBegin(HttpServletRequest request) {

		if (clientSessionInfo == null || clientSessionInfo.getClientId() == -1)	return new ModelAndView("/error/error");
		
		char decimalSeparator = localeService.getDecimalSeparator(request);

		ArrayList<String> internalAccounts = new ArrayList<String>();

		for (Account a : accountService.getActiveAccounts(clientSessionInfo.getClientId()).getEntities()) {
			internalAccounts.add(String.valueOf(a.getNumber()));
		}

		if (internalAccounts.size() == 0) {
			//internalAccounts.add(messageSource.getMessage("noAccounts", null, locale));
			internalAccounts.add(localeService.getLocalizedMessage("noAccounts", request));
		}

		LoanForm loanForm = new LoanForm();
		loanForm.setDecimalSeparator(decimalSeparator);
		loanForm.setLoanAmount(0.00f);
		loanForm.setInterestRate(LOAN_INTEREST_RATE);
		loanForm.setInternalAccounts(internalAccounts);

		ModelAndView modelAndView = new ModelAndView("/loans/loanBegin");
		modelAndView.addObject("activeMenu","loans");
		modelAndView.addObject("loanForm", loanForm);

		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/loans/loanBegin")
	public ModelAndView getLoanBegin(HttpServletRequest request) {
		
		if (clientSessionInfo == null || clientSessionInfo.getClientId() == -1)	return new ModelAndView("/error/error");
		
 		char decimalSeparator = localeService.getDecimalSeparator(request);

		ArrayList<String> internalAccounts = new ArrayList<String>();

		for (Account a : accountService.getActiveAccounts(clientSessionInfo.getClientId()).getEntities()) {
			internalAccounts.add(String.valueOf(a.getNumber()));
		}

		if (internalAccounts.size() == 0) {
			internalAccounts.add(localeService.getLocalizedMessage("noAccounts", request));
		}

		LoanForm loanForm = new LoanForm();
		loanForm.setDecimalSeparator(decimalSeparator);
		loanForm.setLoanAmount(0.00f);
		loanForm.setInterestRate(LOAN_INTEREST_RATE);
		loanForm.setInternalAccounts(internalAccounts);

		ModelAndView modelAndView = new ModelAndView("/loans/loanBegin");
		modelAndView.addObject("activeMenu","loans");
		modelAndView.addObject("loanForm", loanForm);

		return modelAndView;
	}
	

	@RequestMapping(method = RequestMethod.POST, value = "/loans/loanConfirm")
	public ModelAndView postLoanConfirm(@ModelAttribute("loanForm") @Valid LoanForm loanForm,
			BindingResult bindingResult, HttpServletRequest request) {

		if (clientSessionInfo == null || clientSessionInfo.getClientId() == -1)	return new ModelAndView("/error/error");
		
 		if (bindingResult.hasErrors()) {

			ModelAndView modelAndView = new ModelAndView("/loans/loanBegin", "loanForm", loanForm);
			return modelAndView;

		} else {

			Loan loan = loanService.getLoan(
					loanForm.getLoanAmount(), 
					loanForm.getTerm(),
					loanForm.getInterestRate(),
					loanForm.getCreditAccountNumberAsInteger());

			loanForm = loanService.getLoanForm(
					loan,					
					request
					);

			loanForm.setLoanFormPayments(loanService.getLoanFormPayments(loan.getLoanPayments(),request));

			ModelAndView modelAndView = new ModelAndView("/loans/loanConfirm");
			modelAndView.addObject("activeMenu","loans");
			modelAndView.addObject("loanForm", loanForm);

			return modelAndView;
		}

	}

	@RequestMapping(method = RequestMethod.POST, value = "/loans/loanResults")
	public ModelAndView postLoanResults(@ModelAttribute("loanForm") @Valid LoanForm loanForm, BindingResult bindingResult,
			HttpServletRequest request) {

		if (clientSessionInfo == null || clientSessionInfo.getClientId() == -1)	return new ModelAndView("/error/error");
		
 		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("/error/error");
			modelAndView.addObject("loanForm", loanForm); 
			return modelAndView;
			
		} else {

			// loan = loanService.addLoan(clientSessionInfo.getClientId(), loan, request);

			Loan loan = loanService.createLoan(clientSessionInfo.getClientId(), loanForm, request);

			ModelAndView modelAndView = new ModelAndView("/loans/loanResults");
			modelAndView.addObject("activeMenu","loans");
			modelAndView.addObject("loanNumber", loan.getNumber());
			return modelAndView;
		}
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/loans/{loanNumber}/listLoanPayments")
	public ModelAndView getListLoanPayments(@PathVariable(value = "loanNumber") int loanNumber, HttpServletRequest request) {

		if (clientSessionInfo == null || clientSessionInfo.getClientId() == -1)	return new ModelAndView("/error/error");
		
		Loan loan = loanService.getLoanByNumberWithPayments(loanNumber);
	
		LoanForm loanForm = loanService.getLoanForm(loan, request);
		LoanFormPaymentsList loanFormPaymentsList = loanService.getLoanFormPayments(loan.getLoanPayments(),request);
		
		ModelAndView modelAndView = new ModelAndView("/loans/listLoanPayments");
		modelAndView.addObject("activeMenu","loans");
		modelAndView.addObject("loanForm", loanForm);
		modelAndView.addObject("loanFormPaymentsList", loanFormPaymentsList);		

		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/loans/{loanNumber}/loanPayBegin")
	public ModelAndView getPayLoanBegin(@PathVariable(value = "loanNumber") int loanNumber, HttpServletRequest request) {
	
		if (clientSessionInfo == null || clientSessionInfo.getClientId() == -1)	return new ModelAndView("/error/error");
		
		Loan loan = loanService.getLoanByNumberWithOutPayments(loanNumber);
		
		LoanPayment loanPayment = loanService.getNextActivePaymentFromLoan(loan.getId());
		
		ArrayList<String> internalAccounts = new ArrayList<String>();

		for (Account a : accountService.getActiveAccounts(clientSessionInfo.getClientId()).getEntities()) {
			internalAccounts.add(String.valueOf(a.getNumber()));
		}
		
		if (internalAccounts.size() == 0) {
			internalAccounts.add(localeService.getLocalizedMessage("noAccounts", request));
		}
		
		LoanPayForm loanPayForm = new LoanPayForm();		
		loanPayForm.setLoanNumber(loan.getNumber());
		loanPayForm.setPaymentId(loanPayment.getLoanPaymentsId().getPaymentId());
		loanPayForm.setDueDate(localeService.getLocalizedDate(loanPayment.getDueDate(),request));				
		if ( loan.getRemainingPeriods() > 1 ) {			
			loanPayForm.setPaymentAmount(loanPayment.getPaymentAmount());
		}else {
			loanPayForm.setPaymentAmount(loan.getBalanceTotal());
		}		
		loanPayForm.setLoanBalance(loan.getBalanceTotal());
		loanPayForm.setBeginningBalance(loanPayment.getBeginningBalance());
		loanPayForm.setPrincipalAmount(loanPayment.getPrincipalAmount());
		loanPayForm.setInterestAmount(loanPayment.getInterestAmount());				
		loanPayForm.setEndingBalance(loanPayment.getEndingBalance());
		loanPayForm.setInternalAccounts(internalAccounts);
		loanPayForm.setDebitAccountNumber(0);
		loanPayForm.setDebitAccountBalance(0);
		loanPayForm.setPaymentDate(localeService.getLocalizedDate(localeService.getCurrentDate(), request));

		
		char decimalSeparator = localeService.getDecimalSeparator(request);
		
		ModelAndView modelAndView = new ModelAndView("/loans/loanPayBegin");
		modelAndView.addObject("activeMenu","loans");
		modelAndView.addObject("loanPayForm",loanPayForm);
		modelAndView.addObject("decimalSeparator",decimalSeparator);		
		
		return modelAndView;
		
	}
	

	@RequestMapping(method = RequestMethod.POST, value = "/loans/loanPayConfirm")
	public ModelAndView postLoanPayConfirm(@ModelAttribute("loanPayForm") @Valid LoanPayForm loanPayForm,
			BindingResult bindingResult, HttpServletRequest request) {

		if (clientSessionInfo == null || clientSessionInfo.getClientId() == -1)	return new ModelAndView("/error/error");
		
		if (bindingResult.hasErrors()) {

			ModelAndView modelAndView = new ModelAndView("/loans/" + String.valueOf(loanPayForm.getLoanNumber()) + "/loanPayBegin");
			modelAndView.addObject("activeMenu","loans");
			modelAndView.addObject("loanPayForm", loanPayForm); 
			return modelAndView;			
		}else {

			Account account = accountService.getAccountByNumber(loanPayForm.getDebitAccountNumber());
			
			loanPayForm.setDebitAccountBalance(account.getBalance());
			
			ModelAndView modelAndView = new ModelAndView("/loans/loanPayConfirm");
			modelAndView.addObject("activeMenu","loans");
			modelAndView.addObject("loanPayForm", loanPayForm);
			return modelAndView;
		}

	}
	
	
	

	@RequestMapping(method = RequestMethod.POST, value = "/loans/loanPayResult")
	public ModelAndView postLoanPayResult(@ModelAttribute("loanPayForm") @Valid LoanPayForm loanPayForm,
			BindingResult bindingResult, HttpServletRequest request) {

		if (clientSessionInfo == null || clientSessionInfo.getClientId() == -1)	return new ModelAndView("/error/error");
		
		accountValidations.validateFunds(loanPayForm.getDebitAccountNumber(), loanPayForm.getPaymentAmount(), request , bindingResult);
		
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("/loans/loanPayConfirm");
			modelAndView.addObject("activeMenu","loans");
			modelAndView.addObject("loanPayForm", loanPayForm); 
			return modelAndView;
			
		} else {

			loanService.payLoanInstallment(loanPayForm.getLoanNumber(), loanPayForm.getPaymentId(), loanPayForm.getDebitAccountNumber() ,request);
			
			ModelAndView modelAndView = new ModelAndView("/loans/loanPayResult");
			modelAndView.addObject("activeMenu","loans");
			modelAndView.addObject("loanNumber",loanPayForm.getLoanNumber());
			modelAndView.addObject("loanPaymentNumber",loanPayForm.getPaymentId());
			return modelAndView;
		}
		
	}
	
	@ExceptionHandler
	public ModelAndView handleException(Exception ex) {
				
		ModelAndView modelAndView = new ModelAndView("/error/errorCommon");
		modelAndView.addObject("activeMenu","loans");
		return modelAndView;
	}
	
	
	
}
