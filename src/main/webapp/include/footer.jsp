 <!-- Footer Start-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:eval expression="@environment.getProperty('server.servlet.session.timeout')" var="serverSessionTimeout" />
<fmt:setBundle basename="messages" var="messageProperties"/>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 </div>
</div>


<div class="modal fade " id="sessionTimeoutModal" aria-labelledby="sessionTimeoutModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="sessionTimeoutModalLabel">
	        <fmt:message key="sessionExpiredTitle" bundle="${messageProperties}" />
        </h5>        
      </div>
      <div class="modal-body text-center" style="font-size: 1rem!important;">
			<fmt:message key="sessionExpiredMessage1" bundle="${messageProperties}" />    
			<br>
			<fmt:message key="sessionExpiredMessage2" bundle="${messageProperties}" />
      </div>
          <div class="modal-footer" style="justify-content: center">      
		      <button class="btn btn-primary" type="button" onclick="redirectLogout()"
							style="font-size: 1rem!important;" data-bs-dismiss="modal">				
		      			<fmt:message key="forms.accept.message" bundle="${messageProperties}" />       
		        </button>        
	      </div>
      
    </div>
  </div>  
</div>

 
<script src="https://code.jquery.com/jquery.js"></script>

<script type="text/javascript">

/* Timeout modal */
let timer, currSeconds = 0;
let serverSessionTimeoutString = '<c:out value="${ serverSessionTimeout }"></c:out>';
let serverSessionTimeoutSecondsIndex = parseInt(serverSessionTimeoutString.indexOf('s'));
let serverSessionTimeout = parseInt(serverSessionTimeoutString.substring(0,serverSessionTimeoutSecondsIndex)) - 5;

function resetTimer() {	
    clearInterval(timer);
    currSeconds = 0;
    timer = setInterval(startIdleTimer, 1000);
}
 
window.onload = resetTimer;
window.onmousemove = resetTimer;
window.onmousedown = resetTimer;
window.ontouchstart = resetTimer;
window.onclick = resetTimer;
window.onkeypress = resetTimer;

function startIdleTimer() {
      
    currSeconds++;

	if (currSeconds >= serverSessionTimeout ) { 
		$('#sessionTimeoutModal').modal('show');
	}
}

function redirectLogout(){
	window.location.href = "/logout";
}

</script>


    <script src="/include/js/bootstrap.bundle.min.js"></script>

      <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous">      </script>        
	  <script src="/include/js/common.js"></script> 
  </body>
</html>
 <!-- Footer End-->