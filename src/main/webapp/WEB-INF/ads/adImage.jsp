<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad image" />
    </jsp:include>
</head>
<body>
<div class="container">
    <h1>Add a new image to this Ad</h1>
    <form action="/ads/images" method="post">
        <div class="form-group">
            <label for="path">Path</label>
            <input id="path" name="path" class="form-control" type="text">
        </div>
        <input type= "hidden" name="adid" id="adid" value="${adid}">
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>
