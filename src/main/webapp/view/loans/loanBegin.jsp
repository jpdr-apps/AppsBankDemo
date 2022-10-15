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
				<span class="form-label fs-2"  style="vertical-align: middle !important"> <fmt:message
						key="loanBegin.newLoan.message" bundle="${messageProperties}" />
				</span>
			 </div>
			
		</div>
		<div class="ps-lg-4 ">
		
			<span class="form-label fs-6 "><fmt:message key = "loanBegin.completeForm.message" bundle = "${messageProperties}"/></span>
			<br>
			<br>
		
			<form:form action="/loans/loanConfirm" method="post" modelAttribute="loanForm" onsubmit="return replaceSeparator();">

			<div class="container" style="width: 50%; margin-left: 0;margin-right: auto;">

			<div class="row">
			<div class="col">
			

				<form:input type="hidden" path="decimalSeparator"/>


				
				
				
				
				<!--  <h5><fmt:message key = "amount" bundle = "${messageProperties}"/>:</h5> -->
				 
					<form:input type="text" id="amount" name="amount" path="loanAmount" class="form-control" style="width: 250px"
					 onkeypress="return isNumberKey(this,event);"
					 
					 />						 
					 <form:label path="loanAmount" for="amount"
										class="form-label fs-6 form-label-bd">
										<fmt:message key="loanAmount"
											bundle="${messageProperties}" />
									</form:label>				
	
					<form:errors path="loanAmount" cssStyle="color:Red" />
					<form:errors cssStyle="color:Red" />
				 	<br>

				</div>

				</div>
				
				
				
			<div class="row">
			<div class="col">
				
				
				
				<!-- <h5><fmt:message key = "interestRate" bundle = "${messageProperties}"/>:</h5>  -->
				
					<input id="interestRate" readonly class="form-control-plaintext  fs-6" 
					style="color:#800000; font-size: 20px!important;
					padding-top: 0px!important;padding-bottom: 0px!important;
					text-align: left; width: 250px"  
					value="<c:out value="${loanForm.getInterestRate()}"/> "/>
					
					<form:input path="interestRate" type="hidden"
						value="${loanForm.getInterestRate() }" />
						
						<form:label path="interestRate" for="amount"
										class="form-label fs-6 form-label-bd"
										>
										<fmt:message key="interestRate"
											bundle="${messageProperties}" />
									</form:label>				
						
											
					<form:errors path="interestRate" cssStyle="color:Red" />									
				
				<br>
				
				</div>
				</div>
				
				<div class="row">
				<div class="col">
				
				<!-- <h5><fmt:message key = "term" bundle = "${messageProperties}"/>:</h5>-->
				 
					<form:input type="text" id="term" name="term" path="term" class="form-control" style="width: 250px"
					 onkeypress="return isIntegerKey(this,event);"
					 
					 />
					 
					 <form:label path="term" for="term"
										class="form-label fs-6"
										style="display:block; width:x; height:y; text-align:left;color:grey!important;margin-bottom:0px!important;">
										<fmt:message key="term"
											bundle="${messageProperties}" />
									</form:label>					
	
					<form:errors path="term" cssStyle="color:Red" />
					<form:errors cssStyle="color:Red" />
				 
				<br>
				<br>
				
				</div>
				</div>
				
				<div class="row">
				<div class="col">
				
				<!--  <h5><fmt:message key = "creditAccount" bundle = "${messageProperties}"/>: </h5> -->
				 					
					<form:input type="hidden" path="internalAccounts"/>

					<form:select path="creditAccountNumber" style="width: 250px" class="form-select" id="creditAccountNumber">
						<form:options items="${loanForm.getInternalAccounts() }" />
					</form:select>
					
										 <form:label path="creditAccountNumber" for="creditAccountNumber"
										class="form-label fs-6"
										style="display:block; width:x; height:y; text-align:left;color:grey!important;margin-bottom:0px!important;">
										<fmt:message key="creditAccount"
											bundle="${messageProperties}" />
									</form:label>					
	
					
										
					<form:errors path="creditAccountNumber" cssStyle="color:Red" />
			
				</div>
				 
				</div>
				</div>
				
				<br>				
				<br>
				
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
				 
				<input class="btn btn-primary" type="button" onClick="history.go(-1)" style="width: 150px"
					value="<fmt:message key = "forms.back.message" bundle = "${messageProperties}"/>">
					
				<input class="btn btn-primary" type="submit" style="width: 150px"
					value="<fmt:message key = "forms.next.message" bundle = "${messageProperties}"/>">
	
		

			</form:form>

		</div>
	</main>
</div>



<script>

window.onload = replaceValues();


function isNumberKey(txt, evt) {

  var charCode = (evt.which) ? evt.which : evt.keyCode;

  if (charCode == 48) {
	if ( txt.value.length == 0 ) {
		return false;		
	 }
  }
  
    
  if (charCode == 46 ) {
	if('.' != '${loanForm.getDecimalSeparator()}' ){
		return false;
	}
  }
  if ( charCode == 44 ){
		if(',' != '${loanForm.getDecimalSeparator()}' ){
		return false;
	} 
  }	     
  if (charCode == 46 || charCode == 44 ) { 
	  if (txt.value.indexOf('${loanForm.getDecimalSeparator()}') == -1) {		 
	      return true;
	    } 
	  else {
	      return false;
	    }
  } else {

  	if (charCode > 31 && (charCode < 48 || charCode > 57) ) { return false };

		  	if ( txt.value.indexOf('${loanForm.getDecimalSeparator()}') != -1 ){
		  			if (txt.value.substr(txt.value.indexOf('${loanForm.getDecimalSeparator()}')+1).length == 2 ) 
			  			{ 
			  				return false 
			  			};
		  	}
  }
  
  return true;
}

function replaceSeparator(){

	var amountInput = document.getElementById("amount");	
	if(',' == '${loanForm.getDecimalSeparator()}' ){
		amountInput.value = amountInput.value.replace(",",".");		
	}
	return true
}

function replaceValues(){

	var amountInput = document.getElementById("amount");	
	if(amountInput.value == '0.0' ){
		//amountInput.value = '0' + '${loanForm.getDecimalSeparator()}' + '00';
		amountInput.value = '';	
	}

	var termInput = document.getElementById("term");
	if (termInput.value == '0'){
		termInput.value = '';
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