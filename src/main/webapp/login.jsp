<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Please Log In"/>
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp"/>
<div class="container">
<%--    <div class="row">--%>
        <form action="/login.jsp" method="POST">
            <div class="form-group">
                <h1>This is where you login</h1>
            </div>
            <div class="form-control">
                <lebel>Username:</lebel>
                <input type="text" id="userName" name="userName" class="form-control">
            </div>
            <div class="form-control">
                <lebel>Password:</lebel>
                <input type="password" id="password" name="pass" class="form-control">
            </div>
            <div>
                <input type="submit" class="btn btn-primary btn-block" value="Log In"/>
<%--            </div>--%>
        </form>
    </div>
</div>
</body>
</html>
