package jpdr.apps.bankdemo.forms;

import java.util.ArrayList;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import jpdr.apps.bankdemo.forms.validation.ValidateAsDecimal;
import jpdr.apps.bankdemo.forms.validation.ValidateClassLessEqualToDoubleFields;

@ValidateClassLessEqualToDoubleFields.List({
	@ValidateClassLessEqualToDoubleFields(fieldBase = "amount", fieldMatch = "originAccountBalance" )
})

public class PaymentForm {

	private int originAccount;	
	private double originAccountBalance;
	private boolean internalPayment = false;
	private int destinationAccount;
	private ArrayList<String> internalAccounts;
	private ArrayList<String> externalAccounts;
	private String destinationFistName;
	private String destinationLastName;
	private String destinationDocumentId;
	private char decimalSeparator;
	@Positive
	@ValidateAsDecimal(integerDigits = 18,fractionalDigits = 2)
	private double amount;
	@Size(min = 0, max = 20)
	private String details;
	
	public PaymentForm() {
	
	}
	
	public int getOriginAccount() {
		return originAccount;
	}
	public void setOriginAccount(int originAccount) {
		this.originAccount = originAccount;
	}
	public int getDestinationAccount() {
		return destinationAccount;
	}
	public void setDestinationAccount(int destinationAccount) {
		this.destinationAccount = destinationAccount;
	}
	public String getDestinationFistName() {
		return destinationFistName;
	}
	public void setDestinationFistName(String destinationFistName) {
		this.destinationFistName = destinationFistName;
	}
	public String getDestinationLastName() {
		return destinationLastName;
	}
	public void setDestinationLastName(String destinationLastName) {
		this.destinationLastName = destinationLastName;
	}
	public String getDestinationDocumentId() {
		return destinationDocumentId;
	}
	public void setDestinationDocumentId(String destinationDocumentId) {
		this.destinationDocumentId = destinationDocumentId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public boolean isInternalPayment() {
		return internalPayment;
	}
	public void setInternalPayment(boolean internalPayment) {
		this.internalPayment = internalPayment;
	}

	public double getOriginAccountBalance() {
		return originAccountBalance;
	}

	public void setOriginAccountBalance(double originAccountBalance) {
		this.originAccountBalance = originAccountBalance;
	}

	public ArrayList<String> getInternalAccounts() {
		return internalAccounts;
	}

	public void setInternalAccounts(ArrayList<String> internalAccounts) {
		this.internalAccounts = internalAccounts;
	}

	public ArrayList<String> getExternalAccounts() {
		return externalAccounts;
	}

	public void setExternalAccounts(ArrayList<String> externalAccounts) {
		this.externalAccounts = externalAccounts;
	}

	public char getDecimalSeparator() {
		return decimalSeparator;
		
	}

	public void setDecimalSeparator(char decimalSeparator) {
		this.decimalSeparator = decimalSeparator;
		
	}

	@Override
	public String toString() {
		return "PaymentForm [originAccount=" + originAccount + ", originAccountBalance=" + originAccountBalance
				+ ", internalPayment=" + internalPayment + ", destinationAccount=" + destinationAccount
				+ ", internalAccounts=" + internalAccounts + ", externalAccounts=" + externalAccounts
				+ ", destinationFistName=" + destinationFistName + ", destinationLastName=" + destinationLastName
				+ ", destinationDocumentId=" + destinationDocumentId + ", decimalSeparator=" + decimalSeparator
				+ ", amount=" + amount + ", details=" + details + "]";
	}

	 
 

	
 
	
	

}
