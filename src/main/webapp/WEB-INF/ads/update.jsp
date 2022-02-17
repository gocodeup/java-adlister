<%--
  Created by IntelliJ IDEA.
  User: eloysbook
  Date: 2/17/22
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/ads/update" method="post">
  <div class="form-group">
    <label for="title">Title:</label>
    <input id="title" name="title" value= ${sessionScope.ad.title} class="form-control" type="text">
  </div>
  <div class="form-group">
    <label for="description">Description:</label>
    <input id="description" name="description" value= ${sessionScope.ad.description} class="form-control" type="text">
  </div>
  <input type="submit" class="btn btn-primary btn-block">
</form>
</body>
</html>
