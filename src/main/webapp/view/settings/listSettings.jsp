<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<div style="vertical-align: middle !important">			
				<span data-feather="settings"
					style="width: 30px; height: 30px; color: #800000 !important; vertical-align: middle !important">
				</span> 
				<span class="form-label fs-2"  style="vertical-align: middle !important"> <fmt:message
						key="listSettings.title.message" bundle="${messageProperties}" />
				</span>
			 </div>			
			
			
			
		</div>
		 
		
		
		<c:choose>
			<c:when test="${ activeTab.equals('myData') == true }">
				<c:set var="myDataButtonClass" scope="page" value="${'active' }"/>				
				<c:set var="myDataContentClass" scope="page" value="${'show active' }"/>
				
				<c:set var="userAccountButtonClass" scope="page" value="${'' }"/>
				<c:set var="userAccountContentClass" scope="page" value="${'' }"/>
				
				<c:set var="optionsButtonClass" scope="page" value="${'' }"/>				
				<c:set var="optionsContentClass" scope="page" value="${'' }"/>
			</c:when>
			<c:when test="${ activeTab.equals('userAccount') == true }">
				<c:set var="myDataButtonClass" scope="page" value="${'' }"/>				
				<c:set var="myDataContentClass" scope="page" value="${'' }"/>
				
				<c:set var="userAccountButtonClass" scope="page" value="${'active' }"/>
				<c:set var="userAccountContentClass" scope="page" value="${'show active' }"/>
				
				<c:set var="optionsButtonClass" scope="page" value="${'' }"/>				
				<c:set var="optionsContentClass" scope="page" value="${'' }"/>
			</c:when>
			<c:when test="${ activeTab.equals('options') == true }">
				<c:set var="myDataButtonClass" scope="page" value="${'' }"/>				
				<c:set var="myDataContentClass" scope="page" value="${'' }"/>
				
				<c:set var="userAccountButtonClass" scope="page" value="${'' }"/>
				<c:set var="userAccountContentClass" scope="page" value="${'' }"/>
				
				<c:set var="optionsButtonClass" scope="page" value="${'active' }"/>				
				<c:set var="optionsContentClass" scope="page" value="${'show active' }"/>	
			</c:when>			
			<c:otherwise>
				<c:set var="myDataButtonClass" scope="page" value="${'active' }"/>				
				<c:set var="myDataContentClass" scope="page" value="${'show active' }"/>
				
				<c:set var="userAccountButtonClass" scope="page" value="${'' }"/>
				<c:set var="userAccountContentClass" scope="page" value="${'' }"/>
				
				<c:set var="optionsButtonClass" scope="page" value="${'' }"/>				
				<c:set var="optionsContentClass" scope="page" value="${'' }"/>			
			</c:otherwise>
		
		</c:choose>
		
		
		

		<ul class="nav nav-tabs" id="myTab" role="tablist" style="width: 600px;">
			<li class="nav-item" role="presentation">
				<button class="nav-link ${myDataButtonClass }" id="mydata-tab" data-bs-toggle="tab"
				data-bs-target="#mydata" type="button" role="tab"
					aria-controls="mydata" aria-selected="true"
					style="color: #800000 !important; font-size: 16px !important;">
															<span data-feather="user"
						style="width: 16px; height: 16px; color: #000000 !important; vertical-align: middle !important"></span>
					<span style="vertical-align: middle !important"> <fmt:message
							key="listSettings.profile.message" bundle="${messageProperties}" />
					</span>
				</button>
			


			</li>
			<li class="nav-item" role="presentation">			
				<button class="nav-link ${userAccountButtonClass }" id="useraccount-tab" data-bs-toggle="tab"
					data-bs-target="#useraccount" type="button" role="tab"
					aria-controls="useraccount" aria-selected="false"
					style="color: #800000 !important; font-size: 16px !important;">
										<span data-feather="lock"
						style="width: 16px; height: 16px; color: #000000 !important; vertical-align: middle !important"></span>
					<span style="vertical-align: middle !important"> <fmt:message
							key="listSettings.userAccount.message"
							bundle="${messageProperties}" />
					</span>

				</button>
			

			</li>

			<li class="nav-item" role="presentation">
				<button class="nav-link ${optionsButtonClass }" id="options-tab" data-bs-toggle="tab"
					data-bs-target="#options" type="button" role="tab"
					aria-controls="options" aria-selected="false"
					style="color: #800000 !important; font-size: 16px !important;">

					<span data-feather="sliders"
						style="width: 16px; height: 16px; color: #000000 !important; vertical-align: middle !important"></span>

					<span style="vertical-align: middle !important"> <fmt:message
							key="listSettings.options.message" bundle="${messageProperties}" />
					</span>


				</button>
			</li>
		</ul>
		<div class="tab-content" id="myTabContent">
		
		
		
			<div class="tab-pane fade ${myDataContentClass }" id="mydata" role="tabpanel"
			aria-labelledby="mydata-tab">		
				
				<br>

				<div class="ps-lg-4 bankdemo-main-accordion">
					<form:form action="/settings/myData" method="post"
						modelAttribute="myDataForm">



						<!--<h5 style="text-align: left">
				
					<fmt:message key="forms.registerBegin.personalInformation.message"
						bundle="${messageProperties}" />
				</h5>  -->
						<br>

						<div class="container">
							<div class="row">
								<div class="col">
									<form:input path="firstName" type="text" class="form-control"
										id="floatingInput" />
									<form:label path="firstName" for="floatingInput"
										class="form-label fs-6"
										style="display:block; width:x; height:y; text-align:left;color:grey!important;">
										<fmt:message key="registerForm.firstName"
											bundle="${messageProperties}" />

									</form:label>
									<form:errors path="firstName"
										cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />


								</div>
								<div class="col">
									<form:input path="lastName" type="text" class="form-control"
										id="floatingInput" />
									<form:label path="lastName" for="floatingInput"
										class="form-label  fs-6"
										style="display:block; width:x; height:y; text-align:left;color:grey!important;">

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
										id="floatingInput" />

									<form:label path="documentId" for="floatingInput"
										class="form-label fs-6"
										style="display:block; width:x; height:y; text-align:left;color:grey!important;">
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

						<button class="btn btn-primary "
							type="submit" >
							<fmt:message key="forms.confirm.message"
								bundle="${messageProperties}" />
						</button>


					</form:form>




				</div>
















			</div>
			
			<div class="tab-pane fade ${userAccountContentClass }" id="useraccount" role="tabpanel"
				aria-labelledby="useraccount-tab">		
			


				<div class="ps-lg-4 bankdemo-main-accordion">
					<form:form action="/settings/userAccount" method="post"
						modelAttribute="myUserAccountForm">

						<!-- <h5 style="text-align: left">
							<fmt:message key="forms.registerBegin.loginInformation.message"
								bundle="${messageProperties}" />
						</h5> -->
						<br>
						<br>
						<div class="container">
							<div class="row">

								<div class="col">
									<form:input path="username" type="text" class="form-control"
										id="floatingInput" />

									<form:label path="username" for="floatingInput"
										class="form-label fs-6"
										style="display:block; width:x; height:y; text-align:left;color:grey!important;">
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
									<form:input path="currentPassword" type="password"
										class="form-control" id="floatingInput" />

									<form:label path="currentPassword" for="floatingInput"
										class="form-label fs-6"
										style="display:block; width:x; height:y; text-align:left;color:grey!important;">
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
									<form:input path="newPassword" type="password"
										class="form-control" id="floatingnewPassword" />
									<form:label path="newPassword" for="floatingnewPassword"
										class="form-label fs-6"
										style="display:block; width:x; height:y; text-align:left;color:grey!important;">

										<fmt:message key="myDataForm.passwordNew"
											bundle="${messageProperties}" />
									</form:label>
									<form:errors path="newPassword"
										cssStyle="color:Red; display:block; width:x; height:y; text-align:left;" />
								</div>
								<div class="col">
									<form:input path="newPasswordRepeat" type="password"
										class="form-control" id="floatingNewPasswordRepeat" />
									<form:label path="newPasswordRepeat"
										for="floatingnewPasswordRepeat" class="form-label fs-6"
										style="display:block; width:x; height:y; text-align:left;color:grey!important;">

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
					 

						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />

						<button class="btn btn-primary"
							type="submit" >
							<fmt:message key="forms.confirm.message"
								bundle="${messageProperties}" />
						</button>



					</form:form>



				</div>



			</div>
			<div class="tab-pane fade ${optionsContentClass }" id="options" role="tabpanel"
				aria-labelledby="options-tab">



				<div class="ps-lg-4 bankdemo-main-accordion">

					<form:form action="/settings/options" method="post"
						modelAttribute="settingsForm">

						<br>
						<br>
						<div class="container">
							<div class="row">

								<div class="col">

									<h6>
										<form:select path="language" style="width: 250px"
											class="form-select" id="language">
											<form:options items="${languages }"
												 />
										</form:select>
									</h6>
									<form:label path="language" for="language"
										class="form-label fs-6"
										style="display:block; width:x; height:y; text-align:left;color:grey!important;">

										<fmt:message key="listSettings.language.message"
											bundle="${messageProperties}" />
									</form:label>

									<h6>
										<form:errors path="language" cssStyle="color:Red" />
									</h6>
									<br>

								</div>
								<div class="col"></div>

							</div>

						</div>

						<br>
											

						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
 

						<button class="btn btn-primary "
							type="submit" >
							<fmt:message key="forms.confirm.message"
								bundle="${messageProperties}" />
						</button>



					</form:form>



				</div>






























			</div>
		</div>




	</main>
</div>

<c:if test="${showModal == true }">

	<!-- Modal -->
	<div class="modal fade" id="resultModal" tabindex="-1" aria-labelledby="resultModalLabel" aria-hidden="true" style="display: block;">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="resultModalLabel">
		        <fmt:message key="listSettings.modal.title.message" bundle="${messageProperties}" />
	        </h5>        
	      </div>
	      <div class="modal-body text-center" style="font-size: 1rem!important;">
	      		<c:if test="${activeTab.equals('myData')}">
					<fmt:message key="listSettings.modal.mydata.text.message" bundle="${messageProperties}" />
				</c:if>
				<c:if test="${activeTab.equals('userAccount')}">
					<fmt:message key="listSettings.modal.userAccount.text.message" bundle="${messageProperties}" />
				</c:if>
				<c:if test="${activeTab.equals('options')}">
					<fmt:message key="listSettings.modal.options.text.message" bundle="${messageProperties}" />
				</c:if>			    
	      </div>
	      <div class="modal-footer" style="justify-content: center">     
	      		<button class="btn btn-primary"	type="button" style="font-size: 1rem!important;" data-bs-dismiss="modal">				
	      				<fmt:message key="forms.accept.message" bundle="${messageProperties}" />       
	        	</button>        
	      </div>
	    </div>
	  </div>
	</div>
</c:if>



<script src="https://code.jquery.com/jquery.js"></script>

<script type="text/javascript">
	$(window).load(function() {
		$('#resultModal').modal('show');
	});
</script>






<jsp:include page="/include/footer.jsp"></jsp:include>