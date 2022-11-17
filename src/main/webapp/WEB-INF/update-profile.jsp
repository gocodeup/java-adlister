<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vicente
  Date: 11/16/22
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Update Your Ad"/>
    </jsp:include>
    <title>Title</title>
</head>
<body style="padding: 5em;">
    <h1>Edit Your Profile</h1>
    <form action="/profile/update" method="POST">
        <input name="userId" value="${userId}" style="display: none">
        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username" class="form-control" type="text" required/>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input id="email" name="email" class="form-control" type="text" required/>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input id="password" name="password" class="form-control" type="password" required/>
        </div>
        <c:if test="${inputIsNull}">
            <small>No fields left blank.</small>
        </c:if>
        <input type="submit" class="btn btn-block btn-primary" value="Update Profile">
    </form>
</body>
</html>
