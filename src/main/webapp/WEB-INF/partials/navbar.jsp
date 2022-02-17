<%--addded taglib and JSP Directives--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--New  Dynamic Navbar--%>
<%--on main page--%>
<c:if test="${sessionScope.user == null}">
    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #EEEEEE;">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <a class="navbar-brand" href="/ads">Adlister</a>
            </div>
            <ul class="nav navbar-nav navbar-right">
<%--                added link to all ads--%>
                <li><a class="nav-link" href="/ads">View All Ads</a></li>

                <li><a class="nav-link" href="/login">Login</a></li>
<%--                    <li><a href="/logout">Logout</a></li>--%>
                <li><a class="nav-link" href="/register">Register</a></li>

            </ul>
        </div><!-- /.navbar-collapse -->
        <!-- /.container-fluid -->
    </nav>
</c:if>

<%--after user logged in/ on user profile--%>
<c:if test="${sessionScope.user != null}">
    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #EEEEEE;">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <a class="navbar-brand" href="/">Adlister</a>

            </div>
            <ul class="nav navbar-nav align-end">

                <li class="search-form"><form class="form-inline " action="/ads/search" METHOD="POST">
                    <input id="title" name="keyword" class="form-control mr-sm-2" type="text" placeholder="Search on Adlister">
                    <button type="submit" class="btn btn-outline-secondary my-2 my-sm-0" value="Search">Go</button>
                </form>
                </li>
 <%--                        <li><a href="/register">Register</a></li>--%>
                <li><a class="nav-link" href="/ads/create">Create Ad</a></li>

<%--                        added link to all ads--%>
                <li><a class="nav-link" href="/ads">View All Ads</a></li>

<%--                        <li><a href="/login">Login</a></li>--%>
                        <li><a class="nav-link" href="/logout">Logout</a></li>

<%--                <li>--%>
<%--                    <form action="/ads/search" METHOD="POST">--%>
<%--                        <input id="title" name="keyword" class="form-control" type="text" placeholder="Search on Adlister">--%>
<%--                        <button type="submit" class="btn btn-dark btn-block" value="Search">Search</button>--%>
<%--                    </form>--%>
<%--                </li>--%>
            </ul>
        </div><!-- /.navbar-collapse -->
        <!-- /.container-fluid -->
    </nav>
</c:if>