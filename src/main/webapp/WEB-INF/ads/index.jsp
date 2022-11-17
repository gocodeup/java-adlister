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

<div class="container text-center">
    <h1>All Ads</h1>

    <div class="container">
        <div class="row row-cols-6">

        <c:forEach var="ad" items="${ads}">
        <div class="col-6 d-block" >
            <form action="/ads/singles" method="post">
                <input type="hidden" name="ad_id" value="${ad.id}">
                <input type="hidden" name="ad_title" value="${ad.title}">
            <button type="submit" class="btn btn-warning"><h2>${ad.title}</h2></button>
            </form>
        </div>
    </c:forEach>

</div>
</div>
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
