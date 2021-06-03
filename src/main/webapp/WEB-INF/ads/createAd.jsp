<%--
  Created by IntelliJ IDEA.
  User: Hunter
  Date: 6/3/21
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad"/>
    </jsp:include>

</head>
<body>
<div class="container">
    <h1> Create a new Ad</h1>

    <form action="/ads/create" method="POST">
        <!-- div for title -->
        <div class="form">
            <label for="title">Title</label>
            <input id="title" name="title" type="text">
        </div>
        <!-- div for description -->
        <div class="form">
            <label for="description">Description</label>
            <textarea id="description" name="description" type="text"></textarea>
        </div>

        <!-- submit button -->
        <input type="submit">
    </form>
</div>

</body>
</html>
