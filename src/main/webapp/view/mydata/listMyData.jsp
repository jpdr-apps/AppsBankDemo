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
				<span data-feather="user"
					style="width: 30px; height: 30px; color: #800000 !important; vertical-align: middle !important">
				</span> <span style="vertical-align: middle !important"> <fmt:message
						key="listMyData.title.message" bundle="${messageProperties}" />
				</span>
			</h1>
		</div>
		<br>

		<ul class="nav nav-tabs">
			<li class="nav-item">
				<a class="nav-link active"
						aria-current="page" href="#">
						<fmt:message key="forms.registerBegin.personalInformation.message"	bundle="${messageProperties}" />
				</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			<li class="nav-item"><a class="nav-link disabled" href="#"
				tabindex="-1" aria-disabled="true">Disabled</a></li>
		</ul>



		<div class="ps-lg-4 bankdemo-main-accordion">
			<form:form action="/myData" method="post" modelAttribute="myDataForm">

				<h5 style="text-align: left">
					<fmt:message key="forms.registerBegin.personalInformation.message"
						bundle="${messageProperties}" />
				</h5>
				<br>

				<div class="container">
					<div class="row">
						<div class="col">
							<form:input path="firstName" type="text" class="form-control"
								id="floatingInputfirstName" />
							<form:label path="firstName" for="floatingInputfirstName"
								class="form-label"
								style="display:block; width:x; height:y; text-align:left;">
								<fmt:message key="registerForm.firstName"
									bundle="${messageProperties}" />

							</form:label>
							<form:errors path="firstName"
								cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />


						</div>
						<div class="col">
							<form:input path="lastName" type="text" class="form-control"
								id="floatingInputlastName" />
							<form:label path="lastName" for="floatingInputlastName"
								class="form-label"
								style="display:block; width:x; height:y; text-align:left;">

								<fmt:message key="registerForm.lastName"
									bundle="${messageProperties}" />


							</form:label>
							<form:errors path="lastName"
								cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
							<br>
						</div>
					</div>

					<div class="row">

						<div class="col">
							<form:input path="documentId" type="text" class="form-control"
								id="floatingInputdocumentId" />

							<form:label path="documentId" for="floatingInputdocumentId"
								class="form-label"
								style="display:block; width:x; height:y; text-align:left;">
								<fmt:message key="registerForm.documentId"
									bundle="${messageProperties}" />
							</form:label>
							<form:errors path="documentId"
								cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
							<br>
						</div>
						<div class="col"></div>

					</div>
					<br>
				</div>


				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

				<a href="/home" class="btn btn-primary bankdemo-buton-primary"
					style="width: 150px"> <fmt:message key="forms.cancel.message"
						bundle="${messageProperties}" />
				</a>

				<button class="btn btn-primary bankdemo-buton-primary" type="submit"
					style="width: 150px !important">
					<fmt:message key="forms.confirm.message"
						bundle="${messageProperties}" />
				</button>


			</form:form>



		</div>
	</main>
</div>

<!--<c:if test="${showModal == true}"> -->

	<!--  Form Submission Modal -->

	<!-- Modal -->
	<div class="modal fade" id="resultModal" tabindex="-1"
		aria-labelledby="resultModalLabel" aria-hidden="true"
		style="display: block;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="resultModalLabel">
						<fmt:message key="listMyData.modal.title.message"
							bundle="${messageProperties}" />
					</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body" style="font-size: 1rem !important;">
					<fmt:message key="listMyData.modal.text.message"
						bundle="${messageProperties}" />
				</div>
				<div class="modal-footer">

					<button class="w-100 btn btn-lg btn-primary btn-primary-bankdemo"
						type="submit"
						style="width: 100px !important; font-size: 1rem !important;"
						data-bs-dismiss="modal">
						<fmt:message key="forms.accept.message"
							bundle="${messageProperties}" />
					</button>
				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery.js"></script>


	<script type="text/javascript">
		$(window).load(function() {
			$('#resultModal').modal('show');
		});
	</script>
<!--</c:if>-->

<jsp:include page="/include/footer.jsp"></jsp:include>