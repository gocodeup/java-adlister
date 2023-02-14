<%--<nav class="navbar navbar-default">--%>
<%--    <div class="container-fluid">--%>
<%--        <!-- Brand and toggle get grouped for better mobile display -->--%>
<%--        <div class="navbar-header">--%>
<%--            <a class="navbar-brand" href="/ads">Adlister</a>--%>
<%--        </div>--%>
<%--        <ul class="nav navbar-nav navbar-right">--%>
<%--            <li><a href="/login">Login</a></li>--%>
<%--            <li><a href="/logout">Logout</a></li>--%>
<%--        </ul>--%>
<%--    </div><!-- /.navbar-collapse -->--%>
<%--    </div><!-- /.container-fluid -->--%>
<%--</nav>--%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<script src="https://kit.fontawesome.com/da30200d10.js" crossorigin="anonymous"></script>--%>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Navbar header -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <div class="navbar">
            <a href="#home">Home</a>
            <a href="#news">News</a>
            <div class="dropdown">
                <button class="dropbtn">Dropdown
                    <i class="fa fa-caret-down"></i>
                </button>
                <div class="dropdown-content">
                    <div class="header">
                        <h2>Mega Menu</h2>
                    </div>
                    <div class="row">
                        <div class="column">
                            <h3>Category 1</h3>
                            <a href="#">Link 1</a>
                            <a href="#">Link 2</a>
                            <a href="#">Link 3</a>
                        </div>
                        <div class="column">
                            <h3>Category 2</h3>
                            <a href="#">Link 1</a>
                            <a href="#">Link 2</a>
                            <a href="#">Link 3</a>
                        </div>
                        <div class="column">
                            <h3>Category 3</h3>
                            <a href="#">Link 1</a>
                            <a href="#">Link 2</a>
                            <a href="#">Link 3</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <%--      for visitor/user view   add a search bar for searching through ads--%>
                    <%--      need help centering search bar + adding dropdown              --%>
                    <form action="/ads" class="" method="GET">
                        <input class="form-control" type="search" placeholder="Search Ads..." aria-label="Search">
                        <button class="btn btn-outline-success" type="submit"><i class=""></i></button>
                    </form>
                </li>
                <%--        IF USER profile, logout, create ad links --%>
                <%--        IF VISITOR login & register links --%>
                <c:choose>
                    <c:when test="${sessionScope['user'] != null}">
                        <li><a href="${pageContext.request.contextPath}/profile">View Profile</a></li>
                        <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                        <li><a href="${pageContext.request.contextPath}/ads/create">Create Ads</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
                        <li><a href="${pageContext.request.contextPath}/register">Register</a></li>
                    </c:otherwise>
                </c:choose>

            </ul>
        </div>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->

</nav>
