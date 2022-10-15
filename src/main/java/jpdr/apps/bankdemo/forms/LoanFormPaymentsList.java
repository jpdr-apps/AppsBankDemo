package jpdr.apps.bankdemo.forms;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoanFormPaymentsList {
	
	private ArrayList<LoanFormPayment> loanFormPayments = new ArrayList<LoanFormPayment>();
	
	public LoanFormPaymentsList() {	}

	public LoanFormPaymentsList(ArrayList<LoanFormPayment> loanFormPayments) {
		 
		this.loanFormPayments = loanFormPayments;
	}

	public ArrayList<LoanFormPayment> getLoanFormPayments() {
		return loanFormPayments;
	}

	public void setLoanFormPayments(ArrayList<LoanFormPayment> loanFormPayments) {
		this.loanFormPayments = loanFormPayments;
	}

	@Override
	public String toString() {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			return objectMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {			
			e.printStackTrace();
		}
		return null;
	}
	
	

	 

}
