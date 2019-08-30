<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Home</a>
            <a class="navbar-brand" href="/search">Create an Ad</a>
            <c:if test="${sessionScope.user != null}">
            <a class="navbar-brand" href="/ads/create">Create an Ad</a>
        </c:if>
        </div>
        <ul class="nav navbar-nav navbar-right">
        <c:if test="${sessionScope.user == null}">
            <li><a href="/register">Register</a></li>
            <li><a href="/login">Login</a></li>
        </c:if>
        <c:if test="${sessionScope.user != null}">
            <li><a href="/logout">Logout</a></li>
        </c:if>
        </ul>
    </div>
</nav>
