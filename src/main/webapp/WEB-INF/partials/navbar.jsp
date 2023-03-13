<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.codeup.adlister.models.User" %>
<%--<nav class="navbar navbar-default">--%>
<%--    <div class="container-fluid">--%>
<%--        <!-- Brand and toggle get grouped for better mobile display -->--%>
<%--        <div class="navbar-header">--%>
<%--            <a class="navbar-brand" href="${pageContext.request.contextPath}<c:url value="/ads"/>">Adlister</a>--%>
<%--            <ul>--%>
<%--                <form action="/ads/search" method="GET">--%>
<%--                    <input id="s" name="s" type="search" placeholder="Search Ads..." aria-label="Search">--%>
<%--                    <button class="btn btn-outline-success" type="submit" >Search</button>--%>
<%--                </form>--%>
<%--            </ul>--%>


<%--        </div>--%>
<%--        <ul class="nav navbar-nav navbar-right">--%>
<%--            <% User user = (User) session.getAttribute("user");--%>
<%--            if (user == null) {--%>
<%--            %>--%>

<%--            <li><a class="navbar-brand" href="${pageContext.request.contextPath}<c:url value="/ads/create"/>">Create an Ad</a></li>--%>
<%--            <li><a href="${pageContext.request.contextPath}<c:url value="/register"/>">Register</a></li>--%>
<%--            <li><a href="${pageContext.request.contextPath}<c:url value="/login"/>">Login</a></li>--%>
<%--            <%--%>
<%--            }else{--%>
<%--            %>--%>
<%--            <li><a class="navbar-brand" href="${pageContext.request.contextPath}<c:url value="/ads/create"/>">Create an Ad</a></li>--%>
<%--            <li><a href="${pageContext.request.contextPath}<c:url value="/profile"/>"><i class="fa-solid fa-user"></i> Profile</a></li>--%>
<%--            <li><a href="${pageContext.request.contextPath}<c:url value="/logout"/>"><i class="fa-solid fa-right-from-bracket"></i> Logout</a></li>--%>
<%--            <%--%>
<%--                }--%>
<%--            %>--%>
<%--        </ul>--%>
<%--    </div><!-- /.navbar-collapse -->--%>
<%--    </div><!-- /.container-fluid -->--%>
<%--</nav>--%>

<nav class="navbar navbar-expand-lg navbar-light bg-dark">
    <div class="container-fluid">

        <a class="navbar-brand" href="${pageContext.request.contextPath}<c:url value="/ads"/>">
            <div class="logo-image">
                <img src="https://iili.io/HG2k5Mu.png" class="img-fluid">
                UFO-Lister
            </div></a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 mt-2">
                <form class="d-flex" action="/ads/search" method="GET">
                    <input id="s" class="form-control me-2" name="s" type="search" placeholder="Search Ads..." aria-label="Search">
                    <button class="btn search-btn" type="submit" >Search</button>
                </form>
            </ul>

            <ul class="nav">
                <% User user = (User) session.getAttribute("user");
                    if (user == null) {
                %>

                <li><a class="nav-txt active" href="${pageContext.request.contextPath}<c:url value="/ads/create"/>">Create a Listing</a></li>
                <li><a class="nav-txt active" href="${pageContext.request.contextPath}<c:url value="/register"/>">Register</a></li>
                <li><a class="nav-txt active" href="${pageContext.request.contextPath}<c:url value="/login"/>">Login</a></li>
                <%
                }else{
                %>
                <li><a class="nav-txt active" href="${pageContext.request.contextPath}<c:url value="/ads/create"/>">Create a Listing</a></li>
                <li><a class="nav-txt active" href="${pageContext.request.contextPath}<c:url value="/profile"/>"><i class="fa-solid fa-user"></i> Profile</a></li>
                <li><a class="nav-txt active" href="${pageContext.request.contextPath}<c:url value="/logout"/>"><i class="fa-solid fa-right-from-bracket"></i> Logout</a></li>
                <%
                    }
                %>
            </ul>

            <!--            <a class="nav-link active" aria-current="page" href="#">Create a Listing</a>-->
            <!--            <a class="nav-link" href="#">Register</a>-->
            <!--            <a class="nav-link" href="#">Login</a>-->
            <!--            <ul class="navbar-nav me-auto mb-2 mb-lg-0">-->
            <!--                <li class="nav-item">-->
            <!--                    <a class="nav-link" href="#">Link</a>-->
            <!--                </li>-->
            <!--                <li class="nav-item">-->
            <!--                    <a class="nav-link" href="#">Link</a>-->
            <!--                </li>-->
            <!--            </ul>-->
        </div>
    </div>
</nav>

<%--Bootstrap JS--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<%--Fontawesome JS--%>
<script src="https://kit.fontawesome.com/cc15ef4101.js" crossorigin="anonymous"></script>
