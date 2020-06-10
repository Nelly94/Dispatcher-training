
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<c:if test = "${idProduct == null}">
    <h1>Add product</h1>
</c:if>
<c:if test = "${idProduct == null}">
    <h1>Edit product ${idProduct}</h1>
</c:if>
</body>
</html>
