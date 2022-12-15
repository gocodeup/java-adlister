
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/14/22
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
  <form action="/login.jsp" method="post">
        <div class="container">

            <label>Username : </label>
            <input type="text" placeholder="Enter Username" name="username" required>


            <label>Password : </label>
            <input type="password" placeholder="Enter Password" name="password">
            <button type="submit">Login</button>

<%
                if (request.getMethod().equalsIgnoreCase("POST")) {
                    String name = request.getParameter("username");
                    String password = request.getParameter("password");
                    if (name.equals("admin") && password.equals("password")) {
                    response.sendRedirect("/profile.jsp");
                    }
                }
            %>
        </div>
    </form>


  </body>
</html>
