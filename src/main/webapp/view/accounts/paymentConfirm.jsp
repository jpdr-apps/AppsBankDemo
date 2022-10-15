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
					<span class="form-label fs-2 " style="vertical-align: middle !important"> <fmt:message
							key="paymentConfirm.confirmPayment.message" bundle="${messageProperties}" />
					</span>
				</div>			
			
		</div>
		<div class="ps-lg-4 ">

			<form:form action="/accounts/paymentSubmit" method="post"
				modelAttribute="paymentForm">

				<span class="form-label fs-6 ">
					<fmt:message key = "paymentConfirm.checkDetails.message" bundle = "${messageProperties}"/>:
				</span>
				<br>
				<br>

				<table>
					<tr>
						<td style="min-width: 350px">
							<span class="fs-6 span-highlight">
								<fmt:message key = "paymentConfirm.originAccountNumber.message" bundle = "${messageProperties}"/> 
							</span>
						</td>
						<td>
							<span class="fs-6">
								<form:label path="originAccount">${paymentForm.getOriginAccount() }</form:label>
								<form:input path="originAccount" type="hidden"
									value="${paymentForm.getOriginAccount() }" />
							</span>
						</td>
					</tr>
					
					<form:input path="originAccountBalance" type="hidden" />
					<form:input path="internalPayment" type="hidden" />
					<form:input path="internalAccounts" type="hidden" />
					<form:input path="externalAccounts" type="hidden" />
					
					<tr>
						<td style="min-width: 250px">
							<span class="fs-6 span-highlight">
								<fmt:message key = "paymentConfirm.destinationAccountNumber.message" bundle = "${messageProperties}"/> 
							</span>
						</td>
						<td>
							<span class="fs-6">
								<form:label path="destinationAccount">${paymentForm.getDestinationAccount() }</form:label>
								<form:input path="destinationAccount" type="hidden"
									value="${paymentForm.getDestinationAccount() }" />
							</span>
						</td>
					</tr>

					<tr>
						<td>
							<span class="fs-6 span-highlight">
								<fmt:message key = "paymentConfirm.beneficiaryDocumentID.message" bundle = "${messageProperties}"/> 
							</span>
						</td>
						<td>
							<span class="fs-6">
								<form:label path="destinationDocumentId"> ${paymentForm.getDestinationDocumentId() }</form:label>
								<form:input path="destinationDocumentId" type="hidden"
									value="${paymentForm.getDestinationDocumentId() }" />
							</span>
						</td>
					</tr>
					<tr>
						<td>
							<span class="fs-6 span-highlight">
								<fmt:message key = "paymentConfirm.beneficiaryName.message" bundle = "${messageProperties}"/>
							</span>
						</td>
						<td>
							<span class="fs-6">
								<form:label path="destinationFistName"> ${paymentForm.getDestinationLastName()}, ${paymentForm.getDestinationFistName() }</form:label>
								<form:input path="destinationFistName" type="hidden"
									value="${paymentForm.getDestinationFistName() }" />
								<form:input path="destinationLastName" type="hidden"
									value="${paymentForm.getDestinationLastName() }" />
							</span>
						</td>
					</tr>

					<tr>
						<td>
							<span class="fs-6 span-highlight">
								<fmt:message key = "amount" bundle = "${messageProperties}"/>
							</span>
						</td>
						<td>
							<span class="fs-6">
								<form:label path="amount">$ 
									<fmt:formatNumber value="${paymentForm.getAmount() }"
										type="number" minFractionDigits="2"></fmt:formatNumber>
								</form:label>
								<form:input path="amount" type="hidden"
									value="${paymentForm.getAmount() }" />
							</span>
						</td>
					</tr>
					<tr>
						<td>
							<span class="fs-6 span-highlight">
								<fmt:message key = "details" bundle = "${messageProperties}"/>
							</span>
						</td>
						<td>
							<span class="fs-6">
								<form:label path="details">${paymentForm.getDetails() }</form:label>
								<form:input path="details" type="hidden"
									value="${paymentForm.getDetails() }" />
							</span>
						</td>
					</tr>
				</table>
				
				<br>
				
							<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

				<a href="/accounts/${ accountNumber }/paymentBegin" style="width: 150px"
					class="btn btn-primary bankdemo-buton-primary"><fmt:message key = "forms.back.message" bundle = "${messageProperties}"/></a>			

				<input class="btn btn-primary bankdemo-buton-primary" type="submit" style="width: 150px"
					value="<fmt:message key = "forms.accept.message" bundle = "${messageProperties}"/>">

			</form:form>

		</div>
	</main>
</div>



<jsp:include page="/include/footer.jsp"></jsp:include>