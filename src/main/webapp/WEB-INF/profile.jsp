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

    <div class="col-md-6 container ">
        <div>

    <h1>Welcome, ${sessionScope.user.username}!</h1>
        <h2>Here are all of your active ads:</h2>
        <c:forEach var="ad" items="${ads}">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
            <a href="/ad?id=${ad.id}" class="btn btn-primary">More Details</a>
        </c:forEach>
        </div>
    </div>

</body>
</html>
