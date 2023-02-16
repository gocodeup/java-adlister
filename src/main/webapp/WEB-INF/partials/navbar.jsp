
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg bg-light bgt">
    <div class="container-fluid">
        <a class="navbar-brand" href="/ads">Adlister</a>
        <div class="navbar" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <c:choose>
                    <c:when test="${sessionScope['user'] != null}">
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/profile">View Profile</a></li>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a></li>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/ads/create">Create Ads</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a></li>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/register">Register</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
            <form class="d-flex" role="search" method="post" action="/">
                <button class="btn btn-outline-success" type="button">Filter</button>
            </form>
        </div>
    </div>
</nav>


