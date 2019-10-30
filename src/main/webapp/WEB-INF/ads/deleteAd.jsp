<%--
  Created by IntelliJ IDEA.
  User: kyndallsims
  Date: 2019-10-30
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp">
        <h1 style="color: green;">Your add was deleted!</h1>
        <a href="/profile">Go back to profile</a>
        <a href="/home">Go back to home page</a>
    </jsp:include>
</body>
</html>