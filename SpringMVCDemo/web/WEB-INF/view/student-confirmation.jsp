<%--
  Created by IntelliJ IDEA.
  User: jianweizhang
  Date: 2019-03-27
  Time: 00:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri ="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Student Confirmation</title>
</head>

<body>
The student is confirmed: ${student.firstName} ${student.lastName}

<br/>

Country: ${student.country}
<br/>
Operating System:
<ul>
    <c:forEach var ="temp" items = "${student.operationSystems}">
        <li> ${temp}</li>
    </c:forEach>
</ul>
</body>

</html>
