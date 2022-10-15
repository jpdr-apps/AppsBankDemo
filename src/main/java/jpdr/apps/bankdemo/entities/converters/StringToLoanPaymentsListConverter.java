package jpdr.apps.bankdemo.entities.converters;

import java.util.List;

import org.springframework.core.convert.converter.Converter;

import jpdr.apps.bankdemo.entities.LoanPayment;

public class StringToLoanPaymentsListConverter implements Converter<String, List<LoanPayment>>{

	@Override
	public List<LoanPayment> convert(String source) {
		
		String data = source;
		
		return null;
	}

	
	
}
