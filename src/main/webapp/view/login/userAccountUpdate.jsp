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
				<span data-feather="lock"
					style="width: 30px; height: 30px; color: #800000 !important; vertical-align: middle !important">
				</span> <span style="vertical-align: middle !important"> <fmt:message
						key="userAccountUpdate.title.message" bundle="${messageProperties}" />
				</span>
			</h1>
		</div>
		<br>

	

		<div class="ps-lg-4 bankdemo-main-accordion">
			<form:form action="/myUserAccount" method="post"
				modelAttribute="myUserAccountForm">

				<h5 style="text-align: left">
					<fmt:message key="forms.registerBegin.loginInformation.message"
						bundle="${messageProperties}" />
				</h5>
				<br>
				<div class="container">
					<div class="row">

						<div class="col">
							<form:input path="username" type="text" class="form-control"
								id="floatingInputusername" />

							<form:label path="username" for="floatingInputusername"
								class="form-label"
								style="display:block; width:x; height:y; text-align:left;">
								<fmt:message key="registerForm.username"
									bundle="${messageProperties}" />

							</form:label>
							<form:errors path="username"
								cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
							<br>

						</div>
						<div class="col"></div>

					</div>
					
					
					<div class="row">

						<div class="col">
							<form:input path="currentPassword" type="password" class="form-control"
								id="floatingInputcurrentPassword" />

							<form:label path="currentPassword" for="floatingInputcurrentPassword"
								class="form-label"
								style="display:block; width:x; height:y; text-align:left;">
								<fmt:message key="myDataForm.passwordCurrent"
									bundle="${messageProperties}" />

							</form:label>
							<form:errors path="currentPassword"
								cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
							<br>

						</div>
						<div class="col"></div>

					</div>
					

					<div class="row">
						<div class="col">
							<form:input path="newPassword" type="password" class="form-control"
								id="floatingnewPassword" />
							<form:label path="newPassword" for="floatingnewPassword"
								class="form-label"
								style="display:block; width:x; height:y; text-align:left;">

								<fmt:message key="myDataForm.passwordNew"
									bundle="${messageProperties}" />
							</form:label>
							<form:errors path="newPassword"
								cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
						</div>
						<div class="col">
							<form:input path="newPasswordRepeat" type="password"
								class="form-control" id="floatingNewPasswordRepeat" />
							<form:label path="newPasswordRepeat" for="floatingnewPasswordRepeat"
								class="form-label"
								style="display:block; width:x; height:y; text-align:left;">

								<fmt:message key="myDataForm.passwordNewRepeat"
									bundle="${messageProperties}" />
							</form:label>
							<form:errors path="newPasswordRepeat"
								cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
																<form:errors
								cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
							<br>
						</div>

						<br>
					</div>
										

				</div>

				<br>
				<br>
				<br>

				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
					 
				<a href="/home" class="btn btn-primary bankdemo-buton-primary"
					style="width: 150px"> <fmt:message key="forms.cancel.message"
						bundle="${messageProperties}" />
				</a>

				<button class="btn btn-primary bankdemo-buton-primary"
					type="submit" style="width: 150px !important">
					<fmt:message key="forms.confirm.message"
						bundle="${messageProperties}" />
				</button>



			</form:form>



		</div>
	</main>
</div>

<c:if test="${showModal == true}">

<!--  Form Submission Modal -->

<!-- Modal -->
<div class="modal fade" id="resultModal" tabindex="-1" aria-labelledby="resultModalLabel" aria-hidden="true" style="display: block;">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="resultModalLabel">
	        <fmt:message key="userAccountUpdate.modal.title.message" bundle="${messageProperties}" />
        </h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body" style="font-size: 1rem!important;">
			<fmt:message key="userAccountUpdate.modal.text.message" bundle="${messageProperties}" />    
      </div>
      <div class="modal-footer">
      
      <button class="w-100 btn btn-lg btn-primary btn-primary-bankdemo"
					type="submit" style="width: 100px !important;font-size: 1rem!important;" data-bs-dismiss="modal">				
      			<fmt:message key="forms.accept.message" bundle="${messageProperties}" />       
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
</c:if>

<jsp:include page="/include/footer.jsp"></jsp:include>