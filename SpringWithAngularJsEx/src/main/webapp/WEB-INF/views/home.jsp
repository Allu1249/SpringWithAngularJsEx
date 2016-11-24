<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.3.2/angular-ui-router.js"></script>

<script type="text/javascript">
	var baseURL = window.location.origin;
	baseURL += '/employee';
</script>
</head>

<body ng-app="myEmp">
	<script src="<c:url value="/ui/js/Employee.js" />"></script>
	
	<div class="container" ng-controller="employeeController">
		<section id="uiview" ui-view=""></section>
	</div>
</body>
</html>
