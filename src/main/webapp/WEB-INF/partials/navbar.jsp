<%@ page import="com.codeup.adlister.models.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
  <% User user = (User) session.getAttribute("user");
    boolean loggedIn = user != null;
  %>

  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <a class="navbar-brand" href="/ads">Adlister</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <c:choose>
        <c:when test="<%=loggedIn%>">
          <li><a href="/logout">Logout</a></li>
        </c:when>
        <c:otherwise>
          <li><a href="/login">Login</a></li>
        </c:otherwise>
      </c:choose>
    </ul>
  </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
