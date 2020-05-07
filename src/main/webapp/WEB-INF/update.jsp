<%--
  Created by IntelliJ IDEA.
  User: gdev
  Date: 5/6/20
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Update Ad"/>
</jsp:include>
<html>
<head>
    <title>Update Your Ad or Profile Data</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<h2>Update an Ad You Posted:</h2>
<br>
<form method="POST" action="/update">
    <input type="hidden" name="updateAd" value="${ad.id}"/>

    <label>Title: </label>
    <input type="text" name="adName" value="${ad.name}"/>
    <br>
    <br>

    <label>Description:</label>
    <input type="text" name="adDescription" value="${ad.description}"/>
    <br>
    <br>

    <button type="submit" class="ui-button">Update Ad</button>
</form>
<br>

<h2>Update your User Info:</h2>
<br>
<div id="userProfileUpdateForm">
    <form method="POST" action="/update">
        <input type="hidden" name="updateprofile" value="${profile.id}"/>

        <label>Change Username</label>
        <input type="text" name="edit_username" value="${user.username}"/>
        <br>

        <label>Change Email</label>
        <input type="text" name="email" value="${user.email}"/>
        <br>

        <label>Change Password</label>
        <input type="text" name="password" value="${user.password}">
        <br>
        <button type="submit" class="ui-button">Update User Profile</button>
    </form>
</div>
</body>
</html>
