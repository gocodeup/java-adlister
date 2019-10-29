<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>

        <div class="container">
            <h1>Here are your ads!</h1>

<%--        when the user id for ad matches user.id for the user display the ad--%>
        <c:choose>
            <c:when test="${sessionScope.user.id} == ${sessionScope.ads.user_id}">
        <c:forEach var="ad" items="${ads}">
            <div class="col-md-6">
                <h2>${ad.title}</h2>
                <p>${ad.description}</p>
            </div>
        </c:forEach>

            </c:when>
        </c:choose>
    </div>

</body>
</html>
