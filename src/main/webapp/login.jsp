<%--
  Created by IntelliJ IDEA.
  User: Kelvon
  Date: 5/27/21
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Log In</h1>
<%
    request.getParameter("username");
    request.getParameter("password");
%>
<p>
    ${param.username}
</p>
<p>
    ${param.password}
</p>
<c:choose>
    <c:when test="${param.username==null || param.password==null}">
        <p>Hello Admin, please login </p>
    </c:when>
    <c:when test="${param.username.equals('admin') && param.password.equals('password')}">
        <c:redirect url="/profile.jsp"/>
    </c:when>
    <c:otherwise>
        <p>Sorry you're not an admin!</p>
    </c:otherwise>
</c:choose>
<form action="login.jsp" method="post">
    <div class="container">
       <label for="username">Username :</label>
        <input type="text" id="username" name="username" required >
    </div>
    <div>
        <label for="password">Password :</label>
        <input type="password" id="password" name="password" required>
    </div>
    <div><button type="submit">Login</button></div>




</form>
</body>
</html>
