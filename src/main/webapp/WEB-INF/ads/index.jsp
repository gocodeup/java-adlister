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
    <h1>Here Are all the ads!</h1>
    <c:forEach var="ad" items="${ads}">
        <div class="container">
            <div class="card">
                <div class="card-header">
                        <%--                <h2>THIS IS AN AD</h2>--%>
                    <h2>${ad.title}</h2>
                </div>
                <div class="card-body">
                    <p class="card-text">${ad.description}</p>
                        <%--                <p>AD DESCRIPTION</p>--%>
                </div>
                <form method="post" action="/ads/delete">
                    <button type="submit" name="id" value="${ad.id}" class="btn btn-primary">
                        Delete
                    </button>
                </form>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>
