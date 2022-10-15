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
				<span class="form-label fs-2" style="vertical-align: middle !important"> <fmt:message
						key="listTransactions.title.message" bundle="${messageProperties}" />:
				</span>
				<span class="form-label fs-2 span-account-number-bd" style="vertical-align: middle !important"> 					
					${accountNumber}					
				</span>
		</div>
		
		
		</div>
		


				
		<div class="ps-lg-4 bankdemo-main-accordion">


			<table class="table table-striped">
				<thead>
					<tr>
						<td><span class="form-label fs-5 "><fmt:message key = "date" bundle = "${messageProperties}"/></span></td>
						<td><span class="form-label fs-5 "><fmt:message key = "concept" bundle = "${messageProperties}"/></span></td>
						<td><span class="form-label fs-5 "><fmt:message key = "details" bundle = "${messageProperties}"/></span></td>
						<td style="text-align: right;padding-right: 5em;"><span class="form-label fs-5 "><fmt:message key = "amount" bundle = "${messageProperties}"/></span></td>
						<td style="text-align: right;padding-right: 5em;"><span class="form-label fs-5 "><fmt:message key = "balance" bundle = "${messageProperties}"/></span></td>
					</tr>
				</thead>
				<tbody>

					<c:if test="${ transactions.getEntities().size() > 0 }">

						<c:forEach items="${ transactions.getEntities() }"
							var="transaction">

							<tr>
								<td style="min-width:100px"><span class="form-label fs-6 form-label-td-bd">${transaction.getDate() }</span> </td>
								<td style="min-width:200px"><span class="form-label fs-6 form-label-td-bd">${transaction.getConcept() }</span> </td>
								<td style="min-width:250px"><span class="form-label fs-6 form-label-td-bd">${transaction.getDetails() }</span> </td>
								
								<c:if test="${transaction.getAmount() >= 0}">
										<td style="min-width:200px;text-align: right; padding-right: 5em;">
										
										<span class="form-label fs-6 form-label-td-bd">
										$ <fmt:formatNumber value="${transaction.getAmount() }"
										type="number" minFractionDigits="2"></fmt:formatNumber>
										</span>
										
										</td>
								</c:if>
								
								<c:if test="${transaction.getAmount() < 0}">
																
									<td style="min-width:200px ; color:red; text-align: right; padding-right: 5em;">
									
									<span class="form-label fs-6 form-label-td-bd-negative">
									$ <fmt:formatNumber value="${transaction.getAmount() }"
									type="number" minFractionDigits="2"></fmt:formatNumber>
									</span>
									</td>
									
								</c:if>
								
								
								<td style="min-width:250px; text-align: right; padding-right: 5em;">
								
								<span class="form-label fs-6 form-label-td-bd">
								
								$ <fmt:formatNumber value="${transaction.getBalance() }"
								type="number" minFractionDigits="2"></fmt:formatNumber>
								
								</span>
								
								</td>
							</tr>
							
							

						</c:forEach>
					</c:if>
					<c:if test="${ transactions.getEntities().size() <= 0 }">
						<tr>
							<td colspan="4"><fmt:message key = "listTransactions.noTransactions.message" bundle = "${messageProperties}"/></td>
						</tr>
					</c:if>
				</tbody>
			</table>
			<br>
				
				<input class="btn btn-primary bankdemo-buton-primary" type="button" onClick="history.go(-1)" style="width: 150px"
					value="<fmt:message key = "forms.back.message" bundle = "${messageProperties}"/>">
		</div>
	</main>
</div>


<jsp:include page="/include/footer.jsp"></jsp:include>