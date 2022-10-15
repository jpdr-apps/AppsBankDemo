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
	<!-- Title -->
		<div
			class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
			
			<div style="vertical-align: middle !important">			
				<span data-feather="dollar-sign"
					style="width: 30px; height: 30px; color: #800000 !important; vertical-align: middle !important">
				</span> 
				<span class="form-label fs-2"  style="vertical-align: middle !important"> <fmt:message
						key="loanConfirm.confirmTitle.message" bundle="${messageProperties}" />
				</span>
			 </div>			
			
		</div>
	<!-- Message -->
		<div class="ps-lg-4 ">
		<span class="form-label fs-6 "><fmt:message key = "loanConfirm.plaseConfirm.message" bundle = "${messageProperties}"/></span>
			<br>
		<br>
		
		<form:form action="/loans/loanResults" method="post"
				modelAttribute="loanForm">
		
		<div class="container" style="width: 50%; margin-left: 0;margin-right: auto;">
				<div class="row">
					<div class="col">
					
					<!-- Loan Issue Date -->
					
					<input id="issueDate" readonly class="form-control" style="text-align: center" 
					value="<c:out value="${loanForm.getIssueDate()}"/> "/>

					<form:label path="issueDate" for="issueDate" class="form-label fs-6 form-label-bd">							
					<fmt:message key = "issueDate" bundle = "${messageProperties}"/>
					</form:label>
					
					<form:input path="issueDate" type="hidden"
						value="${loanForm.getIssueDate() }" />						
					
					<form:errors path="issueDate"
							cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
						<br>													
					</div>
					<div class="col"></div>
					<div class="col"></div>
					<div class="col"></div>
				</div>
				<div class="row">
				
				
						<form:input path="status" type="hidden"
						value="${loanForm.getStatus() }" />	
						
						<form:input path="decimalSeparator" type="hidden"
						value="${loanForm.getDecimalSeparator() }" />
					

					<!-- Loan Amount -->
					
					<div class="col">

						<input id="loanAmount" readonly class="form-control"  style="text-align: right" 
						value="$ <fmt:formatNumber value="${loanForm.getLoanAmount()}"
										type="number" minFractionDigits="2"></fmt:formatNumber>"/>
										
						<form:label path="loanAmount" for="loanAmount" class="form-label fs-6 form-label-bd">
						<fmt:message key = "loanConfirm.loanAmount.message" bundle = "${messageProperties}"/>
						</form:label>

						<form:input path="loanAmount" type="hidden"
						value="${loanForm.getLoanAmount() }" />	

						<form:errors path="loanAmount"
							cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
						<br>
					</div>
					
					<!-- Interest Rate -->
					
					<div class="col">

						
						<input id="interestRate" readonly class="form-control"  style="text-align: right"
						value="<fmt:formatNumber value="${loanForm.getInterestRate()}"
										type="number" minFractionDigits="2"></fmt:formatNumber>"/> 

						<form:label path="interestRate" for="interestRate" class="form-label fs-6 form-label-bd">
						<fmt:message key = "interestRate" bundle = "${messageProperties}"/>
						</form:label>


						<form:input path="interestRate" type="hidden"
						value="${loanForm.getInterestRate() }" />	
												
						
						<form:errors path="interestRate"
							cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
						<br>
					</div>	
				
							<div class="col"></div>					
					
				</div>
					
				<div class="row">
					
					
					<!-- Term -->
					
					<div class="col">



						
						<input id="term" readonly class="form-control"   style="text-align: right" 
						value="<c:out value="${loanForm.getTerm()}"/> "/>

						<form:label path="term" for="term" class="form-label fs-6 form-label-bd">
						<fmt:message key = "term" bundle = "${messageProperties}"/>
						</form:label>

						<form:input path="term" type="hidden"
						value="${loanForm.getTerm() }" />	
													
						<form:errors path="term"
							cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
						<br>
					</div>
					
					
					<!-- Periods -->
					
					<div class="col">

						<input id="periods" readonly class="form-control"   style="text-align: right" 
						value="<c:out value="${loanForm.getPeriods()}"/> "/>

						<form:label path="periods" for="periods" class="form-label fs-6 form-label-bd">
						<fmt:message key = "periods" bundle = "${messageProperties}"/>
						</form:label>


						<form:input path="periods" type="hidden"
						value="${loanForm.getPeriods() }" />	
						
						<form:errors path="periods"
							cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
						<br>
					</div>
				
				<div class="col"></div>		
					
				</div>
					
				<div class="row">
							
					
					
					<!-- Credit Account Number -->
					
					<div class="col">
						
						<input id="creditAccountNumber" readonly class="form-control"    style="text-align: right"   
						value="<c:out value="${loanForm.getCreditAccountNumber()}"/> "/>

						<form:label path="creditAccountNumber" for="creditAccountNumber" class="form-label fs-6 form-label-bd">
						<fmt:message key = "creditAccount" bundle = "${messageProperties}"/>
						</form:label>


						<form:input path="creditAccountNumber" type="hidden"
						value="${loanForm.getCreditAccountNumber() }" />							
						
						<form:errors path="creditAccountNumber"
							cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
						<br>
					</div>
					
					<div class="col"></div>		
					<div class="col"></div>		
					<div class="col"></div>			
					
				</div>
					
				<div class="row">					
					
					<!-- Total Interest Amount -->
					
					<div class="col">

						<input id="balanceInterest" readonly class="form-control"    style="text-align: right"   
						value="$ <fmt:formatNumber value="${loanForm.getBalanceInterest()}"
										type="number" minFractionDigits="2"></fmt:formatNumber>"/>

						<form:label path="balanceInterest" for="balanceInterest" class="form-label fs-6 form-label-bd">
						<fmt:message key = "loanConfirm.balanceInterest.message" bundle = "${messageProperties}"/>
						</form:label>

						
						<form:input path="balanceInterest" type="hidden"
						value="${loanForm.getBalanceInterest() }" />							
						
						
						<form:errors path="balanceInterest"
							cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
						<br>
					</div>						
					
					
					<!--  Total Payments Amount  -->
	
					<div class="col">

						<input id="balanceTotal" readonly class="form-control"     style="text-align: right" 
						value="$ <fmt:formatNumber value="${loanForm.getBalanceTotal()}"
										type="number" minFractionDigits="2"></fmt:formatNumber>"/>

						<form:label path="balanceTotal" for="balanceTotal" class="form-label fs-6 form-label-bd">
						<fmt:message key = "loanConfirm.balanceTotal.message" bundle = "${messageProperties}"/>
						</form:label>

						
						<form:input path="balanceTotal" type="hidden"
						value="${loanForm.getBalanceTotal() }" />						
						
						<form:errors path="balanceTotal"
							cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
						<br>
					</div>					
					
					<div class="col"></div>	
					
				</div>

				<br>
				
				
				
			</div>
				
		 
				<form:input path="balancePrincipal" type="hidden"
					value="${loanForm.getBalancePrincipal() }" />		
			
				<form:input path="remainingPeriods" type="hidden"
						value="${loanForm.getRemainingPeriods() }" />
			
				<form:input path="nextDueDate" type="hidden"
						value="${loanForm.getNextDueDate() }" />
			
				<form:input path="loanFormPayments" type="hidden"
						value="${loanForm.getLoanFormPayments() }" />	
		 
					<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		
			
					<input class="btn btn-primary" type="button" onClick="window.location.href= '/loans/loanBegin'" style="width: 150px"
					value="<fmt:message key = "forms.back.message" bundle = "${messageProperties}"/>">

					<input class="btn btn-primary" type="submit" style="width: 150px"
					value="<fmt:message key = "forms.accept.message" bundle = "${messageProperties}"/>">
		
			
		
		</form:form>
		</div>	 
	</main>
</div>


<jsp:include page="/include/footer.jsp"></jsp:include>