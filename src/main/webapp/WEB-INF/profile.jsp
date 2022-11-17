<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
    <title>my profile</title>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar-logged-in.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <a href="/profile/update?userId=${user.id}">
            <button class="btn btn-default">Update profile</button>
        </a>

        <form action="/profile/delete?id=${user.id}" method="POST">
            <input type="hidden" name="userId" value="${user.id}">
            <button type="submit" class="btn btn-danger">Delete User</button>
        </form>

        <h1>${sessionScope.ads}</h1>

        <c:forEach var="ad" items="${ads}">
            <div class="col-md-6">
                <a href="/ad?id=${ad.id}"><h2>${ad.title}</h2></a>
                <p>${ad.description}</p>

                <a href="/ads/update?id=${ad.id}">
                    <button class="btn btn-primary">Update Ad</button>
                </a>

                <form action="/ads/delete" method="POST" class="mt-">
                    <button class="btn btn-danger">Delete Ad</button>
                    <input type="hidden" name="id" value="${ad.id}">
                </form>

            </div>
            </c:forEach>
    </div>

</body>
</html>
