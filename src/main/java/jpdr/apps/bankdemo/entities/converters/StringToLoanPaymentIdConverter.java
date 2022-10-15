package jpdr.apps.bankdemo.entities.converters;

import org.springframework.core.convert.converter.Converter;

import jpdr.apps.bankdemo.entities.keys.LoanPaymentsId;

public class StringToLoanPaymentIdConverter implements Converter<String, LoanPaymentsId>{

	@Override
	public LoanPaymentsId convert(String source) {
		
		String[] data = source.split(","); 
		
		LoanPaymentsId loanPaymentsId = new LoanPaymentsId(
				Integer.parseInt(data[0]),
				Integer.parseInt(data[1])
				);
		
		return loanPaymentsId;
	}

}
