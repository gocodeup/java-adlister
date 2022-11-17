<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar-profile.jsp" />

    <div class="container text-center">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
            <form method="get" action="/profile/update">
                <input type="hidden" name="id" value="${ad.id}">
                <input type="hidden" name="title" value="${ad.title}">
                <input type="hidden" name="description" value="${ad.title}">
                <button type="submit">UPDATE</button>
            </form>

            <form method="get" action="/profile/delete">
                <input type="hidden" name="id" value="${ad.id}">
                <button type="submit">DELETE</button>
            </form>

        </div>
    </c:forEach>

</body>
</html>
