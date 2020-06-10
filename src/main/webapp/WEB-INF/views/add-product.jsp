
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
    .error{
        color:darkred;
    }
</style>
<html>
<head>
    <title>Product</title>
</head>
<body>
<c:if test = "${idProduct == null}">
    <h1>Add product</h1>
</c:if>
<c:if test = "${idProduct != null}">
    <h1>Edit product ${idProduct}</h1>
</c:if>
<form:form method="POST" action="" modelAttribute="product">

    <spring:hasBindErrors name="product">
        <div>
            <h5>Errors: </h5>
            <form:errors path="name" cssClass="error"/>
            <form:errors path="price" cssClass="error"/>
        </div>
    </spring:hasBindErrors>

    <form:label path="name">Name</form:label>
    <form:input path="name" value="${product.name}"/>

    <form:label path="description">Description</form:label>
    <form:input path="description" value="${product.description}"/>

    <form:label path="price">Price</form:label>
    <form:input type="number" path="price" value="${product.price}"/>

    <button type="submit">Create product</button>
</form:form>
</body>
</html>
