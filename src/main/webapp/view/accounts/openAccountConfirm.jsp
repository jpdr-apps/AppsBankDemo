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
					<span data-feather="book"
						style="width: 30px; height: 30px; color: #800000 !important; vertical-align: middle !important">
					</span> 
					<span class="form-label fs-2 " style="vertical-align: middle !important"> <fmt:message
							key="openAccountConfirm.newAccount.message" bundle="${messageProperties}" />
					</span>
				</div>

		</div>
		
		
		
		
		
		<div class="ps-lg-4 bankdemo-content">

			<form:form action="/accounts/openAccountSubmit" method="post">
			
			<span class="form-label fs-6"><fmt:message key = "openAccountConfirm.aboutToOpen.message" bundle = "${messageProperties}"/></span>
			<br>
			<span class="form-label fs-6"><fmt:message key = "openAccountConfirm.pleaseConfirm.message" bundle = "${messageProperties}"/></span>
			<br>
			<br>

				<a href="/accounts" class="btn btn-primary " style="width: 150px;"><fmt:message key = "forms.cancel.message" bundle = "${messageProperties}"/></a> 

			    <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />


				<input class="btn btn-primary" type="submit"
					value="<fmt:message key = "forms.accept.message" bundle = "${messageProperties}"/>">

			</form:form>

		</div>
	</main>
</div>



<script>



var internalAccountsList = ${internalAccounts.toString()};
if(internalAccountsList.length == 0){
	internalAccountsList = ["<fmt:message key = "openAccountConfirm.noAccounts.message" bundle = "${messageProperties}"/>"];
}
var externalAccountsList = ${externalAccounts.toString()};
if(externalAccountsList.length == 0 ){
	externalAccountsList = ["<fmt:message key = "openAccountConfirm.noAccounts.message" bundle = "${messageProperties}"/>"];
}

window.onload = populateSelectWithAccounts(${paymentForm.isInternalPayment()});


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
/*
function validateForm(){

	var formOK = true;
	var originAccount = document.getElementById("originAccount").htmlFor;
	var selectWithAccounts = document.getElementById("selectWithAccounts").value;
	var amount = document.getElementById("amount").value;	

	if(isNaN(originAccount) || originAccount < 100000000 || originAccount > 999999999 ){
		alert(originAccount);
		document.getElementById("originAccountError").innerHTML = "Invalid account" ;
		formOK=false;
	}
	if(isNaN(selectWithAccounts) || selectWithAccounts < 100000000 || selectWithAccounts > 999999999 ){
		document.getElementById("selectWithAccounts").innerHTML = "Invalid account" ;
		formOK=false;
	}

	if(isNaN(amount) || amount < 0 || amount > 99999999999999){
		document.getElementById("amount").innerHTML = "Invalid amount" ;
		formOK=false;
	}
	
	return formOK;
}
*/
 

</script>

<jsp:include page="/include/footer.jsp"></jsp:include>