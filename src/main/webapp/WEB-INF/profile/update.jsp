<%--
  Created by IntelliJ IDEA.
  User: eloysbook
  Date: 2/15/22
  Time: 12:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/profile/update" method="post">
    <div class="form-group">
        <label for="username">Username</label>
        <input id="username" name="username" value= ${sessionScope.user.username} class="form-control" type="text">
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <input id="email" name="email" value= ${sessionScope.user.email} class="form-control" type="text">
    </div>
    <input type="submit" class="btn btn-primary btn-block">
</form>

</body>
</html>
