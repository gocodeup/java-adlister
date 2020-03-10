<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="category" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Categories
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                    <button class="dropdown-item" type="button">cars</button>
                    <button class="dropdown-item" type="button">home goods</button>
<%--                    <button class="dropdown-item" type="button">Something else here</button>--%>
                </div>
            </div>
<%--            <div class="form-group">--%>
<%--                <label for="category">Category</label>--%>
<%--                <textarea id="category" name="category" class="form-control" type="text"></textarea>--%>
<%--            </div>--%>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>
