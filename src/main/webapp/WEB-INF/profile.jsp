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
        <div>

    <h1 style="text-align: center">Welcome, ${sessionScope.user.username}!</h1>
        <h2 style="text-align: center">Here are all of your active ads:</h2>
            <div class="card" style="text-align: center">
        <c:forEach var="ad" items="${ads}">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
            <a href="/ad?id=${ad.id}" class="btn btn-primary" style="align-content: center">More Details</a>
        </c:forEach>
            </div>
        </div>
    </div>

</body>
</html>
