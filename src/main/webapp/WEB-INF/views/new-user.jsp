<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 11/06/2020
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<style type="text/css">
    .error{
        color:darkred;
    }
</style>
<html>
<head>
    <title>New user</title>
</head>
<body>
    <form:form method="POST" action="" modelAttribute="user">

        <spring:hasBindErrors name="user">
            <div>
                <h5>Errors: </h5>
                <form:errors path="firstname" cssClass="error"/>
                <form:errors path="lastname" cssClass="error"/>
                <form:errors path="username" cssClass="error"/>
                <form:errors path="password" cssClass="error"/>
            </div>
        </spring:hasBindErrors>

        <form:label path="firstname">First name</form:label>
        <br>
        <form:input path="firstname" value="${user.firstname}"/>
        <br>

        <form:label path="lastname">Last name</form:label>
        <br>
        <form:input path="lastname" value="${user.lastname}"/>
        <br>

        <form:label path="username">Username</form:label>
        <br>
        <form:input path="username" value="${user.username}"/>
        <br>

        <form:label path="password">Password</form:label>
        <br>
        <form:input type="password" path="password" value="${user.password}"/>
        <br>

        <form:label path="passwordConfirmation">Password confirm</form:label>
        <br>
        <form:input type="password" path="passwordConfirmation" value="${user.passwordConfirmation}"/>
        <br>



        <button type="submit">Create user</button>
    </form:form>
</body>
</html>
