<%--
  Created by IntelliJ IDEA.
  User: Kelvon
  Date: 6/1/21
  Time: 11:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pick Color</title>
</head>
<body>
<h1>Choose a color to turn your page to!</h1>
<form action="/viewcolor" method="POST">
<label for="pickColor">Pick a color!! </label>
<input type="text" id="pickColor" name="pickColor" required >
<button type="submit" name="submit">Submit Color</button>
</form>
</body>
</html>
