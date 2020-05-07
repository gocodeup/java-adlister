<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gdev
  Date: 5/6/20
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Update Ad"/>
</jsp:include>
<html>
<head>
    <title>Update</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<form method="POST" action="/update">
    <input type="hidden" name="updateId" value="adId"/>
    <label>Name:</label>
    <input type="text" name="adName">
    <br>
    <label>Description</label>
    <input type="text" name="adDescription">
    <br>
    

</form>
    <div class="container">
        <h1>Please fill in your information.</h1>
        <form action="/update" method="post">
            <h2>${errorMessage}</h2>
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <button onclick="location.href='/profile'" type="button">
                Update Profile</button>
        </form>
    </div>
</body>
</html>
