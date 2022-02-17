<%--
  Created by IntelliJ IDEA.
  User: eloysbook
  Date: 2/17/22
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>${sessionScope.ad.title}</h1>
<p>${sessionScope.ad.description}</p>

<form action="/ads/delete" method="post">
  <label for="submit">Are you sure you want to delete this ad?</label>
  <input type="submit" name="submit" id="submit" value="Delete">
</form>

</body>
</html>
