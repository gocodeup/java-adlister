<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/partials/navbar.jsp" />
<h1>Advertisements</h1>
<div class="container">
    <h1>All ads:</h1>

    <c:forEach items="${allAds}" var="ad">
        <div>${ad.getTitle()}</div>
        <p>${ad.getDesciption()}</p>
    </c:forEach>
<%--    <c:forEach var="ad" items="${ads}">--%>
<%--        <div class="col-md-6">--%>
<%--            <h2>${ad.title}</h2>--%>
<%--            <p>${ad.description}</p>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>
</div>

</body>
</html>
