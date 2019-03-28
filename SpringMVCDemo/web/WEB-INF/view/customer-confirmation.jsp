<%--
  Created by IntelliJ IDEA.
  User: jianweizhang
  Date: 2019-03-27
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Customer Confirmation</title>
</head>
<body>
    The Customer is Confirmed,
    The First Name: ${customer.firstName} <br/>
    The Last Name: ${customer.lastName} <br/>

    <br><br>
    Free Passes: ${customer.freePasses}

    <br><br>
    Course Code: ${customer.courseCode}
</body>
</html>
