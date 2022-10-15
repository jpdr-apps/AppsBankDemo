package jpdr.apps.bankdemo.entities.converters;

import org.springframework.core.convert.converter.Converter;

import jpdr.apps.bankdemo.entities.LoanPayment;
import jpdr.apps.bankdemo.entities.keys.LoanPaymentsId;

public class StringToLoanPaymentConverter implements Converter<String, LoanPayment>{

	@Override
	public LoanPayment convert(String source) {
		String[] data = source.split(",");
			
		LoanPayment loanPayment =  new LoanPayment(
				
				new LoanPaymentsId(
						Integer.parseInt(data[0]),Integer.parseInt(data[1])),  
				data[2],
				data[3],
				Float.parseFloat(data[4]),
				Float.parseFloat(data[5]),
				Float.parseFloat(data[6]),
				Float.parseFloat(data[7]),
				Float.parseFloat(data[8]),
				data[9],
				Integer.parseInt(data[10])
				);		
		return loanPayment;
	}
	
	

}
