<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar-ads.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>

    <c:forEach var="ad" items="${ads}">

        <div class="col-md-6" >
            <form action="/ads/singles" method="post">
                <input type="hidden" name="ad_id" value="${ad.id}">
            <button type="submit"><h2>${ad.title}</h2></button>
            </form>
            <p>${ad.description}</p>
        </div>

    </c:forEach>

    <c:forEach var="ad2" items="${ads2}">
        <div class="col-md-6" >
            <form action="/ads/singles" method="post">
                <input type="hidden" name="ad_id" value="${ad2.id}">
                <button type="submit"><h2>${ad2.title}</h2></button>
            </form>
            <p>${ad2.description}</p>
        </div>
    </c:forEach>

</div>

</body>
</html>
