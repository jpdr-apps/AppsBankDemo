package jpdr.apps.bankdemo.services.exceptions;

public class NotActiveAccountException extends BankDemoException{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 6400405625732860952L;
	
	public NotActiveAccountException(String message) {
		super(message);
	}
	
	public static final String getMessageKey() {
		return "bankDemoException.notActiveAccountException.message";
	}

}
