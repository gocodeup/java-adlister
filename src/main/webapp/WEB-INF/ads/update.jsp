<%--
  Created by IntelliJ IDEA.
  User: vicente
  Date: 11/14/22
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Update Your Ad" />
  </jsp:include>
</head>
<body>
  <div class="container">
    <h1>Edit Your Ad</h1>
    <form action="/ads/update" method="POST">
      <div class="form-group">
        <label for="title">Title</label>
        <input id="title" name="title" class="form-control" type="text" required>
      </div>
      <div class="form-group">
        <label for="description">Description</label>
        <textarea id="description" name="description" class="form-control" type="text" required></textarea>
      </div>
      <input type="submit" class="btn btn-block btn-primary" value="Update Ad">
    </form>
  </div>
</body>
</html>
