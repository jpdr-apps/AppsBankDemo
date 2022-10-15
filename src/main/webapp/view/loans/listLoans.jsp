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
			class="d-flex justify-content-start flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
			<div style="vertical-align: middle !important">			
				<span data-feather="dollar-sign"
					style="width: 30px; height: 30px; color: #800000 !important; vertical-align: middle !important">
				</span> 
				<span class="form-label fs-2"  style="vertical-align: middle !important"> <fmt:message
						key="loans" bundle="${messageProperties}" />
				</span>
			 </div>
		</div>
		
		<br>
		
		<div class="ps-lg-4 bankdemo-main-accordion">
			<div >
				<form id="formBeginLoan" action="/loans/loanBegin" method="post">
				
				<button class="btn btn-primary" type="submit" >
				
					<span>
						<fmt:message key="listLoans.getNewLoan.message"
										bundle="${messageProperties}" />
					</span> 							
				
				</button>
					<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" /> 
				</form>
			</div>
		</div>
		
		<br>
		
		

			

			<c:if test="${ loanForms.getEntities().size() > 0 }">
			<table class="table" style="width: 80%!important;">
			
			
			
				<thead>
					<tr>
						<td style="width: 100px;"><span class="form-label fs-5 ">N°</span></td>
						<td style="width: 200px;text-align: right; padding-right: 5em;">
							<span class="form-label fs-5 ">
								<fmt:message key="listLoans.balance.message"
								bundle="${messageProperties}" />
							</span>
						</td>
						<td style="width: 200px;text-align: right; padding-right: 5em;">
							<span class="form-label fs-5 ">
								<fmt:message
									key="listLoans.remaningPayments.message"
									bundle="${messageProperties}" />
							</span>
						</td>
						<td style="width: 200px;">
							<span class="form-label fs-5 ">
							<fmt:message key="listLoans.nextDueDate.message"
								bundle="${messageProperties}" />
							</span>
						</td>
						<td>
							<span class="form-label fs-5 ">
							<fmt:message key="listLoans.actions.message"
								bundle="${messageProperties}" />
							</span>
						</td>
					</tr>
				</thead>

				<tbody>

					<c:forEach items="${ loanForms.getEntities() }" var="loanForm">

						<tr>
							<td class="align-middle">
								<span class="form-label fs-6 form-label-td-bd">
									${ loanForm.getNumber() }
								</span>
							</td>
							<td class="align-middle" style="text-align: right; padding-right: 5em;">
								<span class="form-label fs-6 form-label-td-bd">
									$ <fmt:formatNumber
									value="${ loanForm.getBalanceTotal() }" type="number"
									minFractionDigits="2">
									</fmt:formatNumber>
								</span>	
							</td>
							<td class="align-middle" style="text-align: right; padding-right: 5em;">
								<span class="form-label fs-6 form-label-td-bd">
									${ loanForm.getRemainingPeriods() }
								</span>
							</td>
							<td class="align-middle"> 
								<span class="form-label fs-6 form-label-td-bd">
									${ loanForm.getNextDueDate() }
								</span>
							</td>
							<td class="align-middle">
								<div class="dropdown">							
										<button class="btn" type="button"
											id="dropdownMenuButton" data-bs-toggle="dropdown"
											aria-expanded="false"
											style="border-style: none;"
											
											> 
												<span
												data-feather="more-vertical"
												style="width: 30px; height: 30px; color: #800000 !important; vertical-align: middle !important"></span>
										</button>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
											<li><a class="dropdown-item" href="/loans/${ loanForm.getNumber() }/listLoanPayments"><fmt:message
												key="listLoans.installments.message"
												bundle="${messageProperties}" /></a></li>
											<li><a class="dropdown-item" href="/loans/${ loanForm.getNumber() }/loanPayBegin"><fmt:message
												key="listLoans.payNext.message"
												bundle="${messageProperties}" /></a></li>
								 
										</ul>
									</div>
								</td>

					</tr>


					</c:forEach>

				</tbody>


			</table>
			
			</c:if>
			
			</main>
</div>

<script>
	function submitBeginLoanForm() {
		document.getElementById("formBeginLoan").submit();
	}
</script>


<jsp:include page="/include/footer.jsp"></jsp:include>