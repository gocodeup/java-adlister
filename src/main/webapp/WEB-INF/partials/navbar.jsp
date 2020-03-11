<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-dark bg-dark navbar-expand-sm blue">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-list-2" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbar-list-2">
        <ul class="navbar-nav">
            <c:choose>
                <c:when test="${sessionScope.user != null}">
                    <li class="nav-item"><a href="/logout" class="nav-link">Logout</a></li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/ads/create">create ad</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item"><a href="/login" class="nav-link">Login</a></li>
                    <li class="nav-item"><a class="nav-link" href="/register">Register</a></li>
                </c:otherwise>
            </c:choose>
            <li class="nav-item"><a class="nav-link" href="/ads">Ads</a></li>
        </ul>
    </div>
</nav>


