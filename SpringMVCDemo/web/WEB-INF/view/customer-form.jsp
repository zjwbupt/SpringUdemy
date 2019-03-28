<%--
  Created by IntelliJ IDEA.
  User: jianweizhang
  Date: 2019-03-27
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer Registration Form</title>

    <style>
        .error{color: #ff790d
        }
    </style>
</head>

<body>

<i>Fill out the form. Asterisk(*) means required.</i>

    <form:form action="processForm" modelAttribute="customer">

        First Name: <form:input path="firstName" />

        <br><br>

        Last Name (*): <form:input path="lastName" />
        <form:errors path="lastName" cssClass="error" />

        <br><br>

        Free Passes: <form:input path="freePasses"/>
        <form:errors path="freePasses" cssClass="error"/>

        <br><br>
        Course Code: <form:input path="courseCode"/>
        <form:errors path="courseCode" cssClass="error"/>
        <br><br>

        <input type = "submit" value="Submit"/>
    </form:form>

</body>
</html>
