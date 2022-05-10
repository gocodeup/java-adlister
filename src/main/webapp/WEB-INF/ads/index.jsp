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
            <p>${ad.location}</p>
                <c:choose>
                    <c:when test="${ad.catId == 1}">
                        <i class="fa-solid fa-burger fa-2xl mx-4"></i>
                    </c:when>
                    <c:when test="${ad.catId == 2}">
                        <i class="fa-solid fa-landmark fa-2xl mx-4"></i>
                    </c:when>
                    <c:when test="${ad.catId == 3}">
                        <i class="fa-solid fa-solid fa-person-hiking fa-2xl mx-4"></i>
                    </c:when>
                    <c:when test="${ad.catId == 4}">
                        <i class="fa-solid fa-people-line fa-2xl mx-4"></i>
                    </c:when>
                    <c:otherwise>
                        <p>Etc</p>
                    </c:otherwise>
                </c:choose>
            </p>
            <form action="/update" method="POST">
                <div class="form-group">
                    <label for="category">Edit Category</label>
                    <select name="category" id="category">
                        <option value=1>Restaurants</option>
                        <option value=2>History</option>
                        <option value=3>Outdoors</option>
                        <option value=4>Family</option>
                        <option value=5>Etc.</option>
                    </select>
                </div>
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
                <input type="hidden" value="${ad.id}" name="update">
                <input type="submit">
            </form>
        </div>
    </c:forEach>
</div>

</body>
</html>
