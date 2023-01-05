<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/15/22
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/GuestServlet" action="post">
  <label>Choose a Number Between 1 and 3 </label>
  <input type="text" name="guess">

  </form>
  </body>
</html>
