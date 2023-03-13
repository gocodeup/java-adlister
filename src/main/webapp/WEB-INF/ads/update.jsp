<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.codeup.adlister.models.User" %>
<%@ page import="com.codeup.adlister.models.Ad" %>
<%@ page import="com.codeup.adlister.dao.DaoFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Ad</title>
    <jsp:include page="/WEB-INF/partials/head.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1 class="card-txt">Update Ad</h1>
    <form action="/ads/update" method="post">
        <div class="form-group">
            <label class="card-txt" for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text" value="${ad.title}">
        </div>
        <div class="form-group">
            <label  class="card-txt" for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text"  >${ad.description}</textarea>
        </div>
        <div class="form-group" hidden>
            <label for="adId">adId</label>
            <input id="adId" name="adId" class="form-control" type="text" value="${ad.id}">
        </div>
        <input type="submit" name="editButton" class="btn card-btn">
    </form>
    </form>
    <form action="/ads/update" method="post">
        <div class="form-group" hidden>
            <label for="adId">adId</label>
            <input id="adIdDelete" name="adId" class="form-control" type="text" value="${ad.id}">
        </div>
        <button class="btn delete-btn" type="submit" name="delete-ad" onclick="return confirm('This will delete your ad, are you sure?')" >Delete Ad</button>

    </form>
</div>
</body>
</html>