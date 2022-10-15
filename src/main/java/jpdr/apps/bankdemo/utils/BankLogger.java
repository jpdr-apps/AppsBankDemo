package jpdr.apps.bankdemo.utils;

public class BankLogger {

	public static final boolean LOG = true;
	
	public static final int INFO = 0;
	public static final int WARNING = 1;
	public static final int ERROR = 2;

	public static void log(int severityCode, String msg) {

		if (LOG) {

			String severity = "INFO: ";

			switch (severityCode) {
				case INFO: {
					severity = "INFO: ";
					break;
				}
				case WARNING: {
					severity = "WARNING: ";
					break;
				}
				case ERROR: {
					severity = "ERROR: ";
					break;
				}
				default:
					break;
			}

			System.out.println(severity + msg);

		}

	}

}
