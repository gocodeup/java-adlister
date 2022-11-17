<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing searched ad" />
    </jsp:include>
    <title>ad</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar-ads-index.jsp" />

<div class="container">
    <h1>Here is the ad you are looking for!</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <a href="/ad?id=${ad.id}"><h2>${ad.title}</h2></a>
            <p>${ad.description}</p>
        </div>
    </c:forEach>
</div>
</body>
</html>
