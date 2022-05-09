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
        <div class="col-md-6 container">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
            <form action="/update" method="POST">
                <div class="form-group">
                    <label for="title">Edit Title</label>
                    <input type="text" id="title" name="title">
                </div>
<%--                    <br>--%>
                <div class="form-group">
                    <label for="location">Edit Location</label>
                    <input type="text" id="location" name="location">
                </div>
<%--                    <br>--%>
                <div class="form-group">
                    <label for="description">Edit Description</label>
                    <input type="text" id="description" name="description">
                </div>
            </form>
        </div>
    </c:forEach>
</div>

</body>
</html>
