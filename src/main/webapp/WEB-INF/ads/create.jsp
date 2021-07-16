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
            <br>
            <div>
                <h4>Category</h4>
                <h5>(More than one may be selected)</h5>
            </div>
            <div class="form-check form-check-inline">
                <input name="category" type="checkbox" id="sportinggoods" value="Sports1">
                <label for="sportinggoods">Sporting Goods</label>
            </div>
            <div class="form-check form-check-inline">
                <input  name="category" type="checkbox" id="vehicles" value="Camping2">
                <label for="vehicles">Vehicles</label>
            </div>
            <div class="form-check form-check-inline">
                <input  name="category" type="checkbox" id="jobs" value="Computers3">
                <label  for="jobs">Jobs</label>
            </div>
            <div class="form-check form-check-inline">
                <input  name="category" type="checkbox" id="furniture" value="Phones4">
                <label for="furniture">Furniture</label>
            </div>
            <div class="form-check form-check-inline">
                <input  name="category" type="checkbox" id="electronics" value="Jobs5">
                <label  for="electronics">Electronics</label>
            </div>
            <div class="form-check form-check-inline">
                <input  name="category" type="checkbox" id="other" value="Clothing6">
                <label  for="other">Other</label>
            </div>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>
