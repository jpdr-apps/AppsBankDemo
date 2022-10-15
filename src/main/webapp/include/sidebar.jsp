<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<fmt:setBundle basename="messages" var="messageProperties"/>
					<nav id="sidebarMenu"
						class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse" style="width: 250px!important;">
						<div class="position-sticky pt-3 sidebar-sticky">
							<ul class="nav flex-column">
								<li class="nav-item">
									<a class="nav-link ${ ( (activeMenu == null )  || (activeMenu.equals('home') == true) ? 'active' : '' ) } " aria-current="page" href="/home">
										<span data-feather="home" style="vertical-align:middle!important"></span>
										<span style="vertical-align:middle!important; font-size: 16px;">
										<fmt:message key = "sidebar.products.message" bundle = "${messageProperties}"/>
										</span>
									</a>
								</li>
								<li class="nav-item">
									<a class="nav-link ${ activeMenu.equals('accounts') ? 'active' : '' }" href="/accounts">
										<span data-feather="book" style="vertical-align:middle!important"></span>
										<span style="vertical-align:middle!important"><fmt:message key = "sidebar.accounts.message" bundle = "${messageProperties}"/></span>
									</a>
								</li>
								<li class="nav-item">
								<a class="nav-link ${ activeMenu.equals('loans') ? 'active' : '' }" href="/loans">
										<span data-feather="dollar-sign" class="align-text-bottom"></span>
										<span style="vertical-align:middle!important"><fmt:message key = "sidebar.loans.message" bundle = "${messageProperties}"/></span>										
								</a></li>
								<li class="nav-item">
									<a class="nav-link ${ activeMenu.equals('payments') ? 'active' : '' }"	href="/payments"> 
										<span data-feather="repeat" class="align-text-bottom"></span> 
										<span style="vertical-align:middle!important"><fmt:message key = "sidebar.transactions.message" bundle = "${messageProperties}"/></span>
									</a>
								</li>
								<li class="nav-item">
									<a class="nav-link ${ activeMenu.equals('settings') ? 'active' : '' }" href="/settings">
											<span data-feather="settings" class="align-text-bottom"></span> 
											<span style="vertical-align:middle!important"><fmt:message key = "sidebar.settings.message" bundle = "${messageProperties}"/></span>
									</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="/logout">
											<span data-feather="log-out" class="align-text-bottom"></span>
											<span style="vertical-align:middle!important"><fmt:message key = "sidebar.logOut.message" bundle = "${messageProperties}"/></span>										
									</a>
								</li>								
							</ul>
						</div>
					</nav>