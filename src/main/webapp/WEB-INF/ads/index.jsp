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
    <h1>Here Are all the ads!</h1>
    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6" style="border: black 1px">
            <a href="/ad/id/?${ad.id}">
            <h2>${ad.title}</h2>
            </a>
            <p>Description: ${ad.description}</p>
            <h4>Block: ${ad.block}</h4>
            <h4>Category: ${ad.category}</h4>
            <h3>Date: ${ad.date},  Ad ID:${ad.id}</h3>
        </div>
    </c:forEach>
</div>
</body>
</html>
