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
        <label for="pick-color">Please type your favorite color:</label>
        <input type="text" class="form-control" id="pick-color" name="color" placeholder="Mustard yellow">
    </div>
    <button type="submit" class="btn btn-primary">Let's Do This</button>
</form>

<%--<%@include file="partials/footer.jsp"%>--%>
<%--<%@include file="partials/scripts.jsp"%>--%>
</body>
</html>