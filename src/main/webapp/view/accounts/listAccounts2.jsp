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
			class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom " >
			<h1 class="h2" style="vertical-align: middle !important;">
				<span data-feather="book"
					style="width: 30px; height: 30px; color: #800000 !important; vertical-align: middle !important">
				</span> <span style="vertical-align: middle !important"> <fmt:message
						key="accounts" bundle="${messageProperties}" />
				</span>
			</h1>
		</div>
		<div class="ps-lg-4 bankdemo-main-accordion">


			<form id="formOpenAccount" action="/accounts/openAccountConfirm"
				method="post">
				
				<div class="card bankdemo-card bankdemo-card_clickable" style="height: 100px!important;padding: 0px!important; position: relative!important;">
				
					<div class="card-body">
						<div style="width: 100%;  position: absolute; text-align: center!important;  top: 50%; -ms-transform: translateY(-50%); transform: translateY(-50%);" >
							
							<h4 class="card-title" >
								<fmt:message key="listAccounts.openNewAccount.message"
									bundle="${messageProperties}" />
								<span data-feather="plus-circle" style="color: #ff0000; width: 32px; height: 32px;" /></span>
							</h4> 
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> 
								 
					
						</div>
									<a class="stretched-link" href="#" onclick='submitOpenForm()'>	
										</a>
					</div>
					
				</div>
								
			</form>



			<c:forEach items="${ accounts.getEntities() }" var="account">

				<div class="card bankdemo-card card-no-shadow" >
					<div class="card-body">

						<h5 class="card-title" style="color: #800000 !important; font-size: 20px !important;">
							<fmt:message key="account" bundle="${messageProperties}" />
							N°: ${ account.getNumber() }
						</h5>
						<!-- <h6 class="card-subtitle mb-2 text-muted">
							<fmt:message key="listAccounts.savingsAccount.message"
								bundle="${messageProperties}" />
						</h6> -->

						<h5 class="card-text">
							$
							<fmt:formatNumber value="${ account.getBalance() }" type="number"
								minFractionDigits="2"></fmt:formatNumber>
						</h5>
						<div class="d-flex justify-content-around">
							<a href="/accounts/${ account.getNumber() }/listTransactions"
								class="btn btn-primary bankdemo-buton-primary"> <fmt:message
									key="listAccounts.transactionHistory.message"
									bundle="${messageProperties}" />
							</a>


							<c:if test="${account.getBalance()>0}">
								<a href="/accounts/${ account.getNumber() }/paymentBegin"
									class="btn btn-primary bankdemo-buton-primary"> <fmt:message
										key="listAccounts.newPayment.message"
										bundle="${messageProperties}" />

								</a>
							</c:if>
							<c:if test="${account.getBalance()<=0}">
								<a href="/accounts/${ account.getNumber() }/paymentBegin"
									class="btn btn-primary bankdemo-buton-primary disabled"
									aria-disabled="true"> <fmt:message
										key="listAccounts.newPayment.message"
										bundle="${messageProperties}" />
								</a>
							</c:if>

							<a href="/accounts/${ account.getNumber() }/closeAccountConfirm"
								class="btn btn-primary bankdemo-buton-primary"> <fmt:message
									key="listAccounts.closeAccount.message"
									bundle="${messageProperties}" />
							</a>
						</div>
					</div>
				</div>

			</c:forEach>





		</div>
	</main>
</div>

<script>
	function submitOpenForm() {
		document.getElementById("formOpenAccount").submit();
	}
</script>


<jsp:include page="/include/footer.jsp"></jsp:include>