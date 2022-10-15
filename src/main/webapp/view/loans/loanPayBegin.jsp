<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<fmt:setBundle basename="messages" var="messageProperties"/>

<jsp:include page="/include/header.jsp"></jsp:include>

<div>
	<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
		
		<div
			class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">

			<div style="vertical-align: middle !important">
					<span data-feather="dollar-sign"
						style="width: 30px; height: 30px; color: #800000 !important; vertical-align: middle !important">
					</span> 
					<span class="form-label fs-2" style="vertical-align: middle !important"> <fmt:message
							key="loanPayBegin.title.message" bundle="${messageProperties}" />
					</span>
			</div>
		
		</div>
		
				
		
		
		
		
		
		
		
		
		<div class="ps-lg-4 ">
		
			<span class="form-label fs-6 ">
			<fmt:message key = "loanPayBegin.confirmDetails.message" bundle = "${messageProperties}"/>
			</span>
			<br>
			<br>
		
			<form:form action="/loans/loanPayConfirm" method="post" modelAttribute="loanPayForm" onsubmit="return replaceSeparator();">


					<div class="container" style="width: 50%; margin-left: 0;margin-right: auto;">
				
						
							<div class="row">
																						
				<!-- number -->
							 
									 <div class="col">

										<input id="loanNumber" readonly class="form-control" style="text-align: center" 
										value="<c:out value="${loanPayForm.getLoanNumber()}"/> "/>
										
										<form:label path="loanNumber" for="loanNumber" class="form-label fs-6 form-label-bd">										
											<fmt:message key = "loanPayBegin.loanNumber.message" bundle = "${messageProperties}"/>
										</form:label>
										
										<form:input path="loanNumber" type="hidden"
											value="${loanPayForm.getLoanNumber() }" />						
					
										<form:errors path="loanNumber"
												cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
										<br>	
																						
									
								</div>
							<!-- paymentId -->	
									<div class="col">

										<input id="paymentId" readonly class="form-control" style="text-align: center" 
										value="<c:out value="${loanPayForm.getPaymentId()}"/> "/>

										<form:label path="paymentId" for="paymentId" class="form-label fs-6 form-label-bd">
											<fmt:message key = "loanPayBegin.loanPaymentNumber.message" bundle = "${messageProperties}"/>
										</form:label>
										
										<form:input path="paymentId" type="hidden"
											value="${loanPayForm.getPaymentId() }" />						
					
										<form:errors path="paymentId"
												cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
										<br>	
																						
							
									</div>

				<!-- dueDate -->
							
								<div class="col">
					
										<input id="dueDate" readonly class="form-control" style="text-align: center" 
										value="<c:out value="${loanPayForm.getDueDate()}"/> "/>

										<form:label path="dueDate" for="dueDate" class="form-label fs-6 form-label-bd">
											<fmt:message key = "loanPayBegin.loanPaymentDueDate.message" bundle = "${messageProperties}"/>
										</form:label>
										
										<form:input path="dueDate" type="hidden"
											value="${loanPayForm.getDueDate() }" />						
					
										<form:errors path="dueDate"
												cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
										<br>	
																						
								</div>

									
							</div>
							<div class="row">
									
							</div>
				<!-- paymentAmount -->
							<div class="row">
									<div class="col">
													
										<input id="paymentAmount" readonly class="form-control"  style="text-align: right" 
										value="$ <fmt:formatNumber value="${loanPayForm.getPaymentAmount()}"
														type="number" minFractionDigits="2"></fmt:formatNumber>"/>
			
										<form:label path="paymentAmount" for="paymentAmount" class="form-label fs-6 form-label-bd">
											<fmt:message key = "loanPayBegin.paymentAmount.message" bundle = "${messageProperties}"/>
										</form:label>
			
				
										<form:input path="paymentAmount" type="hidden"
										value="${loanPayForm.getPaymentAmount() }" />	
				
										<form:errors path="paymentAmount"
											cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
										<br>
										
									</div>
							
 
							
				<!-- Balance -->
					 
									<div class="col">

										<input id="loanBalance" readonly class="form-control"  style="text-align: right" 
										value="$ <fmt:formatNumber value="${loanPayForm.getLoanBalance()}"
														type="number" minFractionDigits="2"></fmt:formatNumber>"/>

										<form:label path="loanBalance" for="loanBalance" class="form-label fs-6 form-label-bd">
											<fmt:message key = "loanPayBegin.loanBalance.message" bundle = "${messageProperties}"/>
										</form:label>

				
										<form:input path="loanBalance" type="hidden"
										value="${loanPayForm.getLoanBalance() }" />	
				
										<form:errors path="loanBalance"
											cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
										<br>
										
									</div>
							

							</div>
				<!-- internalAccounts -->
				<!-- debitAccountNumber -->
							<div class="row">
								<div class="col">
					
									<form:input type="hidden" path="internalAccounts"/>
					
									<form:select path="debitAccountNumber" class="form-select" id="debitAccountNumber">
										<form:options items="${loanPayForm.getInternalAccounts() }" />
									</form:select>
										
									<span class="form-label fs-6 form-label-bd">
										<fmt:message key = "loanPayBegin.loanPaymentDebitAccount.message" bundle = "${messageProperties}"/>										
									</span>
										
									<form:errors path="debitAccountNumber" cssStyle="color:Red" />
									 
									<br>									

								</div>
								<div class="col"></div>
							</div>
				
				</div>
				
				<br>
				
			<!-- debitAccountBalance EMPTY-->
			
			<form:input path="paymentDate" type="hidden"
											value="${loanPayForm.getPaymentDate() }" />						
			
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
				 
				<input class="btn btn-primary" type="button" onClick="history.go(-1)"
					value="<fmt:message key = "forms.cancel.message" bundle = "${messageProperties}"/>">
					
				<input class="btn btn-primary" type="submit"
					value="<fmt:message key = "forms.next.message" bundle = "${messageProperties}"/>">
			</form:form>

		</div>
	</main>
</div>



<script>

window.onload = replaceZeroValue();


function isNumberKey(txt, evt) {
  var charCode = (evt.which) ? evt.which : evt.keyCode;  
  if (charCode == 46 ) {
	if('.' != '${decimalSeparator}' ){
		return false;
	}
  }
  if ( charCode == 44 ){
		if(',' != '${decimalSeparator}' ){
		return false;
	} 
  }	     
  if (charCode == 46 || charCode == 44 ) { 
	  if (txt.value.indexOf('${decimalSeparator}') == -1) {
		 
	      return true;
	    } 
	  else {
	      return false;
	    }
  } else {
    	if (charCode > 31 && (charCode < 48 || charCode > 57) )
      		return false;
  	}

  return true;
}

function replaceSeparator(){

	var amountInput = document.getElementById("amount");	
	if(',' == '${decimalSeparator}' ){
		amountInput.value = amountInput.value.replace(",",".");		
	}
	return true

}

function replaceZeroValue(){

	var amountInput = document.getElementById("amount");	
	if(amountInput.value == '0.0' ){
		amountInput.value = '0' + '${decimalSeparator}' + '00';	
	}
	return true
}

function isIntegerKey(txt, evt) {
	  var charCode = (evt.which) ? evt.which : evt.keyCode;  
	   if (charCode > 31 && (charCode < 48 || charCode > 57) )
	      		return false;
	  return true;
}




</script>

<jsp:include page="/include/footer.jsp"></jsp:include>