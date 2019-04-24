<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<html>

<head>
	<title>zjw Home Page</title>
</head>

<body>
	<h2>zjw  Home Page</h2>
	<hr>
	
	<p>
		User: <security:authentication property="principal.username"/>
		<br><br>
		Role(s): <security:authentication property="principal.authorities"/>
	</p>

	<hr>

	<security:authorize access="hasRole('MANAGER')">
	<p>
		<a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
		(Only for Manager peeps)
	</p>
	<hr>
	</security:authorize>


	<security:authorize access="hasRole('ADMIN')">
	<p>
		<a href="${pageContext.request.contextPath}/systems">Systems Meeting</a>
		(Only for systems peeps)
	</p>
	<hr>
	</security:authorize>

	<form:form action = "${pageContext.request.contextPath}/logout" method="post">
		<input type="submit" value="Logout">
	</form:form>

</body>

</html>