<%--
  Created by IntelliJ IDEA.
  User: jianweizhang
  Date: 2019-03-27
  Time: 00:14
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri ="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Student Registration Form</title>
</head>

<body>

    <form:form action="processForm" modelAttribute="student">
        First Name: <form:input path = "firstName" />
        <br/>
        Last Name: <form:input path = "lastName" />
        <br/>
        Country:
        <form:select path="country">
            <form:options items="${student.countryOptions}"/>
        </form:select>

        <br/>
        Operating Systems:
        Linux <form:checkbox path="operationSystems" value = "Linux"/>
        Windows <form:checkbox path="operationSystems" value = "Windows"/>
        Mac OS <form:checkbox path="operationSystems" value = "Mac OS"/>

        
        <br/>




        <input type = "submit" value = "Submit"/>
    </form:form>




</body>

</html>
