<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: boryanadimova
  Date: 6/14/22
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<form action="/profile" method="GET">
    Profile
</form>
<c:if test="true">
    <h1>Profile</h1>
</c:if>
<c:if test="false">
    <h1>single letter variable names are good</h1>
</c:if>
</body>
</html>
