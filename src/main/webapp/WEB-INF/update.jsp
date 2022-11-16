<%--
  Created by IntelliJ IDEA.
  User: juliangutierrez
  Date: 11/16/22
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile Update</title>
</head>
<body>
    <form method="post" action="/profile/update">
        <input type="hidden" name="id" value="${adToEdit.id}">
        <label for="title">Title Name :</label>
        <input type="text" id="title" name="title" value="${adToEdit.title}">
        <label for="description">Description: </label>
        <textarea name="description" id="description">${adToEdit.description}</textarea>
        <button>Submit</button>
    </form>
</body>
</html>
