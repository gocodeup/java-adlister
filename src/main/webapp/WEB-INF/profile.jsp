<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<% %>


<div class="container">
    <h1>Welcome, ${sessionScope.user.username}!</h1>
</div>
<c:forEach var="ad" items="${ads}">
    <div class="container">
        <div class="card">
            <div class="card-header">
<%--                    Code Below is need to display ad--%>
                <h2><a href="ads/show?id=${ad.id}&userId=${ad.userId}" class="text-secondary nav-link">${ad.title}</a></h2>
            </div>
            <div class="card-body">
                <p class="card-text">${ad.description}</p>
            </div>
            <form method="post" action="/ads/delete">
                <button type="submit" name="id" value="${ad.id}" class="btn btn-primary">
                    Delete
                </button>
            </form>
        </div>
    </div>
</c:forEach>

</body>
</html>
