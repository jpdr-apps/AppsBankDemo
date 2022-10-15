<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<span data-feather="book"
						style="width: 30px; height: 30px; color: #800000 !important; vertical-align: middle !important">
					</span> 
					<span class="form-label fs-2" style="vertical-align: middle !important"> <fmt:message
							key="paymentBegin.newPayment.message" bundle="${messageProperties}" />
					</span>
			</div>

		</div>
		
		
		
		
		<div class="ps-lg-4 ">

		
		<br>		
		
			<form:form action="/accounts/${paymentForm.getOriginAccount() }/paymentConfirm" method="post" modelAttribute="paymentForm" onsubmit="return replaceSeparator();">


				<div class="container" style="width: 50%; margin-left: 0;margin-right: auto;">
				
						
					<div class="row">
				
				
						<div class="col">
							
								<input id="originAccount" readonly class="form-control" style="text-align: center;" 
										value="<c:out value="${paymentForm.getOriginAccount()}"/> "/>
										
								<form:label path="originAccount" for="originAccount" class="form-label fs-6 form-label-bd">										
									<fmt:message key = "paymentBegin.originAccountNumber.message" bundle = "${messageProperties}"/>
								</form:label>
										
								<form:input path="originAccount" type="hidden"	value="${paymentForm.getOriginAccount()}" />						
					
								<form:errors path="originAccount"
												cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />	
						</div>
				
						<div class="col"></div>
				
					</div>
					
					<br>
								
					<div class="row">
				
				
						<div class="col">
						
								<input id="originAccountBalance" readonly class="form-control" style="text-align: right;" 
										value="$ <fmt:formatNumber value="${paymentForm.getOriginAccountBalance() }"
											type="number" minFractionDigits="2"></fmt:formatNumber>"/>
										
								<form:label path="originAccountBalance" for="originAccountBalance" class="form-label fs-6 form-label-bd">										
									<fmt:message key = "paymentBegin.originAccountBalance.message" bundle = "${messageProperties}"/>
								</form:label>
										
								<form:input path="originAccountBalance" type="hidden"	value="${paymentForm.getOriginAccountBalance() }" />						
					
								<form:errors path="originAccountBalance"
												cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
								<br>
						
						</div>
				
						<div class="col"></div>
						
					</div>
					
					<div class="row">
				
				
						<div class="col">
														
								<span class="form-label fs-6 form-label-bd">										
									<fmt:message key = "paymentBegin.transferOwnAccounts.message" bundle = "${messageProperties}"/>?
								</span>
								
								<span class="form-label fs-6">
									<form:radiobutton name="internal" value="false" class="form-check-input"
										path="internalPayment" onclick="populateSelectWithAccounts(false)" />
									<fmt:message key = "forms.no.message" bundle = "${messageProperties}"/>
								</span>					

								<span class="form-label fs-6">
									<form:radiobutton name="internal" value="true" class="form-check-input"
									path="internalPayment" onclick="populateSelectWithAccounts(true)" />
									<fmt:message key = "forms.yes.message" bundle = "${messageProperties}"/>
								</span>													
								
								<br>
								<br>										
				
							</div>	
							
						</div>
						
						<div class="row">
						
							<div class="col">
							
								<form:input type="hidden" path="internalAccounts"/>
								<form:input type="hidden" path="externalAccounts"/>
										
								<form:select path="destinationAccount" style="width: 250px" class="form-select" id="selectWithAccounts">
									<c:if test="${paymentForm.isInternalPayment() == false}">
										<form:options items="${paymentForm.getExternalAccounts() }" />
									</c:if>
									<c:if test="${paymentForm.isInternalPayment() == true}">
										<form:options items="${paymentForm.getInternalAccounts() }" />
									</c:if>
								</form:select>
								
								<form:label path="destinationAccount" for="destinationAccount" class="form-label fs-6 form-label-bd">										
									<fmt:message key = "paymentBegin.destinationAccountNumber.message" bundle = "${messageProperties}"/>
								</form:label>
										
											
								<form:errors path="destinationAccount" cssStyle="color:Red" />

						
							</div>
							
							<div class="col"></div>
						
						
						</div>
					
				
				<br>
				<form:input type="hidden" path="decimalSeparator"/>
				
					<div class="row">
				
				
						<div class="col">
							
								<form:input type="text" id="amount" name="amount" path="amount" class="form-control" style="width: 250px"
					 			onkeypress="return isNumberKey(this,event);"/>	
										
								<form:label path="amount" for="amount" class="form-label fs-6 form-label-bd">										
									<fmt:message key = "amount" bundle = "${messageProperties}"/>
								</form:label>
					
								<form:errors path="amount"
												cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
								<form:errors cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />	
						</div>
				
						<div class="col"></div>
				
					</div>
					
					<br>				
				
				
				
				
					<div class="row">
				
				
						<div class="col">
							
								<form:input type="text" id="details" name="details" path="details" class="form-control" style="width: 250px"/>	
										
								<form:label path="details" for="details" class="form-label fs-6 form-label-bd">										
									<fmt:message key = "details" bundle = "${messageProperties}"/>
								</form:label>
					
								<form:errors path="details"
												cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />								
						</div>
				
						<div class="col"></div>
				
					</div>
					
					<br>
				
				</div>

				<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
				
		
				<input class="btn btn-primary " type="button" onClick="history.go(-1)" 
					value="<fmt:message key = "forms.cancel.message" bundle = "${messageProperties}"/>">
									
				<input class="btn btn-primary " type="submit" 
					value="<fmt:message key = "forms.next.message" bundle = "${messageProperties}"/>">

			</form:form>

		</div>
	</main>
</div>



<script>



var internalAccountsList = ${paymentForm.getInternalAccounts()};
if(internalAccountsList.length == 0){
	internalAccountsList = ["<fmt:message key = "paymentBegin.noAccounts.message" bundle = "${messageProperties}"/>"];
}
var externalAccountsList = ${paymentForm.getExternalAccounts()};
if(externalAccountsList.length == 0 ){
	externalAccountsList = ["<fmt:message key = "paymentBegin.noAccounts.message" bundle = "${messageProperties}"/>"];
}

window.onload = populateSelectWithAccounts(${paymentForm.isInternalPayment()});
window.onload = replaceZeroValue();


function populateSelectWithAccounts(useClientAccounts){
	var selectWithAccounts = document.getElementById("selectWithAccounts");	
	selectWithAccounts.options.length = 0;
	var accountsList = [];
	
	if(useClientAccounts){
		accountsList = internalAccountsList;
	}else{
		accountsList = externalAccountsList;
	}
	
	for(var i=0; i < accountsList.length; i++){
		var accountString = accountsList[i];
		var accountOption = document.createElement("option");
		accountOption.text = accountString;
		accountOption.value = accountString;
		selectWithAccounts.add(accountOption); 
	}	
}

function isNumberKey(txt, evt) {
	
  var charCode = (evt.which) ? evt.which : evt.keyCode;

  if (charCode == 48) {
		if ( txt.value.length == 0 ) {
			return false;		
		 }
	  }

    
  if (charCode == 46 ) {
	if('.' != '${paymentForm.getDecimalSeparator()}' ){
		return false;
	}
  }
  if ( charCode == 44 ){
		if(',' != '${paymentForm.getDecimalSeparator()}' ){
		return false;
	} 
  }	     
  if (charCode == 46 || charCode == 44 ) { 
	  if (txt.value.indexOf('${paymentForm.getDecimalSeparator()}') == -1) {
		 
	      return true;
	    } 
	  else {
	      return false;
	    }
  } else {
    	if (charCode > 31 && (charCode < 48 || charCode > 57) ) {        
      		return false;
    	}

	  	if ( txt.value.indexOf('${paymentForm.getDecimalSeparator()}') != -1 ){
  			if (txt.value.substr(txt.value.indexOf('${paymentForm.getDecimalSeparator()}')+1).length == 2 ) 
	  			{ 
	  				return false 
	  			};
  		}
    	
  	}

  return true;
}

function replaceSeparator(){

	var amountInput = document.getElementById("amount");	
	if(',' == '${paymentForm.getDecimalSeparator()}' ){
		amountInput.value = amountInput.value.replace(",",".");		
	}
	return true
}

function replaceZeroValue(){

	var amountInput = document.getElementById("amount");	
	if(amountInput.value == '0.0' ){
	//	amountInput.value = '0' + '${paymentForm.getDecimalSeparator()}' + '00';
		amountInput.value = '';		
	}
	return true
}




</script>

<jsp:include page="/include/footer.jsp"></jsp:include>