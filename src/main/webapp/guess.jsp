<%--
  Created by IntelliJ IDEA.
  User: Hunter
  Date: 5/28/21
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="the-guess-outcome.jsp"%>

<form action="guessgame.jsp" name="POST">
    <label>Guess a number between 1 and 3! </label>
    <input type="text" placeholder="Number goes here!" required >

    <button type="submit">See if you're right!</button>
</body>
</html>
