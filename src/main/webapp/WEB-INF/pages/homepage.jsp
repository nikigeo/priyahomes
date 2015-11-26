<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html ng-app="priyaHomesApp">
 <head>
    <link href="/resources/core/style/style.css" rel="stylesheet" />
    <link href="/resources/core/style/bootstrap.min.css" rel="stylesheet" />
    <script src="/resources/core/js/jquery-2.1.4.min.js"></script>
    <script src="/resources/core/js/bootstrap.min.js"></script>
    <script src="/resources/core/js/angular.min.js"></script>
    <script src="/resources/core/js/angular-route.js"></script>
    <script src="/resources/core/js/app.js"></script>
    <script src="/resources/core/js/customer/customerService.js"></script>
    <script src="/resources/core/js/customer/customerController.js"></script>
    <script src="/resources/core/js/building/buildingService.js"></script>
    <script src="/resources/core/js/building/buildingDetailsController.js"></script>

  </head>
<body>

	<div id="topBanner"></div>
		<div id="mainContent">
			<div id="menuLinks">
				<a href="#/addCustomer">Create Customer</a><hr>
				<a href="#/search">Search Customer</a><hr>
				<a href="#/addBuilding">Add New Building</a><hr>

				<sec:authorize access="hasRole('ROLE_ADMIN')">
                		<!-- For login user -->
                		<c:url value="/logout" var="logoutUrl" />
                		<form action="${logoutUrl}" method="post" id="logoutForm">
                			<input type="hidden" name="${_csrf.parameterName}"
                				value="${_csrf.token}" />
                		</form>
                		<script>
                			function formSubmit() {
                				document.getElementById("logoutForm").submit();
                			}
                		</script>

                		<c:if test="${pageContext.request.userPrincipal.name != null}">
                			User : ${pageContext.request.userPrincipal.name} | <a
                            					href="javascript:formSubmit()"> Logout</a>
                		</c:if>
                	</sec:authorize>


			</div>
			<div id="contentArea" ng-view></div>
	</div>



</body>
</html>