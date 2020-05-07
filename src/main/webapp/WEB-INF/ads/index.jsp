<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>

    <form method="POST" action = "/ads" id="search_form">
        <input type="text" name="search" id="search" placeholder="Search">
        <button type="submit">Search</button>
    </form>

    <c:forEach var="ad" items="${ads}">
        <br>
        <div class="col-md-6">
            <h2><c:out value="${ad.title}"/></h2>
            <p><c:out value="${ad.description}"/></p>
            <a href="/WEB-INF/single_ad?id=${ad.id}">Click here to view more about this ad!</a>
        </div>
    </c:forEach>
    <br>
</div>
<br>
</body>
</html>
