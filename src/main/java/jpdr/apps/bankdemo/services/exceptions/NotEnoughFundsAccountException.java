package jpdr.apps.bankdemo.services.exceptions;

public class NotEnoughFundsAccountException extends BankDemoException{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 3260205063068312966L;

	public NotEnoughFundsAccountException(String message) {
		super(message);
	}
	
	public static final String getMessageKey() {
		return "bankDemoException.NotEnoughFundsAccountException.message";
	}

}
