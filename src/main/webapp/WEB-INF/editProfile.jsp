<%--
  Created by IntelliJ IDEA.
  User: jevian
  Date: 2/16/22
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit profile"/>
    </jsp:include>
    <link rel="stylesheet" href="/stylesheets/styles.css">
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">

    <h1>Update your Profile:</h1>

<div class="container-fluid my-5 justify-content-around">
    <div class="container d-flex justify-content-center">
        <form action="/editProfile" method="post" style="width: 60%">
            <div class="form-group form-check">
                <label for="username">Username</label>

                <input type="text" class="form-control" id="username" name="username" disabled value="${sessionScope.user.username}">

            </div>
    <div class="form-group">
        <label for="email">Email address</label>
        <input type="email" class="form-control" id="email" name="email" value="${sessionScope.user.email}">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password">
    </div>
    <div class="form-group">
        <label for="confirmPassword">Confirm Password</label>
        <input type="password" class="form-control" id="confirmPassword" name="confirmPassword">
    </div>
    <h3 style="color: red;">${editError}</h3>
    <button type="submit" class="btn btn-dark btn-block">Save changes</button>
</form>
</div>
    <a class="back-button" href="/profile"><i class="fa fa-chevron-left" aria-hidden="true"></i>Back to Profile</a>
</div>
</div>
<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
</body>
</html>
