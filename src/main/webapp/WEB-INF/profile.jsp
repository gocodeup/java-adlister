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
        <h1>${sessionScope.ads}</h1>

        <c:forEach var="ad" items="${ads}">
        <div class="User">
            <h3>${ad.title}</h3>
            <p>${ad.description}</p>
        </div>
            </c:forEach>
    </div>

</body>
</html>
