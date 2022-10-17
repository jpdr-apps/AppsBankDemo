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
	<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4" >		
	
	<div
			class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
			<h1 class="h2">
			<fmt:message key = "errorInternal.pageText.message" bundle = "${messageProperties}"/>			
			</h1>
		</div>
		
		<div class="ps-lg-4 bankdemo-content text-center">
		
					<span data-feather="x-circle"
				style="color: #bb0000; width: 100px; height: 100px" /></span>
			<br>
				<h6>
					<fmt:message key = "error.common.message" bundle = "${messageProperties}"/>
				</h6>
			<br>
			<a href="/home" class="btn btn-lg btn-primary" >
			
			<fmt:message key = "forms.accept.message" bundle = "${messageProperties}"/>			
			</a>
			</div>
					
	</main>
</div>
<jsp:include page="/include/footer.jsp"></jsp:include>