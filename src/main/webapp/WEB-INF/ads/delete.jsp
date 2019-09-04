<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Delete an Ad</h1>
    <h1>Pickj an Ad to Delete:</h1>
    <c:forEach var="ad" items="${ads}">
    <form action="/ads/delete?${ad.id}" method="post">
        <div class="row">
            <div class="col-md-6" style="border: black 1px">
                <h2>${ad.title}</h2>
                <p>Description: ${ad.description}</p>
                <h4>Block: ${ad.block}</h4>
                <h4>Category: ${ad.category}</h4>
                <h3>Date: ${ad.date}, Ad ID:${ad.id}</h3>
                <input type="submit" value="Delete">
            </div>
            </c:forEach>
        </div>
    </form>
</div>
</body>
</html>
