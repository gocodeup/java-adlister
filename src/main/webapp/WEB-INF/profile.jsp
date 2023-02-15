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
    <jsp:include page="/WEB-INF/partials/search.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <p>Username: ${sessionScope.user.username}</p>
        <p>Email: ${sessionScope.user.email}</p>
        <a href="/updateinfo">Update Info</a>
    </div>

    <div>

        <c:forEach var="ad" items="${ads}">
            <div id="${ad.id}">
                <a href="/adpage?adId=${ad.getId()}">
                    <h2>${ad.title}</h2>
                </a>
            </div>
        </c:forEach>

    </div>
</body>
</html>
