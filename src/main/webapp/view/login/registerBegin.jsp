<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<fmt:setBundle basename="messages" var="messageProperties"/>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><fmt:message key = "forms.registerBegin.pageTitle.message" bundle = "${messageProperties}"/></title>

<link rel="icon" type="image/svg"
	href="../include/img/bankdemofavicon.svg" />

<link href="../include/css/bootstrap.min.css" rel="stylesheet">
<link href="../include/css/bankdemo.css" rel="stylesheet">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}
</style>


<!-- Custom styles for this template -->
<link href="../include/css/signin.css" rel="stylesheet">
</head>

<body>

	<main class="form-signin w-200 m-auto text-center"
		style="max-width: 600px; width: 600px">

		<img class="mb-4" src="../include/img/bankdemologo.svg" alt="BankDemo"
			width="200" height="100">

		<form:form action="/register" method="post"
			modelAttribute="registerForm">

			<h1 class="h4 mb-3 fw-normal"><fmt:message key = "forms.registerBegin.clientRegistrationForm.message" bundle = "${messageProperties}"/></h1>
			<br>

			<h5 style="text-align: left"><fmt:message key = "forms.registerBegin.personalInformation.message" bundle = "${messageProperties}"/></h5>
			<br>

			<div class="container">
				<div class="row">
					<div class="col">
						<form:input path="firstName" type="text" class="form-control"
							id="floatingInputFirstName" />
						<form:label path="firstName" for="floatingInputFirstName"
							class="form-label"
							style="display:block; width:x; height:y; text-align:left;">
							<fmt:message key = "registerForm.firstName" bundle = "${messageProperties}"/>
							
						</form:label>
						<form:errors path="firstName"
							cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
					 						

					</div>
					<div class="col">
						<form:input path="lastName" type="text" class="form-control"
							id="floatingInputLastName" />
						<form:label path="lastName" for="floatingInputLastName" class="form-label"
							style="display:block; width:x; height:y; text-align:left;">

						<fmt:message key = "registerForm.lastName" bundle = "${messageProperties}"/>
						
						
						</form:label>
						<form:errors path="lastName"
							cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
	<br>
					</div>
				</div>

				<div class="row">

					<div class="col">
						<form:input path="documentId" type="text" class="form-control"
							id="floatingInputDocumentId" />

						<form:label path="documentId" for="floatingInputDocumentId"
							class="form-label"
							style="display:block; width:x; height:y; text-align:left;">				
							<fmt:message key = "registerForm.documentId" bundle = "${messageProperties}"/>	
							</form:label>
						<form:errors path="documentId"
							cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
								<br>
					</div>
					<div class="col"></div>

				</div>
				<br>
			</div>

			<h5 style="text-align: left">
			<fmt:message key = "forms.registerBegin.loginInformation.message" bundle = "${messageProperties}"/>
			</h5>
			<br>
			<div class="container">
				<div class="row">

					<div class="col">
						<form:input path="username" type="text" class="form-control"
							id="floatingInputUsername" />

						<form:label path="username" for="floatingInputUsername" class="form-label"
							style="display:block; width:x; height:y; text-align:left;">
							<fmt:message key = "registerForm.username" bundle = "${messageProperties}"/>
							
							</form:label>
						<form:errors path="username"
							cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
								<br>

					</div>
					<div class="col"></div>

				</div>

				<div class="row">
					<div class="col">
						<form:input path="password" type="password" class="form-control"
							id="floatingPassword" />
						<form:label path="password" for="floatingPassword"
							class="form-label"
							style="display:block; width:x; height:y; text-align:left;">
							
							<fmt:message key = "registerForm.password" bundle = "${messageProperties}"/>
							</form:label>
						<form:errors path="password"
							cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
					</div>
					<div class="col">
						<form:input path="passwordRepeat" type="password"
							class="form-control" id="floatingPassword" />
						<form:label path="passwordRepeat" for="floatingPassword"
							class="form-label"
							style="display:block; width:x; height:y; text-align:left;">
														
							<fmt:message key = "registerForm.passwordRepeat" bundle = "${messageProperties}"/>
							</form:label>
						<form:errors path="passwordRepeat"
							cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
						<form:errors cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
					</div>
					
						<br>
				</div>

			</div>

			<br>
			<br>
			<br>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

			<a href="/login" class="btn btn-lg btn-primary btn-primary-bankdemo" style="width: 150px">
			
			<fmt:message key = "forms.cancel.message" bundle = "${messageProperties}"/>
			</a>

			<button class="w-100 btn btn-lg btn-primary btn-primary-bankdemo"
				type="submit" style="width: 150px !important">				
				<fmt:message key = "forms.confirm.message" bundle = "${messageProperties}"/>
				</button>


		</form:form>


	</main>

	<script src="../include/js/bootstrap.bundle.min.js"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js"
		integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE"
		crossorigin="anonymous"></script>
	  <script src="../include/js/common.js"></script> 	
</body>
</html>