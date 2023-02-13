<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Welcome to the Adlister!</h1>
    </div>

    <div>
        <jsp:include page="/WEB-INF/partials/search.jsp"/>
    </div>

<%--    <form action="/ads/search" method="GET">--%>
<%--        <input id="s" name="s" type="search" placeholder="Search Ads..." aria-label="Search">--%>
<%--        <button class="btn btn-outline-success" type="submit"></button>--%>
<%--    </form>--%>

</body>
</html>
