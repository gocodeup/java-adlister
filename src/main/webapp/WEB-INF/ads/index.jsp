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
        <div class="col-md-6">
            <a href="/ad?id=${ad.id}"><h2>${ad.title}</h2></a>
            <p>${ad.description}</p>
        </div>
    </c:forEach>

    <c:forEach var="ad2" items="${ads2}">
        <div class="col-md-6">
            <a href="/ad?id=${ad2.id}"><h2>${ad2.title}</h2></a>
            <p>${ad2.description}</p>
        </div>
    </c:forEach>

<%--    <div>--%>
<%--        <h2>${ads2.title}</h2>--%>
<%--        <p>${ads2.description}</p>--%>
<%--    </div>--%>
</div>

</body>
</html>
