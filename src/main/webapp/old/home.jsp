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
			<h1 class="h2">
				<fmt:message key = "home.welcome.message" bundle = "${messageProperties}"/>
				<strong>${clientSessionInfo.getFirstName()}</strong>
				
			</h1>
		</div>
		<div class="ps-lg-4 bankdemo-main-accordion">
			<div class="accordion" id="accordionPanelsStayOpenExample">
				<div class="accordion-item" style="border-radius: 10px;border-color: white!important;">
					<h2 class="accordion-header" id="panelsStayOpen-headingOne" >
						<button class="accordion-button bankdemo-accordion-item"
							type="button" data-bs-toggle="collapse"    style="color: white!important; background-color: red!important;border-radius: 10px;"
							data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="true"
							aria-controls="panelsStayOpen-collapseOne"  >

							<h3 >
								<fmt:message key = "accounts" bundle = "${messageProperties}"/>
							</h3>
						</button>
					</h2>
					<div id="panelsStayOpen-collapseOne"
						class="accordion-collapse collapse show"
						aria-labelledby="panelsStayOpen-headingOne">
						<div class="accordion-body">

							<c:forEach items="${ accounts.getEntities() }" var="account">

								<div class="card bankdemo-card"> <!--  style="width:300px!important;"   -->
									<div class="card-body">
										<div class="d-flex w-100 ">
											<h5 class="card-title" style="width:40%;color:#800000;">
												<!--<fmt:message key = "account" bundle = "${messageProperties}"/>-->
												 N°: ${ account.getNumber() }											
											</h5>		
											<h5 class="card-title">
											Saldo:	 $ 
													<fmt:formatNumber value="${ account.getBalance() }"
														type="number" minFractionDigits="2"></fmt:formatNumber>
											</h5>									
										</div>
						 
									</div>
								</div>

							</c:forEach>









 
						</div>
					</div>
				</div>
				<div class="accordion-item">
					<h2 class="accordion-header" id="panelsStayOpen-headingTwo">
						<button class="accordion-button bankdemo-accordion-item"
							type="button" data-bs-toggle="collapse"
							data-bs-target="#panelsStayOpen-collapseTwo"
							aria-expanded="false" aria-controls="panelsStayOpen-collapseTwo">
							<h3>
								<fmt:message key = "loans" bundle = "${messageProperties}"/>
							</h3>
						</button>
					</h2>
					<div id="panelsStayOpen-collapseTwo"
						class="accordion-collapse collapse"
						aria-labelledby="panelsStayOpen-headingTwo">
						<div class="accordion-body">
							<strong>This is the second item's accordion body.</strong> It is
							hidden by default, until the collapse plugin adds the appropriate
							classes that we use to style each element. These classes control
							the overall appearance, as well as the showing and hiding via CSS
							transitions. You can modify any of this with custom CSS or
							overriding our default variables. It's also worth noting that
							just about any HTML can go within the
							<code>.accordion-body</code>
							, though the transition does limit overflow.
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
</div>


<jsp:include page="/include/footer.jsp"></jsp:include>