package jpdr.apps.bankdemo.services.exceptions;

public class NotFoundAccountException extends BankDemoException {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 6419125391675705004L;

		public NotFoundAccountException(String message) {
		super(message);
	}
	
	public static final String getMessageKey() {
		return "bankDemoException.NotFoundAccountException.message";
	}

}
