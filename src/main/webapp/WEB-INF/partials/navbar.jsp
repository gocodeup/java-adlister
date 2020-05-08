<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads"><img alt="logo" src="https://www.pngitem.com/pimgs/m/95-958057_whos-that-pokemon-hd-png-download.png" height="30" width="30"/></a>


        </div>
        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <li><a href="/logout">Logout</a></li>
                    <li><a href="/create">Create new ad</a></li>
                    <li><a href="/updateprofile">Update Profile</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="/login">Login</a></li>
                    <li><a href="/register">Register</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>


