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

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <a href="/adpage?adId=${ad.getId()}">
                <h2>${ad.title}</h2>
            </a>
        </div>
    </c:forEach>
</div>


<%--<form action="/ads/search" method="GET">--%>
<%--    <input id="s" name="s" type="search" placeholder="Search Ads..." aria-label="Search">--%>
<%--    <button class="btn btn-outline-success" type="submit"></button>--%>
<%--</form>--%>

</body>
</html>
