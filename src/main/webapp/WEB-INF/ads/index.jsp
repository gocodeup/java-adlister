<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1> ${heading}</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">

            <a href="/ad/?ad=${ad.id}">
                <h3 class="card-title">${ad.title}</h3>
            </a>
            <p>${ad.description}</p>
            <h5>Category: ${ad.category}</h5>
        </div>
    </c:forEach>
</div>

</body>
</html>
