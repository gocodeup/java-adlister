<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
<%--    <link rel="stylesheet" href="css/landingPg.css" type="text/css">--%>
</head>
<body>

    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1 class="text">Welcome to UFO-Lister!</h1>
    </div>

    <div>

        <a href="${pageContext.request.contextPath}<c:url value="/ads"/>"><img class="img-center" src="https://iili.io/HG2er3x.md.png"></a>

    </div>


<%--    <form action="/ads/search" method="GET">--%>
<%--        <input id="s" name="s" type="search" placeholder="Search Ads..." aria-label="Search">--%>
<%--        <button class="btn btn-outline-success" type="submit"></button>--%>
<%--    </form>--%>

</body>
</html>
