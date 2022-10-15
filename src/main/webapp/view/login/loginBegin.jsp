<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<fmt:setBundle basename="messages" var="messageProperties" />
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title><fmt:message key="loginBegin.pageTitle.message"
		bundle="${messageProperties}" /></title>

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
/*
.imagen-fondo {
  background-image: url("../../include/img/burst-kUqqaRjJuw0-unsplash.jpg");
  background-color: #cccccc;
  height: 100%;
  width: 100%;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  
}
*/
</style>


<!-- Custom styles for this template -->
<link href="../include/css/signin.css" rel="stylesheet">
</head>


<body class="text-center"
	style="background-color: white; padding-top: 0px !important; padding-bottom: 0px !important;">




	<c:url value="/login" var="loginProcessingUrl" />



	<!-- 
<span style="position:absolute;top:0px;right:0px;margin-right:10px;margin-top:10px;">
<fmt:message key = "loginBegin.language.message" bundle = "${messageProperties}"/>:
<a href="/login?lang=esp" ><img src="../include/img/lang_es.jpg" alt="Español"></a>
<a href="/login?lang=eng" ><img src="../include/img/lang_en.jpg" alt="English" ></a>
 </span>
 -->
	<main class="form-signin w-100 m-auto">

		<br> <br> <br>
		<form action="${loginProcessingUrl}" method="post">
			<img class="mb-4" src="../include/img/bankdemologo.svg"
				alt="BankDemo" width="200" height="100">
			<h1 class="h3 mb-3 fw-normal">
				<fmt:message key="loginBegin.loginToServices.message"
					bundle="${messageProperties}" />
			</h1>

			<strong style="color: red"> <c:if
					test="${param.error != null}">
					<!-- <div>
							<spring:message code="loginBegin.failedToLogin.message"/>
							<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
		                  <spring:message code="loginBegin.reason.message"/> 
		                  <c:out
									value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
							</c:if>
						</div>
						 -->
					<fmt:message key="loginBegin.reason.message"
						bundle="${messageProperties}" />
				</c:if>


			</strong>



			<!--  <label for="username"><spring:message code="username"/></label>-->

			<input type="text" class="form-control" id="username"
				style="height: 50px; margin-bottom: 5px"
				placeholder="<fmt:message key = "username" bundle = "${messageProperties}"/>"
				name="username" required
				oninvalid="this.setCustomValidity('<fmt:message key = "forms.notBlankField.message" bundle = "${messageProperties}"/>')"
				oninput="this.setCustomValidity('')">


			<!-- <label for="password">Password</label>  -->
			<input type="password" class="form-control" id="password"
				style="height: 50px;"
				placeholder="<fmt:message key = "password" bundle = "${messageProperties}"/>"
				name="password"> <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" />

			<button class="w-100 btn btn-lg btn-primary"
				style="width: 150px !important" type="submit">
				<fmt:message key="forms.login.message" bundle="${messageProperties}" />
			</button>
		</form>
		<br> <br> <br>
		<h5>
			<fmt:message key="loginBegin.notAClient.message"
				bundle="${messageProperties}" />
		</h5>
		<a href="/register"
			class="w-100 btn btn-lg btn-primary btn-primary-bankdemo"
			style="width: 150px !important"><fmt:message
				key="forms.register.message" bundle="${messageProperties}" /></a> <br>
		<br> <br> <span class="fs-6"> <fmt:message
				key="loginBegin.language.message" bundle="${messageProperties}" />:
			<a href="/login?lang=esp"><img src="../include/img/lang_es.jpg"
				alt="Español"></a> <a href="/login?lang=eng"><img
				src="../include/img/lang_en.jpg" alt="English"></a>
		</span>

	</main>


	<script src="../include/js/bootstrap.bundle.min.js"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js"
		integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"
		integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha"
		crossorigin="anonymous"></script>
	<script src="../include/js/dashboard.js"></script>
</body>
</html>