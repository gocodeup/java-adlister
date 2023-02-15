<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body class="bg-dark">
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container" style="text-align: center">
        <a href="${pageContext.request.contextPath}<c:url value="/ads"/>"><h1>Welcome to the Adlister!</h1></a>
    </div>


<%--    <form action="/ads/search" method="GET">--%>
<%--        <input id="s" name="s" type="search" placeholder="Search Ads..." aria-label="Search">--%>
<%--        <button class="btn btn-outline-success" type="submit"></button>--%>
<%--    </form>--%>

</body>
</html>
