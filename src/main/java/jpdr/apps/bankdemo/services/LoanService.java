package jpdr.apps.bankdemo.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jpdr.apps.bankdemo.entities.Account;
import jpdr.apps.bankdemo.entities.EntitiesList;
import jpdr.apps.bankdemo.entities.Loan;
import jpdr.apps.bankdemo.entities.LoanPayment;
import jpdr.apps.bankdemo.entities.ProductTypes;
import jpdr.apps.bankdemo.entities.TransactionConcept;
import jpdr.apps.bankdemo.entities.keys.LoanPaymentsId;
import jpdr.apps.bankdemo.forms.LoanForm;
import jpdr.apps.bankdemo.forms.LoanFormPayment;
import jpdr.apps.bankdemo.forms.LoanFormPaymentsList;
import jpdr.apps.bankdemo.repositories.LoanPaymentsRepository;
import jpdr.apps.bankdemo.repositories.LoanRepository;

@Service
public class LoanService {
	
	
	public static final int INITIAL_LOAN_NUMBER = 5000000;
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private LoanPaymentsRepository loanPaymentsRepository;
	
	@Autowired
	private ClientsProductsService clientsProductsService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private LocaleService localeService;
		
	
	public LoanService() {	
	}
	
	public Loan getLoan(double amount, int term, double interestRate, int creditAccountNumber ) {
		
		//Date date = Calendar.getInstance().getTime();
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//String issueDate = dateFormat.format(date);
		
		String issueDate = localeService.getCurrentDate();
		
		String status = "ACTIVE";
		
		double loanAmount = amount;
			
		int periods = term * 12;
		
		Loan loan = new Loan(issueDate, status, loanAmount, term, periods, interestRate, creditAccountNumber);

		setLoanPayments(loan);
		
		return loan;
	}
	
	public Loan getLoanByNumberWithPayments(int loanNumber) {
		
		Loan loan = loanRepository.findByNumber(loanNumber);
		ArrayList<LoanPayment> loanPayments = loanPaymentsRepository.findByLoanPaymentsId_LoanIdOrderByLoanPaymentsId_PaymentIdDesc(
				loan.getId(),
				Sort.by("loanPaymentsId.paymentId").ascending()
				);				
		loan.setLoanPayments(loanPayments);
		return loan;
		
	}
			
	public Loan getLoanByNumberWithOutPayments(int loanNumber) {
		
		Loan loan = loanRepository.findByNumber(loanNumber);		
		return loan;
		
	}
	
	public LoanForm getLoanForm(Loan loan) {
		
		LoanForm loanForm = new LoanForm(
		loan.getNumber(),
		localeService.getLocalizedDate(loan.getIssueDate()),
		loan.getStatus(),
		localeService.getDecimalSeparator(),
		loan.getLoanAmount(),
		loan.getTerm(),
		loan.getPeriods(),
		loan.getInterestRate(),		
		String.valueOf(loan.getCreditAccountNumber()),
		loan.getBalanceInterest(),
		loan.getBalancePrincipal(),		
		loan.getBalanceTotal(),		
		loan.getRemainingPeriods(),
		localeService.getLocalizedDate(loan.getNextDueDate())
		);
		return loanForm;
	}
	
	
		
	
	private int getNextLoanNumber() {
		
		Integer number = loanRepository.getNextLoanNumber();

		if (number == null) {
			number = INITIAL_LOAN_NUMBER;
		} else {
			number++;
		}
		return (int) number;
	}
	
	
	
	public void setLoanPayments(Loan loan){
		
		ArrayList<LoanPayment> loanPayments = new ArrayList<LoanPayment>();
		
		String dueDate = getNextDate(loan.getIssueDate(), 1);	
		String nextDueDate = dueDate.toString();
		
		double loanAmount =  loan.getLoanAmount();
		double beginningBalance = loan.getLoanAmount();
		double paymentRate = loan.getInterestRate();
		
		double paymentTemp1 =  paymentRate / 12 / 100 * loanAmount;
		double paymentTemp2 = ( 1 - Math.pow(1 + loan.getInterestRate() / 12 / 100, loan.getPeriods() * -1));
		double paymentAmount = paymentTemp1/paymentTemp2;
		
		double balanceInterest = 0d;
		double balancePrincipal = 0d;
		double balanceTotal = 0d;

		for(int i=1 ; i<=loan.getPeriods();i++ ) {			
			
			double principalTemp1 = ( Math.pow(1 + loan.getInterestRate() / 12 / 100, loan.getPeriods())-1);
			double principalTemp2 = ( Math.pow(1 + loan.getInterestRate() / 12 / 100, i-1));			

			double principal =  paymentTemp1 / principalTemp1 * principalTemp2;
			
			balancePrincipal = balancePrincipal + principal;
			
			double interest = paymentAmount - principal;
			
			balanceInterest = balanceInterest + interest;
			
			double endingBalance = beginningBalance - principal;	
			
			balanceTotal = balanceTotal + paymentAmount;
			
			LoanPayment loanPayment = new LoanPayment(
					new LoanPaymentsId(-1, i),
					dueDate,
					"ACTIVE",
					roundAsDouble(beginningBalance), 
					roundAsDouble(paymentAmount), 
					roundAsDouble(principal), 
					roundAsDouble(interest), 
					roundAsDouble(endingBalance),
					null);			
			
			loanPayments.add(loanPayment);
			
			dueDate = getNextDate(dueDate,1);			
						
			beginningBalance = beginningBalance - principal;
			
		}
		
		
		
		double difference = loanPayments.get(loanPayments.size()-1).getEndingBalance();
		
		if (difference == -0.00d) {
			loanPayments.get(loanPayments.size() - 1).setEndingBalance(0.00d);
		}
/*		
		if ( difference != 0 ) {
			
			float interestAmount = roundAsFloat(Double.valueOf(Float.toString(loanPayments.get(loanPayments.size()-1).getInterestAmount() + difference * -1)),2);			
			
			loanPayments.get(loanPayments.size()-1).setInterestAmount(interestAmount);
			
			balanceInterest = roundAsDouble(balanceInterest + difference * -1,2);			
			
			loanPayments.get(loanPayments.size()-1).setPrincipalAmount(
					loanPayments.get(loanPayments.size()-1).getPrincipalAmount() + difference);
			balancePrincipal = roundAsDouble(balancePrincipal + difference,2);
			
			loanPayments.get(loanPayments.size()-1).setEndingBalance(0);
		}
		*/
		loan.setRemainingPeriods(loan.getPeriods());
		loan.setNextDueDate(nextDueDate);
		loan.setBalanceInterest(roundAsDouble(balanceInterest));
		loan.setBalanceTotal(roundAsDouble(balanceTotal));
		loan.setBalancePrincipal(roundAsDouble(balancePrincipal));
		loan.setLoanPayments(loanPayments);
					
	}
	
	
	
	
	private static double roundAsDouble(double value) {
		//BigDecimal bd = new BigDecimal(Double.toString(value));
	    //bd = bd.setScale(2, RoundingMode.HALF_UP);		
		//return bd.doubleValue();		
		String valueAsString = String.format("%.2f", value).replace(',', '.');
		return Double.valueOf(valueAsString);
	}
	
	private static String getNextDate(String dateStart, int months) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Calendar calendar = Calendar.getInstance(); 
				
		try {
			calendar.setTime(dateFormat.parse(dateStart));			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		calendar.add(Calendar.MONTH, months);
		
		return dateFormat.format(calendar.getTime());
		
	
	}
	
	public void debugPrintLoanPayments(ArrayList<LoanPayment> loanPayments) {
	
		for (LoanPayment p: loanPayments) {
			
			System.out.println(p.getLoanPaymentsId() 
					+ "     " + p.getDueDate() 
					+ "     " + p.getBeginningBalance() 
					+ "     " + p.getPaymentAmount() 
					+ "     " + p.getPrincipalAmount()    
					+ "     " + p.getInterestAmount()  
					+ "     " + p.getEndingBalance() 
					+ "     " + p.getStatus() 
					+ "     " + p.getPaymentDate());
			
		}			
	}

	public Loan addLoan(int clientId, Loan loan) {

		int loanNumber = getNextLoanNumber();		
		loan.setNumber(loanNumber);		
		loanRepository.save(loan);
		
		ArrayList<LoanPayment> loanPayments = (ArrayList<LoanPayment>) loan.getLoanPayments();
		
		for (LoanPayment lp : loanPayments ) {			
			lp.getLoanPaymentsId().setLoanId(loan.getId());			
			loanPaymentsRepository.save(lp);			
		}
		
		loan.setLoanPayments(loanPayments);
		
		clientsProductsService.addProduct(ProductTypes.PRODUCT_TYPE_LOAN, clientId, loan.getId());

		Account account = accountService.getAccountByNumber(loan.getCreditAccountNumber());
		
		accountService.addTransaction(account, TransactionConcept.LOAN_CREDIT, loan.getLoanAmount(), "N°: " + loan.getNumber());
		
		return loan;
		
	}

	public EntitiesList<LoanForm> getActiveLoans(int clientId) {

		ArrayList<Loan> loans = loanRepository.findAllWithClientIdAndStatus(clientId, "ACTIVE");

		ArrayList<LoanForm> loanForms = new ArrayList<LoanForm>();
		
		if (loans != null) {
		
			int loansSize = loans.size();
		
			for(int i = 0 ; i< loansSize; i++) {				
				loanForms.add( getLoanForm(loans.get(i))  );				
			}					
		}
		
		EntitiesList<LoanForm> clientLoans = new EntitiesList<LoanForm>();

		clientLoans.setEntities(loanForms);
		
		return clientLoans;
	}

	public LoanFormPaymentsList getLoanFormPayments(ArrayList<LoanPayment> loanPayments) {
 
		int loanPaymentsSize = loanPayments.size();
		
		ArrayList<LoanFormPayment> loanFormPayments = new ArrayList<LoanFormPayment>();
		
		for(int i = 0; i< loanPaymentsSize; i++ ) {
			
			String localizedDueDate = localeService.getLocalizedDate(loanPayments.get(i).getDueDate() ); 
			String localizedPaymentDate = localeService.getLocalizedDate(loanPayments.get(i).getPaymentDate() );
			
			loanPayments.get(i).setDueDate(localizedDueDate);
			loanPayments.get(i).setPaymentDate(localizedPaymentDate);
			
			loanFormPayments.add(new LoanFormPayment(loanPayments.get(i)));			
		}
		
		return new LoanFormPaymentsList(loanFormPayments);
	}

	public Loan createLoan(int clientId, LoanForm loanForm ) {
		
		String issueDate = localeService.formatDateForDB(loanForm.getIssueDate() );
		String nextDueDate =  localeService.formatDateForDB(loanForm.getNextDueDate() );
		
		Loan loan = new Loan(				
				getNextLoanNumber(),
				issueDate,
				"ACTIVE",
				loanForm.getLoanAmount(),
				loanForm.getTerm(),
				loanForm.getPeriods(),
				loanForm.getInterestRate(),
				loanForm.getBalanceInterest(),
				loanForm.getCreditAccountNumberAsInteger(),
				loanForm.getBalanceInterest(),
				loanForm.getBalancePrincipal(),
				loanForm.getBalanceTotal(),
				loanForm.getRemainingPeriods(),
				nextDueDate			
				); 
				
		loanRepository.save(loan);
		
		loan.setLoanPayments(new ArrayList<LoanPayment>());
		
		LoanFormPaymentsList loanFormPaymentsList = loanForm.getLoanFormPayments();
		
		int loanFormPaymentsSize = loanFormPaymentsList.getLoanFormPayments().size();
		
		for (int i = 0; i < loanFormPaymentsSize; i++) {			
			
			LoanPayment loanPayment = new LoanPayment(
					
					new LoanPaymentsId(
							loan.getId(),
							loanFormPaymentsList.getLoanFormPayments().get(i).getLoandPaymentId()),
							localeService.formatDateForDB(loanFormPaymentsList.getLoanFormPayments().get(i).getDueDate() ),
							loanFormPaymentsList.getLoanFormPayments().get(i).getStatus(),
							loanFormPaymentsList.getLoanFormPayments().get(i).getBeginningBalance(),
							loanFormPaymentsList.getLoanFormPayments().get(i).getPaymentAmount(),
							loanFormPaymentsList.getLoanFormPayments().get(i).getPrincipalAmount(),
							loanFormPaymentsList.getLoanFormPayments().get(i).getInterestAmount(),
							loanFormPaymentsList.getLoanFormPayments().get(i).getEndingBalance(),
							localeService.formatDateForDB(loanFormPaymentsList.getLoanFormPayments().get(i).getPaymentDate() ),
							loanFormPaymentsList.getLoanFormPayments().get(i).getDebitAccountNumber()
							);			
			loanPaymentsRepository.save(loanPayment);
			loan.getLoanPayments().add(loanPayment);
		}
		
		clientsProductsService.addProduct(ProductTypes.PRODUCT_TYPE_LOAN, clientId, loan.getId());

		Account account = accountService.getAccountByNumber(loan.getCreditAccountNumber());
		
		
		accountService.addTransaction(account, TransactionConcept.LOAN_CREDIT, loan.getLoanAmount(), "N°: "  + loan.getNumber() );
		
		return loan;
		
	}

	public LoanPayment getNextActivePaymentFromLoan(int loanId) { 
		//return loanPaymentsRepository.getNextActivePaymentFromLoan(loanId, Pageable.ofSize(1));
		return loanPaymentsRepository.findFirst1ByLoanPaymentsIdLoanIdAndStatusOrderByLoanPaymentsId(loanId,"ACTIVE");
	}

	public void payLoanInstallment(int loanNumber, int loanPaymentNumber, int accountNumber) {

		Loan loan = loanRepository.findByNumber(loanNumber);
		
		LoanPaymentsId loanPaymentsId = new LoanPaymentsId(loan.getId(), loanPaymentNumber);
		
		LoanPayment loanPayment = loanPaymentsRepository.findById(loanPaymentsId).orElse(null);
		
		Account account = accountService.getAccountByNumber(accountNumber);
		
		
		int remainingPeriods = loan.getRemainingPeriods() - 1;
		loan.setRemainingPeriods(remainingPeriods);
		
		if (remainingPeriods > 0) {
			LoanPayment nextloanPayment = loanPaymentsRepository.findFirst1ByLoanPaymentsIdLoanIdAndStatusOrderByLoanPaymentsId(loan.getId(), "ACTIVE");
			loan.setNextDueDate(nextloanPayment.getDueDate());
		}else {				
				loanPayment.setInterestAmount(loan.getBalanceInterest());
				loanPayment.setPrincipalAmount(loan.getBalancePrincipal());
				loanPayment.setPaymentAmount(loan.getBalanceTotal());
				loan.setStatus("PAID");
		}
		
		loan.setBalanceInterest(roundAsDouble(loan.getBalanceInterest() - loanPayment.getInterestAmount()));
		loan.setBalancePrincipal(roundAsDouble(loan.getBalancePrincipal() - loanPayment.getPrincipalAmount()));
		loan.setBalanceTotal(roundAsDouble(loan.getBalanceTotal() - loanPayment.getPaymentAmount()));

		loanPayment.setDebitAccountNumber(accountNumber);
		loanPayment.setPaymentDate(localeService.getCurrentDate());
		loanPayment.setStatus("PAID");
		
		accountService.addTransaction(account,TransactionConcept.LOAN_DEBIT,loanPayment.getPaymentAmount() * -1, "N°: " + String.valueOf(loanNumber) + " - " + String.valueOf(loanPaymentNumber));
		 	
		loanPaymentsRepository.save(loanPayment);		
		
		loanRepository.save(loan);

	}

	public double getClientLoansBalance(int clientId) {

		Double balance = loanRepository.getClientLoansBalance(clientId);
		
		if ( balance == null ) return 0.0;
		
		return balance; 
		
	}

 
	
}
