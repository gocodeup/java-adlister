<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container ">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>

    <div class="container">
        <h1>Here Are all your ads!</h1>
    <div class="d-flex" >

        <c:forEach var="ad" items="${ads}">

            <div class="card col-md-6 m-5 p-3" style="width: 20rem;">
                <div class="card-body">
                    <div class="text-center">
                        <c:choose>
                            <c:when test="${ad.catId == 1}">
                                <i class="fa-solid fa-burger fa-2xl m-4"></i>
                            </c:when>
                            <c:when test="${ad.catId == 2}">
                                <i class="fa-solid fa-landmark fa-2xl m-4"></i>
                            </c:when>
                            <c:when test="${ad.catId == 3}">
                                <i class="fa-solid fa-solid fa-person-hiking fa-2xl m-4"></i>
                            </c:when>
                            <c:when test="${ad.catId == 4}">
                                <i class="fa-solid fa-people-line fa-2xl m-4"></i>
                            </c:when>
                            <c:otherwise>
                                <p>Etc</p>
                            </c:otherwise>
                        </c:choose>

                        <h3 class="card-title">${ad.title}</h3>
                    </div>
                    <hr>
                    <p class="card-text">${ad.description}</p>
                    <hr>
                    <h6 class="card-subtitle mb-2 text-muted">${ad.location}</h6>

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
                            <input type="" id="description" name="description">
                        </div>
                        <input type="hidden" value="${ad.id}" name="update">
                        <input type="submit">
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>
        <a href="profileupdate">
            <input class="" type="submit" value="Edit Account">
        </a>

        <jsp:include page="/WEB-INF/partials/footer.jsp" />

</body>
</html>
