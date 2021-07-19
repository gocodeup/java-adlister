<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <%--LOGO directing to ads page (change it to home page) -K --%>
            <a class="navbar-brand" style="font-size: 24px; margin-top: 0.3em" href="/ads">Adlister<i
                    class="fas fa-network-wired"></i></a>
        </div>
        <div>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <%--      for visitor/user view   add a search bar for searching through ads--%>
                    <%--      need help centering search bar + adding dropdown              --%>
                    <form action="/search"
                          style="display: flex; justify-content: center; align-content: center; margin-top: 0.5em;"
                          class="form-inline" method="GET">
                        <input id="s" name="s" class="form-control" type="search" placeholder="Search Ads..."
                               aria-label="Search" style="font-family: comic sans ms">
                        <button style="color: white; font-family: comic sans ms; background-color: black"
                                class="btn btn-dark" type="submit">Search<i class="fas fa-search"></i></button>
                    </form>
                    <%--        IF USER profile, logout, create ad links -K--%>
                    <%--        IF VISITOR login & register links -K--%>
                    <c:choose>
                    <c:when test="${sessionScope['user'] != null}">
                <li><a href="/ads">View All Ads</a></li>
                <li><a href="${pageContext.request.contextPath}/profile">View Profile</a></li>
                <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                <li><a href="${pageContext.request.contextPath}/ads/create">Create Ads</a></li>

                </c:when>
                <c:otherwise>
                    <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
                    <li><a href="${pageContext.request.contextPath}/register">Register</a></li>
                </c:otherwise>
                </c:choose>
                </li
            </ul>
        </div>
    </div><!-- /.navbar-collapse -->
</nav>