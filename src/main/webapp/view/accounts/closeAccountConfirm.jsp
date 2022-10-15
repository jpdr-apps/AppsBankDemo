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
							key="closeAccountConfirm.closeAccount.message" bundle="${messageProperties}" />
					</span>
				</div>

		</div>
		
		<div class="ps-lg-4 bankdemo-content">

			<form:form action="/accounts/closeAccountSubmit" method="post" modelAttribute="closeAccountForm">
			
			<span class="form-label fs-6">
				<fmt:message key = "closeAccountConfirm.aboutToClose.message" bundle = "${messageProperties}"/>
			</span>
			<span class="form-label fs-6 span-highlight">
				<strong>${closeAccountForm.getAccountNumber() }</strong>
			</span>			
			<br>
			<span class="form-label fs-6">
				<fmt:message key = "closeAccountConfirm.pleaseConfirm.message" bundle = "${messageProperties}"/>			
			</span>
			
			<br>
			<br>
			
			<form:input type="hidden" path="accountNumber" />

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

				<a href="/accounts" class="btn btn-primary">
				<fmt:message key = "forms.cancel.message" bundle = "${messageProperties}"/>
				</a> 

				<input class="btn btn-primary" type="submit"
					value="<fmt:message key = "forms.accept.message" bundle = "${messageProperties}"/>">

			</form:form>

		</div>
	</main>
</div>

<jsp:include page="/include/footer.jsp"></jsp:include>