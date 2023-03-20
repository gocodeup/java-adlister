<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/style.jsp"/>
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
            <div class="form-group">
                <label for="gender">Gender</label>
                <select id="gender" name="gender" class="form-control" type="text">
                    <option value="female">F</option>
                    <option value="male">M</option>
                    <option value="unknown">N/A</option>
                </select>
            </div>
            <div class="form-group">
                <label for="age">Age</label>
                <input id="age" name="age" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="price">Price</label>
                <input id="price" name="price" class="form-control" type="text" placeholder="##,###,###.##">
            </div>
            <div class="form-group">
                <label for="img_url">IMG URL</label>
                <textarea id="img_url" name="img_url" class="form-control" type="url"></textarea>
            </div>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>
