package jpdr.apps.bankdemo.entities.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.core.convert.converter.Converter;

import jpdr.apps.bankdemo.forms.LoanFormPaymentsList;

public class StringToLoanFormPaymentListConverter implements Converter<String, LoanFormPaymentsList>{

	@Override
	public LoanFormPaymentsList convert(String source) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			return objectMapper.readValue(source,LoanFormPaymentsList.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	

}
