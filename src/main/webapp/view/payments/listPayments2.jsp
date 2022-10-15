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
						<span data-feather="list"
							style="width: 30px; height: 30px; color: #800000 !important; vertical-align: middle !important">
						</span> 
						<span class="form-label fs-2" style="vertical-align: middle !important"> <fmt:message
								key="paymentList.title.message" bundle="${messageProperties}" />
						</span>
		
				</div>								
		</div>				
		<div class="ps-lg-4 bankdemo-main-accordion">


			<table class="table table-striped">
				<thead>
					<tr>
						<td style="min-width:100px;text-align: left;font-size: 12px;">
							<span class="form-label fs-6 ">
								<fmt:message key = "date" bundle = "${messageProperties}"/>
							</span>
						</td>
						<td style="min-width:200px;text-align: left;font-size: 12px;">
							<span class="form-label fs-6 ">
								<fmt:message key = "paymentConfirm.originAccountNumber.message" bundle = "${messageProperties}"/>
							</span>
						</td>
						<td style="min-width:150px;text-align: left;font-size: 12px;">
							<span class="form-label fs-6 ">
								<fmt:message key = "paymentConfirm.destinationAccountNumber.message" bundle = "${messageProperties}"/>
							</span>
						</td>
						<td style="min-width:150px;text-align: left;font-size: 12px;">
							<span class="form-label fs-6 ">
								<fmt:message key = "paymentConfirm.beneficiaryDocumentID.message" bundle = "${messageProperties}"/>
							</span>
						</td>
						<td style="min-width:150px;text-align: left;font-size: 12px;">
							<span class="form-label fs-6 ">
								<fmt:message key = "paymentConfirm.beneficiaryName.message" bundle = "${messageProperties}"/>
							</span>
						</td>
						<td style="min-width:200px;text-align: center;font-size: 12px;">
							<span class="form-label fs-6 ">
								<fmt:message key = "amount" bundle = "${messageProperties}"/>
							</span>
						</td>
						<td style="min-width:250px;text-align: left;font-size: 12px; ">
							<span class="form-label fs-6 ">
								<fmt:message key = "details" bundle = "${messageProperties}"/>
							</span>
						</td>
					</tr>
				</thead>
				<tbody>

					<c:if test="${ payments.getEntities().size() > 0 }">

						<c:forEach items="${ payments.getEntities() }"
							var="payment">

							<tr>
								<td style="min-width:100px;font-size: 12px;text-align: left;width: 500px;">
									<span class="form-label fs-6 form-label-td-bd">
										<small>
											${payment.getDate() }
										</small>
									</span>
								</td>
								<td style="min-width:200px;font-size: 12px;text-align: left;width: 500px;">
									<span class="form-label fs-6 form-label-td-bd">
										<small>								
											${payment.getOriginAccountNumber() }
										</small>
									</span>
								</td>
								<td style="min-width:150px;font-size: 12px;text-align: left;">
									<span class="form-label fs-6 form-label-td-bd">
										<small>
											${payment.getDestinationAccountNumber() }
										</small>
									</span>
								</td>
								<td style="min-width:150px;font-size: 12px;text-align: left;">
									<span class="form-label fs-6 form-label-td-bd">
										<small>
											${payment.getDestinationDocumentId() }
										</small>
									</span>
								</td>
								<td style="min-width:150px;font-size: 12px;text-align: left;">
									<span class="form-label fs-6 form-label-td-bd">
										<small>
											${payment.getDestinationFullName() }
										</small>
									</span>
								</td>
								<td style="min-width:200px;font-size: 12px;text-align: right; padding-right: 5em;">
									<span class="form-label fs-6 form-label-td-bd">
										<small>
											$ <fmt:formatNumber value="${payment.getAmount() }"
											type="number" minFractionDigits="2"></fmt:formatNumber>
										</small>
									</span>
								</td>
								<td style="min-width:250px;font-size: 12px;text-align: left;">
									<span class="form-label fs-6 form-label-td-bd">
										<small>
											${payment.getDetails() }
										</small>
									</span>
								</td>
							</tr>

						</c:forEach>
					</c:if>
					<c:if test="${ transactions.getEntities().size() <= 0 }">
						<tr>
							<td colspan="4">
								<span class="form-label fs-6 form-label-td-bd">										
									<fmt:message key = "listTransactions.noTransactions.message" bundle = "${messageProperties}"/>
								</span>
							</td>								
						</tr>
					</c:if>
				</tbody>
			</table>
				
				<input class="btn btn-primary" type="button" onClick="history.go(-1)"
					value="<fmt:message key = "forms.back.message" bundle = "${messageProperties}"/>">
			</div>
	</main>
</div>


<jsp:include page="/include/footer.jsp"></jsp:include>