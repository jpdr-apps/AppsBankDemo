<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/include/header.jsp"></jsp:include>

<div>
	<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">

		<div class="ps-lg-4 ">
			${ pageTitle } ${ pageMessage } <br>
			<c:if test="${pageSubmitMethod=='form'}">
				<form action="${pageAction }" method="post">
					<input class="btn btn-primary bankdemo-buton-primary" type="submit"
						value="${pageButtonText }">
				</form>
			</c:if>
			<c:if test="${pageSubmitMethod=='anchor'}">
				<a href="/accounts"
					class="btn btn-primary bankdemo-buton-primary">${pageButtonText }</a>
			</c:if>

		</div>
	</main>
</div>

<jsp:include page="/include/footer.jsp"></jsp:include>