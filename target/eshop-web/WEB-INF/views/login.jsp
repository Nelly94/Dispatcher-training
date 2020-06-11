<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
    .error{
        color:darkred;
    }
</style>
<html>
<head>
    <title>Login</title>
</head>
<body>
<c:if test = "${error == true}">
    <h1 class="error">Invalid login</h1>
</c:if>
<form action="" method="POST">
    <table>
        <tr>
            <td>User:</td>
            <td><input type="text" name="username" value=""/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" value=""/></td>
        </tr>
        <tr>
            <td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /></td>
        </tr>

        <tr>
        <td><input type="submit" value="login"/></td>
        </tr>
    </table>
</form>
</body>
</html>
