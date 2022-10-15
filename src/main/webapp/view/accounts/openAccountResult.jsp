<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<fmt:setBundle basename="messages" var="messageProperties"/>
<jsp:include page="/include/header.jsp"></jsp:include>

<div>
	<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">

		<div
			class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
		
			<div style="vertical-align: middle !important">
					<span data-feather="book"
						style="width: 30px; height: 30px; color: #800000 !important; vertical-align: middle !important">
					</span> 
					<span class="form-label fs-2 " style="vertical-align: middle !important"> <fmt:message
							key="openAccountResult.openAccountResult.message" bundle="${messageProperties}" />
					</span>
			</div>		
			
		</div>
		
		
		
		
		<div class="ps-lg-4 bankdemo-content text-center">
			<span data-feather="check-circle"
				style="color: #00bb00; width: 100px; height: 100px" /></span>
			<br>
			<span class="form-label fs-6 "><fmt:message key = "openAccountResult.succesFully.message" bundle = "${messageProperties}"/></span>
			<br>
			<span class="form-label fs-6 ">
				<fmt:message key = "openAccountResult.newAccountNumber.message" bundle = "${messageProperties}"/></span>
			<span class="form-label fs-6 span-highlight">
				<strong>${ account.getNumber() }</strong>
			</span>
			<br>
			<span class="form-label fs-6 ">
				<fmt:message key = "openAccountResult.youHaveReceived.message" bundle = "${messageProperties}"/>
				<strong>
					$ <fmt:formatNumber value="${welcomeAmount }"
										type="number" minFractionDigits="2">
						</fmt:formatNumber>
			  	</strong>
			 <fmt:message key = "openAccountResult.asGift.message" bundle = "${messageProperties}"/>
			</span>
			
			<br>
			<br> 
			
			<a href="/accounts"
				class="btn btn-primary"><fmt:message key = "forms.accept.message" bundle = "${messageProperties}"/></a>
		</div>
	</main>
</div>

<jsp:include page="/include/footer.jsp"></jsp:include>