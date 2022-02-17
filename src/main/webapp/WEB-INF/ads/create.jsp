<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
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

<%--        <c:forEach var="category" items="${categories}">--%>
            <form action="/ads/create" method="GET">
        <input class="form-check-input" type="checkbox" name="categoryCheckbox" value="${category.id}" id="Automotive">
        <label class="form-check-label" for="Automotive">Automotive</label>
        <input class="form-check-input" type="checkbox" name="categoryCheckbox" value="${category.id}" id="Clothing">
        <label class="form-check-label" for="Clothing">Clothing</label>
        <input class="form-check-input" type="checkbox" name="categoryCheckbox" value="${category.id}" id="Electronics">
        <label class="form-check-label" for="Electronics">Electronics</label>
        <input class="form-check-input" type="checkbox" name="categoryCheckbox" value="${category.id}" id="Furniture">
        <label class="form-check-label" for="Furniture">Furniture</label>
        <input class="form-check-input" type="checkbox" name="categoryCheckbox" value="${category.id}" id="Home">
        <label class="form-check-label" for="Home">Home</label>
        <input class="form-check-input" type="checkbox" name="categoryCheckbox" value="${category.id}" id="Tools">
        <label class="form-check-label" for="Tools">Tools</label>
        <input class="form-check-input" type="checkbox" name="categoryCheckbox" value="${category.id}" id="Toys">
        <label class="form-check-label" for="Toys">Toys</label>
        <input class="form-check-input" type="checkbox" name="categoryCheckbox" value="${category.id}" id="Misc">
        <label class="form-check-label" for="Misc">Miscellaneous</label>
            </form>
<%--        </c:forEach>--%>

    </div>


            <%--createError attribute posts error message from createAdServlet --%>

            <h3 style="color: red">${createError}</h3>
            <input type="submit" class="btn btn-block btn-dark">
        </form>
<%--added link to get back to profile- AG--%>
        <a class="back-button" href="/profile"><i class="fa fa-chevron-left" aria-hidden="true">Back to Profile</i></a>
    </div>
</body>
</html>
