<%--
  Created by IntelliJ IDEA.
  User: Kelvon
  Date: 6/1/21
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Products</title>
</head>
<body>
<h1>Here are all the products:</h1>

<c:forEach var="product" items="${products}">
    <div class="product">
        <h2>${product.name}</h2>
        <p>Price: $ ${product.price}</p>
    </div>
</c:forEach>

</body>
</html>
