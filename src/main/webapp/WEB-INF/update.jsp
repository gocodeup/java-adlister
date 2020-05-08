<%--
  Created by IntelliJ IDEA.
  User: gdev
  Date: 5/6/20
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
    <div class="container">
        <jsp:include page="partials/message.jsp" />
        <h1>Please fill in your information.</h1>
        <form action="/update" method="post">
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
