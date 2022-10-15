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
			<span class="form-label fs-2 ">
				<fmt:message key="home.welcome.message"
					bundle="${messageProperties}" />
				<strong >${homeView.getClientFirstName()}</strong>
			</span>
		</div>		

		<div class="row" style="width: 700px !important;">
			<!-- Accounts -->
			<div class="col-sm-6">
				<div class="card bankdemo-card bankdemo-card_clickable"
					style="width: 300px !important; height: 150px !important; padding: 0px !important; position: relative !important;">
					<div class="card-body" style="padding: 0px !important;">
						<div
							style="width: 100%; position: absolute; text-align: center !important; top: 50%; -ms-transform: translateY(-50%); transform: translateY(-50%);">

							<span class="card-title"
								style="vertical-align: middle !important;">

								<span data-feather="book"
									style="color: #800000; width: 32px; height: 32px;" >
									</span>
								<span class="fs-4" style="vertical-align: middle !important;">
									<fmt:message key="sidebar.accounts.message"
										bundle="${messageProperties}" />
								</span>
							</span>
							<br>
							<span class="form-label fs-6 text-muted">
								<fmt:message key="balance" bundle="${messageProperties}" />
								: $ <fmt:formatNumber value="${homeView.getAccountsBalance() }"
										type="number" minFractionDigits="2"></fmt:formatNumber>
							</span>


							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</div>
						<a class="stretched-link" href="/accounts" >
						</a>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<!-- loans -->

				<div class="card bankdemo-card bankdemo-card_clickable"
					style="width: 300px !important; height: 150px !important; padding: 0px !important; position: relative !important;">
					<div class="card-body" style="padding: 0px !important;">
						<div
							style="width: 100%; position: absolute; text-align: center !important; top: 50%; -ms-transform: translateY(-50%); transform: translateY(-50%);">

							<span class="card-title" style="vertical-align: middle !important;">

								<span data-feather="dollar-sign"
									style="color: #800000; width: 32px; height: 32px;" /></span>
								<span class="fs-4"  style="vertical-align: middle !important;">
								<fmt:message key="sidebar.loans.message"
									bundle="${messageProperties}" /> </span>
							</span>
							<br>
							<span class="form-label fs-6 text-muted ">
								 <fmt:message key="balance" bundle="${messageProperties}" />								 
								: $ <fmt:formatNumber value="${homeView.getLoansBalance() }"
										type="number" minFractionDigits="2"></fmt:formatNumber>								
							</span>


							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</div>
						<a class="stretched-link" href="/loans" >
						</a>
					</div>
				</div>

			</div>
		</div>

		<div class="row" style="width: 700px !important;">
			<!-- payments -->
			<div class="col-sm-6">
				<div class="card bankdemo-card bankdemo-card_clickable"
					style="width: 300px !important; height: 150px !important; padding: 0px !important; position: relative !important;">
					<div class="card-body" style="padding: 0px !important;">
						<div
							style="width: 100%; position: absolute; text-align: center !important; top: 50%; -ms-transform: translateY(-50%); transform: translateY(-50%);">

							<span class="card-title" style="vertical-align: middle !important;">

								<span data-feather="repeat"
									style="color: #800000; width: 32px; height: 32px;" /></span>
							
								<span class="fs-4"  style="vertical-align: middle !important;"><fmt:message key="sidebar.transactions.message"
									bundle="${messageProperties}" /></span>
							</span>							
							<span class="form-label fs-6 text-muted"></span>


							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</div>
						<a class="stretched-link" href="/payments">
						</a>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<!-- mydata -->

				<div class="card bankdemo-card bankdemo-card_clickable"
					style="width: 300px !important; height: 150px !important; padding: 0px !important; position: relative !important;">
					<div class="card-body" style="padding: 0px !important;">
						<div
							style="width: 100%; position: absolute; text-align: center !important; top: 50%; -ms-transform: translateY(-50%); transform: translateY(-50%);">

							<span class="card-title">

								<span data-feather="settings"
									style="color: #800000; width: 32px; height: 32px;" /></span>

								<span class="fs-4"  style="vertical-align: middle !important;"><fmt:message key="sidebar.settings.message"
									bundle="${messageProperties}" /></span>
							</span>
							<span class="card-subtitle mb-2 text-muted"></span>


							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</div>
						<a class="stretched-link" href="/settings" >
						</a>
					</div>
				</div>

			</div>
		</div>

	</main>
	

	
</div>


<jsp:include page="/include/footer.jsp"></jsp:include>