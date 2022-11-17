<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: casanovageary
  Date: 11/14/22
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/profile">my profile</a></li>
            <li><a href="/login">login</a></li>
            <li><a href="/register">register</a></li>
        </ul>
    </div>
    <div>
        <form class="form-inline my-2 my-lg-0" action="/ads/search" method="get">
            <input class="form-control mr-sm-2" type="search" name="title" placeholder="search for ads" aria-label="search ads">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">search</button>
        </form>
    </div>


</nav>
