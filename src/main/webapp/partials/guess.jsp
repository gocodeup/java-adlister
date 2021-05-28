<%--
  Created by IntelliJ IDEA.
  User: Kelvon
  Date: 5/28/21
  Time: 12:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Guessing Game</title>
</head>
<body>
<h1>Welcome to the guessing game !!</h1>
<p>In this game you will guess a number between 1 and 3! Please submit your answer below in the text field!</p>
<form action="/guess" method="post">
    <div class="container">
        <label for="guess"></label>
        <input type="text" id="guess" name="guess" required >
    </div>
    <div><button type="submit">Submit Guess</button></div>




</form>
</body>
</html>
