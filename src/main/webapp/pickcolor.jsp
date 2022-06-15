<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Pick a Color</title>
    <%@ include file="partials/head.jsp"%>
</head>
<body>
<%@include file="partials/navbar.jsp"%>

<form method="post" class="w-50"  style="width: 500px;">
    <div class="form-group">
        <label for="pick-color">Enter your favorite color:</label>
        <input type="text" class="form-control" id="pick-color" name="color" placeholder="color or hex code">
    </div>
    <button type="submit" class="btn btn-primary">Submit Your Color</button>
</form>

<%--<%@include file="partials/footer.jsp"%>--%>
<%--<%@include file="partials/scripts.jsp"%>--%>
</body>
</html>