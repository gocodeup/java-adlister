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
        <c:forEach var="ad" items="${ads}">
            <div class="col-md-6">
                <img src="${ad.imageURL}">
                <a href="/ad?id=${ad.id}"><h2>${ad.name}</h2></a>
                <p>${ad.description}</p>
                <p><a href="/update?id=${ad.id}">Update</a></p>
                <p><a href="/delete?id=${ad.id}">Delete</a></p>
            </div>
        </c:forEach>
    </div>
</body>
</html>
