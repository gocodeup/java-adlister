<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
    <link rel="stylesheet" href="/stylesheets/styles.css">
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Create a new Ad</h1>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text"></textarea>
            </div>

    <div class="form-check">

        <c:forEach var="category" items="${allCategories}">

        <input class="form-check-input mx-auto" type="checkbox" name="categoryCheckbox" value="${category.id}" id="${category.id}">
        <label class="form-check-label mx-3 justify-content-between" for="${category.id}">${category.category}</label>
        </c:forEach>
    </div>

            <%--createError attribute posts error message from createAdServlet --%>

            <h3 style="color: red">${createError}</h3>
            <input type="submit" class="btn btn-block btn-dark">
        </form>
<%--added link to get back to profile- AG--%>
        <a class="back-button" href="/profile"><i class="fa fa-chevron-left" aria-hidden="true"></i>Back to Profile</a>
    </div>



    <jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
</body>
</html>
