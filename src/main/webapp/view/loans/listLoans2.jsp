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
			<h1 class="h2" style="vertical-align: middle !important">
				<span data-feather="dollar-sign"
					style="width: 30px; height: 30px; color: #800000 !important; vertical-align: middle !important">
				</span> <span style="vertical-align: middle !important"> <fmt:message
						key="loans" bundle="${messageProperties}" />
				</span>
			</h1>
		</div>
		<div class="ps-lg-4 bankdemo-main-accordion">

			<form id="formBeginLoan" action="/loans/loanBegin" method="post">
				<div class="card bankdemo-card bankdemo-card_clickable"
					style="position: relative; height: 100px !important; width: auto !important; margin-left: 0 !important; margin-right: 0 !important; margin-top: 0 !important; margin-bottom: 5px !important; padding: 10px !important;">
					<div
						style="width: 100%; position: absolute; text-align: center !important; top: 50%; -ms-transform: translateY(-50%); transform: translateY(-50%);">
						<h4>
							<fmt:message key="listLoans.getNewLoan.message"
								bundle="${messageProperties}" />

							<span data-feather="plus-circle"
								style="color: #ff0000; width: 32px; height: 32px;" /></span>
						</h4>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /> 
					</div>
					<a class="stretched-link" href="#"
							onclick='submitBeginLoanForm()'></a>
				</div>
			</form>


			<div class="list-group">



				<c:forEach items="${ loanForms.getEntities() }" var="loanForm">

					<div class="list-group-item" style="padding-top: 16px!important;padding-bottom: 16px!important;">
						<div class="d-flex w-100 justify-content-between">
							<h5 class="mb-1">
								<fmt:message key="loan" bundle="${messageProperties}" />
								N°: ${ loanForm.getNumber() }
							</h5>

						</div>
						<div class="d-flex w-100 justify-content-between">
							<h6 class="mb-1">
								<small class="mb-1"> <fmt:message
										key="listLoans.balance.message"
										bundle="${messageProperties}" /> $ 
										<fmt:formatNumber value="${ loanForm.getBalanceTotal() }"
										type="number" minFractionDigits="2"></fmt:formatNumber>
										
										
								</small>
							</h6>
							<h6>
								<small> <fmt:message
										key="listLoans.remaningPayments.message"
										bundle="${messageProperties}" /> : ${ loanForm.getRemainingPeriods() }
								</small>
							</h6>
						</div>
						<div>						
						<h6>						
						<small class="text-muted">
						
						<fmt:message
										key="listLoans.nextDueDate.message"
										bundle="${messageProperties}" /> : ${ loanForm.getNextDueDate() }
						
						</small>
						</h6> 						
			 			</div>

						<div class="d-flex justify-content-evenly">
							
								<button type="button" class="btn  btn-primary" onclick="location.href = '/loans/${ loanForm.getNumber() }/listLoanPayments';" ><fmt:message
										key="listLoans.installments.message"
										bundle="${messageProperties}" /></button>
								<button type="button" class="btn btn-primary" onclick="location.href = '/loans/${ loanForm.getNumber() }/loanPayBegin';"><fmt:message
										key="listLoans.payNext.message"
										bundle="${messageProperties}" /></button>
							
						</div>

					</div>



				</c:forEach>
			</div>



		</div>
	</main>
</div>

<script>
	function submitBeginLoanForm() {
		document.getElementById("formBeginLoan").submit();
	}
</script>


<jsp:include page="/include/footer.jsp"></jsp:include>