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
			class="d-flex justify-content-start flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom ">
			<div style="vertical-align: middle !important">
				<span data-feather="book"
					style="width: 30px; height: 30px; color: #800000 !important; vertical-align: middle !important">
				</span> 
				<span class="form-label fs-2 " style="vertical-align: middle !important"> <fmt:message
						key="accounts" bundle="${messageProperties}" />
				</span>
			</div>
		</div>
		
		<br>


		<c:forEach items="${ accounts.getEntities() }" var="account">

			<div class="card bankdemo-card card-no-shadow">
				<div class="card-body">


					<div class="container">

						<div class="row justify-content-evenly">

							<div class="col-4" style="width:50%">

								<div>
										<span class="card-title"
												style="color: #800000 !important; font-size: 20px !important;">
										<fmt:message key="account" bundle="${messageProperties}" />
										 N°: </span>
										 <br>
										 <span class="form-label fs-5"> ${ account.getNumber() }</span>
								</div>
							</div>
							<div class="col-4" style="width:50%">
								<div style="text-align: right!important;">	
										<span class="card-title"
												style="color: #800000 !important; font-size: 20px !important; text-align: right!important;">			
											<fmt:message key="balance" bundle="${messageProperties}" />
										</span>
										<br>											
										<span class="form-label fs-6" style="text-align: right!important;"> $ 
												<fmt:formatNumber value="${ account.getBalance() }"
													type="number" minFractionDigits="2"></fmt:formatNumber>
													 
										</span>
								</div>
							</div>	 

								<div class="btn-group" style="padding-top: 10px;">
											<a class="btn btn-secondary" href="/accounts/${ account.getNumber() }/listTransactions"
												> <fmt:message
													key="listAccounts.transactionHistory.message"
													bundle="${messageProperties}" />
											</a>
				
				
											<c:if test="${account.getBalance()>0}">
												<a  class="btn btn-secondary"  href="/accounts/${ account.getNumber() }/paymentBegin"
													 > <fmt:message
														key="listAccounts.newPayment.message"
														bundle="${messageProperties}" />
				
												</a>
											</c:if>
											<c:if test="${account.getBalance()<=0}">
												<a href="/accounts/${ account.getNumber() }/paymentBegin"
													class="btn btn-secondary disabled"
													aria-disabled="true"> <fmt:message
														key="listAccounts.newPayment.message"
														bundle="${messageProperties}" />
												</a>
											</c:if>
				
											<a href="/accounts/${ account.getNumber() }/closeAccountConfirm"
												class="btn btn-secondary"> <fmt:message
													key="listAccounts.closeAccount.message"
													bundle="${messageProperties}" />
											</a>
								</div>








							</div>

						</div>
					</div>


				</div>
		 

		</c:forEach>


		
		 
		<br>
		<br>	
		 
 		<div class="ps-lg-4 bankdemo-main-accordion">
			<div >
					<form id="formOpenAccount" action="/accounts/openAccountConfirm" method="post">
						<button class="btn btn-primary" type="submit" >
						<span>
							<fmt:message key="listAccounts.openNewAccount.message"
											bundle="${messageProperties}" />
						</span> 
						</button>
						<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />			
						<br>			
					</form>
				</div>
 		</div>





 
	</main>
</div>

<script>
	function submitOpenForm() {
		document.getElementById("formOpenAccount").submit();
	}
</script>


<jsp:include page="/include/footer.jsp"></jsp:include>