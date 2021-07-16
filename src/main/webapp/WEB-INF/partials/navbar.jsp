<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    boolean isNotLoggedIn;
    if (request.getSession().getAttribute("user") == null) {
        isNotLoggedIn = true;
    } else {
        isNotLoggedIn = false;
    }
%>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
            <form action="/searchAds" method="post">
                <input type="text" id="search" name="search">
                <input type="submit" value="Search Ads">
            </form>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <c:when test="<%=isNotLoggedIn%>">
                    <li><a href="/login">Login</a></li>
                    <li><a href="/register">Register</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="/ads/create">Create Ad</a></li>
                    <li><a href="/profile">View Profile</a></li>
                    <li><a href="/logout">Logout</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
