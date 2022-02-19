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
        <div class="col-md-6">
            <h2><c:out value="${ad.title}"/></h2>
            <p><c:out value="${ad.description}"/></p>
            <c:if  test="${ad.userId == sessionScope.user.id}" >
                <form action="/ads/update" method="get">
                    <input type="hidden" name="ad_id" value="${ad.id}">
                    <input class="btn btn-secondary btn-sm" name="update" type="submit" value="Edit">
                </form>
                <form action="/ads/delete" method="post">
                    <input type="hidden" name="ad_id" value="${ad.id}">
                    <input class="btn btn-danger btn-sm" type="submit" value="Delete">
                </form>
            </c:if>
        </div>
    </c:forEach>
</div>

</body>
</html>
