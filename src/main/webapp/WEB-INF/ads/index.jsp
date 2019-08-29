<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar-login.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>
    <c:forEach var="ad" items="${ads}">
        <c:forEach var="user" items="${user}">
            <c: if ${ad.id} == ${user.id}>
                <div class="col-md-3" style="border: black 1px">
                    <h2>${ad.title}</h2>
                    <p>${ad.description}</p>
                </div>
            </c:>
        </c:forEach>
    </c:forEach>
</div>
</body>
</html>
