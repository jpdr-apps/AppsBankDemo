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

	<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4" >
		<div
			class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
			<div style="vertical-align: middle !important">
				<span data-feather="dollar-sign"
					style="width: 30px; height: 30px; color: #800000 !important; vertical-align: middle !important">
				</span> 
				<span class="form-label fs-2" style="vertical-align: middle !important"> 
					<fmt:message
						key="listLoanPayments.title.message" bundle="${messageProperties}" />:
				</span>
				<span class="form-label fs-2 span-account-number-bd" style="vertical-align: middle !important">
					${loanForm.getNumber()}
				</span>
				
			</div>
		</div>
		<!--  <h4><fmt:message key = "listLoanPayments.loanNumber.message" bundle = "${messageProperties}"/>: ${loanForm.getNumber()}</h4>-->
<br>

		<div class="container"
			style="width: 90%; margin-left: 0; margin-right: auto;">


			<div class="row">

				<div class="col">
					 
					
					<input id="issueDate" readonly class="form-control"
						style="text-align: center"
						value="<c:out value="${loanForm.getIssueDate()}"/> " />

					<label class="form-label fs-6 form-label-bd">												
						<fmt:message key="issueDate" bundle="${messageProperties}" />						
					</label>


				</div>

				<div class="col">

					 <input id="loanAmount" readonly class="form-control"
						style="text-align: right"
						value="$ <fmt:formatNumber value="${loanForm.getLoanAmount()}"
														type="number" minFractionDigits="2"></fmt:formatNumber>" />

					<label class="form-label fs-6 form-label-bd">
						<fmt:message key="loanAmount" bundle="${messageProperties}" />
					</label>


				</div>


				<div class="col">

					<input id="interestRate" readonly class="form-control"
						style="text-align: right"
						value="<fmt:formatNumber value="${loanForm.getInterestRate()}"
										type="number" minFractionDigits="2"></fmt:formatNumber>" />

					<label class="form-label fs-6 form-label-bd">
						<fmt:message key="interestRate" bundle="${messageProperties}" />
					</label>


				</div>

					
					
					<!-- Periods -->
					
					<div class="col">

						<input id="periods" readonly class="form-control"   style="text-align: right" 
						value="<c:out value="${loanForm.getPeriods()}"/> "/>

						<label class="form-label fs-6 form-label-bd">
							<fmt:message key = "periods" bundle = "${messageProperties}"/>
						</label>

						<br>
					</div>
					
					</div>
							<div class="row">

					<!-- Remaining Periods -->
					 
					<div class="col">

						<input id="remainingPeriods" readonly class="form-control"   style="text-align: right" 
						value="<c:out value="${loanForm.getRemainingPeriods()}"/> "/>

						<label class="form-label fs-6 form-label-bd">
							<fmt:message key = "remainingPeriods" bundle = "${messageProperties}"/>
						</label>

						<br>
					</div>

<!-- Loan Balance -->

			<div class="col">

					
					
					<input id="balanceTotal" readonly class="form-control"
						style="text-align: right"
						value="$ <fmt:formatNumber value="${loanForm.getBalanceTotal()}"
														type="number" minFractionDigits="2"></fmt:formatNumber>" />
					<label class="form-label fs-6 form-label-bd">
						<fmt:message key="balanceTotal" bundle="${messageProperties}" />
					</label>


				</div>

				<!-- Interest Balance -->

			<div class="col">
					
					<input id="balancePrincipal" readonly class="form-control"
						style="text-align: right"
						value="$ <fmt:formatNumber value="${loanForm.getBalancePrincipal()}"
														type="number" minFractionDigits="2"></fmt:formatNumber>" />

					<label class="form-label fs-6 form-label-bd">
						<fmt:message key="balancePrincipal" bundle="${messageProperties}" />
					</label>


				</div>
				
				<!-- Interest Balance -->
				


			<div class="col">

					<input id="balanceInterest" readonly class="form-control"
						style="text-align: right"
						value="$ <fmt:formatNumber value="${loanForm.getBalanceInterest()}"
														type="number" minFractionDigits="2"></fmt:formatNumber>" />

					<label class="form-label fs-6 form-label-bd">
						<fmt:message key="balanceInterest" bundle="${messageProperties}" />
					</label> 
					


				</div>

			</div>

		</div>

		<div class="ps-lg-4 bankdemo-main-accordion">


			<table class="table table-striped">
				<thead>
					<tr>
						<td style="min-width: 50px; text-align: right; font-size: 12px;">
							<span class="form-label fs-6 ">
								<fmt:message key="listLoanPayments.loanPaymentNumber.message"
									bundle="${messageProperties}" />
							</span>
						</td>
						<td style="min-width: 100px; text-align: right; font-size: 12px;">
							<span class="form-label fs-6 ">
								<fmt:message key="listLoanPayments.loanPaymentDueDate.message"
									bundle="${messageProperties}" />
							</span>
						</td>
						<!-- 
						<td style="min-width: 75px; text-align: right; font-size: 12px;">
							<span class="form-label fs-6 ">
								<fmt:message key="listLoanPayments.loanPaymentStatus.message"
									bundle="${messageProperties}" />
							</span>
						</td>
						 -->
						<td style="min-width: 120px; text-align: right; font-size: 12px;">
							<span class="form-label fs-6 ">
								<fmt:message
									key="listLoanPayments.loanPaymentBeginningBalance.message"
									bundle="${messageProperties}" />
							</span>
						</td>
						<td style="min-width: 120px; text-align: right; font-size: 12px;">
							<span class="form-label fs-6 ">
								<fmt:message
									key="listLoanPayments.loanPaymentPaymentAmount.message"
									bundle="${messageProperties}" />
							</span>
						</td>
						<td style="min-width: 120px; text-align: right; font-size: 12px;">
							<span class="form-label fs-6 ">
								<fmt:message
									key="listLoanPayments.loanPaymentPrincipalAmount.message"
									bundle="${messageProperties}" />
							</span>
						</td>
						<td style="min-width: 120px; text-align: right; font-size: 12px;">
							<span class="form-label fs-6 ">
								<fmt:message
									key="listLoanPayments.loanPaymentInterestAmount.message"
									bundle="${messageProperties}" />
							</span>
						</td>
						<td style="min-width: 120px; text-align: right; font-size: 12px;">
							<span class="form-label fs-6 ">
								<fmt:message
									key="listLoanPayments.loanPaymentEndingBalance.message"
									bundle="${messageProperties}" />
							</span>
						</td>
						<td style="min-width: 120px; text-align: right; font-size: 12px;">
							<span class="form-label fs-6 ">
								<fmt:message
									key="listLoanPayments.loanPaymentPaymentDate.message"
									bundle="${messageProperties}" />
							</span>
						</td>
						<td style="min-width: 120px; text-align: right; font-size: 12px;">
							<span class="form-label fs-6 ">
								<fmt:message
									key="listLoanPayments.loanPaymentDebitAccount.message"
									bundle="${messageProperties}" />
							</span>
						</td>


					</tr>
				</thead>
				<tbody>

					<c:if
						test="${ loanFormPaymentsList.getLoanFormPayments().size() > 0 }">

						<c:forEach items="${ loanFormPaymentsList.getLoanFormPayments() }"
							var="loanFormPayment">

							<tr>
								<td
									style="min-width: 50px; font-size: 12px; text-align: right; width: 50px;">
									<span class="form-label fs-6 form-label-td-bd">
										<small>
											${loanFormPayment.getLoandPaymentId() }
										</small>
									</span>
								</td>
								
								<td
									style="min-width: 100px; font-size: 12px; text-align: right; width: 100px;">
									<span class="form-label fs-6 form-label-td-bd">
										<small>
											${loanFormPayment.getDueDate() }
										</small>
									</span>
								</td>
								<!-- 
								<td style="min-width: 75px; font-size: 12px; text-align: right;">
									<span class="form-label fs-6 form-label-td-bd">
										<small>
											${loanFormPayment.getStatus() }
										</small>
									</span>
								</td>
								 -->
								<td
									style="min-width: 120px; font-size: 12px; text-align: right;">
									
									<span class="form-label fs-6 form-label-td-bd">
										<small>
											$
											<fmt:formatNumber
												value="${loanFormPayment.getBeginningBalance() }"
												type="number" minFractionDigits="2"></fmt:formatNumber>
												</small>
										</span>
										
								</td>
								<td
									style="min-width: 120px; font-size: 12px; text-align: right;">
									
									<span class="form-label fs-6 form-label-td-bd">
										<small>
									
											$
											<fmt:formatNumber
												value="${loanFormPayment.getPaymentAmount()  }" type="number"
												minFractionDigits="2"></fmt:formatNumber>
										</small>
									</span>
								</td>

								<td
									style="min-width: 120px; font-size: 12px; text-align: right;">
									
									<span class="form-label fs-6 form-label-td-bd">
										<small>
									
											$
											<fmt:formatNumber
												value="${loanFormPayment.getPrincipalAmount()  }"
												type="number" minFractionDigits="2"></fmt:formatNumber>
										</small>
									</span>
										
								</td>

								<td
									style="min-width: 120px; font-size: 12px; text-align: right;">
									
									<span class="form-label fs-6 form-label-td-bd">
										<small>
									
											$
											<fmt:formatNumber
												value="${loanFormPayment.getInterestAmount() }" type="number"
												minFractionDigits="2"></fmt:formatNumber>
										
										</small>
									</span>										
										
								</td>
								<td
									style="min-width: 120px; font-size: 12px; text-align: right;">
									
									<span class="form-label fs-6 form-label-td-bd">
										<small>
									
											$
											<fmt:formatNumber
												value="${loanFormPayment.getEndingBalance() }" type="number"
												minFractionDigits="2"></fmt:formatNumber>
										</small>
									</span>
										
										
								</td>

								<c:if test="${ loanFormPayment.getDebitAccountNumber() > 0}">
									<td
										style="min-width: 120px; font-size: 12px; text-align: right;">
									
									<span class="form-label fs-6 form-label-td-bd">
										<small>
										
										${loanFormPayment.getPaymentDate() }
										
										</small>
									</span>
									
									</td>
									<td style="min-width: 120px; font-size: 12px; text-align: right;">
										<span class="form-label fs-6 form-label-td-bd">
											<small>									
											${ loanFormPayment.getDebitAccountNumber() }
											</small>
										</span>
									</td>
								</c:if>
								<c:if test="${ loanFormPayment.getDebitAccountNumber() == 0}">
									<td style="min-width: 120px; font-size: 12px; text-align: right;">
										<span class="form-label fs-6 form-label-td-bd">
											<small>
												-
											</small>
										</span>
									</td>
									<td style="min-width: 120px; font-size: 12px; text-align: right;">
										<span class="form-label fs-6 form-label-td-bd">
											<small>
												-
											</small>
										</span>
									</td>
								</c:if>
							</tr>

						</c:forEach>
					</c:if>
					<c:if
						test="${ loanFormPaymentsList.getLoanFormPayments().size() <= 0 }">
						<tr>
							<td colspan="4">
							
								<span class="form-label fs-6 form-label-td-bd">
																	
									<fmt:message
											key="listLoanPayments.NoPayments.message"
											bundle="${messageProperties}" />
								</span>
								
							</td>
						</tr>
					</c:if>
				</tbody>
			</table>
			<br> <input class="btn btn-primary"
				type="button" onClick="history.go(-1)"
				value="<fmt:message key = "forms.back.message" bundle = "${messageProperties}"/>">
		</div>
	</main>
</div>


<jsp:include page="/include/footer.jsp"></jsp:include>