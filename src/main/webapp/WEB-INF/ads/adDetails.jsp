<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <c:forEach var="ad" items="${ads}">
        <div class="col">
            <h2>${ad.title}</h2>
            <h3>posted by ${user.username}</h3>
            <p>${ad.description}</p>
            <p>Contact for more info: ${user.email}</p>
        </div>
    </c:forEach>
</div>
</body>
</html>