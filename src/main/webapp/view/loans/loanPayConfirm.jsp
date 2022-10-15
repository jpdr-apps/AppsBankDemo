<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<fmt:setBundle basename="messages" var="messageProperties" />
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
							key="loanPayConfirm.confirmPayment.message" bundle="${messageProperties}" />
					</span>
			</div>
			
			
			
		</div>
		<div class="ps-lg-4 ">

			<span class="form-label fs-6 ">
				<fmt:message key="loanPayConfirm.checkDetails.message"
						bundle="${messageProperties}" />			
			</span>
			<br>
			<br>
		
			<form:form action="/loans/loanPayResult" method="post"
				modelAttribute="loanPayForm">

				<table>
				<!-- Loan number -->
					<tr>
						<td style="min-width: 350px">
							<span class="fs-6 span-highlight">
								<fmt:message
									key="loanNumber"
									bundle="${messageProperties}" />								
							</span>
						</td>
						<td style="text-align: right;">
							<span class="fs-6">
								<form:label path="loanNumber">${loanPayForm.getLoanNumber() }</form:label>
								<form:input path="loanNumber" type="hidden"
									value="${loanPayForm.getLoanNumber() }" />
							</span>
						</td>
					</tr>
					<!--Payment Id-->
					<tr>
						<td style="min-width: 250px">
							<span class="fs-6 span-highlight">
								<fmt:message
									key="loanPaymentNumber"
									bundle="${messageProperties}" />
 							</span>
						</td>
						<td  style="text-align: right;">
							<span class="fs-6">
								<form:label path="paymentId">${loanPayForm.getPaymentId() }</form:label>
								<form:input path="paymentId" type="hidden"
									value="${loanPayForm.getPaymentId() }" />
							</span>
						</td>
					</tr>
		
								<!-- dueDate -->
					<tr>
						<td style="min-width: 250px">
							<span class="fs-6 span-highlight">
								<fmt:message
									key="dueDate"
									bundle="${messageProperties}" />
							</span>
						</td>
						<td  style="text-align: right;">
							<span class="fs-6">
								<form:label path="dueDate">${loanPayForm.getDueDate() }</form:label>
								<form:input path="dueDate" type="hidden"
									value="${loanPayForm.getDueDate() }" />
							</span>
						</td>
					</tr>	




					
					
				<!-- paymentAmount -->	
						<tr>
						<td style="min-width: 250px">
							<span class="fs-6 span-highlight">
								<fmt:message
									key="paymentAmount"
									bundle="${messageProperties}" /> 
								
							</span>
						</td>
						<td  style="text-align: right;">
							<span class="fs-6">
								<form:label path="paymentAmount">$ <fmt:formatNumber value="${loanPayForm.getPaymentAmount() }"
										type="number" minFractionDigits="2"></fmt:formatNumber></form:label>
								<form:input path="paymentAmount" type="hidden"
									value="${loanPayForm.getPaymentAmount() }" />
							</span>
						</td>
					</tr>		
					
					<!-- debitAccountNumber -->	
					
					<tr>
						<td style="min-width: 250px">
							<span class="fs-6 span-highlight">
								<fmt:message key = "debitAccountNumber" bundle = "${messageProperties}"/>
							</span>
						</td>
						<td  style="text-align: right;">
							<span class="fs-6">
								<form:label path="debitAccountNumber">${loanPayForm.getDebitAccountNumber() }</form:label>
								<form:input path="debitAccountNumber" type="hidden"
									value="${loanPayForm.getDebitAccountNumber() }" />
							</span>
						</td>
					</tr>
					
					
				<!-- debitAccountBalance -->
					
					 <tr>
						<td style="min-width: 250px">
							<span class="fs-6 span-highlight">
								<fmt:message key = "debitAccountBalance" bundle = "${messageProperties}"/>
							</span>
						</td>
						<td  style="text-align: right;">
							<span class="fs-6">
								<form:label path="debitAccountBalance">
									$ <fmt:formatNumber value="${loanPayForm.getDebitAccountBalance() }"
										type="number" minFractionDigits="2"></fmt:formatNumber>
								</form:label>
								<form:input path="debitAccountBalance" type="hidden"
									value="${loanPayForm.getDebitAccountBalance() }" />
							</span>
						
						</td>
					</tr>

				</table>

				<br>
				<h6>
				<form:errors path="*" cssStyle="color:Red; display:block; width:x; height:y; text-align:left;"  />
				</h6>
				<br>
				
				<form:input path="paymentDate" type="hidden"
				value="${loanPayForm.getPaymentDate() }" />

				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

				<a href="/loans/${ loanPayForm.getLoanNumber() }/loanPayBegin"
					style="width: 150px" class="btn btn-primary bankdemo-buton-primary"><fmt:message
						key="forms.back.message" bundle="${messageProperties}" /></a>

				<input class="btn btn-primary bankdemo-buton-primary" type="submit"
					style="width: 150px"
					value="<fmt:message key = "forms.accept.message" bundle = "${messageProperties}"/>">

			</form:form>

		</div>
	</main>
</div>



<jsp:include page="/include/footer.jsp"></jsp:include>