<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
    <title>create ad</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar-create-ad.jsp" />
    <div class="container">
        <h1>create a new ad</h1>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="description">description</label>
                <textarea id="description" name="description" class="form-control" type="text"></textarea>
            </div>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>
