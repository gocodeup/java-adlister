
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous">
</script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"  href="${pageContext.request.contextPath}/css/mainNav.css">
<%--<link rel="stylesheet" href="/css/mainNav.css">--%>



<%--ND--%>
<nav id="mainNav" class="navbar navbar-expand-lg red-hover" >
    <div class="container-fluid">
<%--        <img src="<c:url value="/img/adlister.png"/>" class="d-inline-block align-top" alt=""  width="20px" height="24px" />--%>

        <!-- Brand and toggle get grouped for better mobile display -->
<%--        <a class="navbar-brand w-text" href="#">logo</a>--%>
<%--        <img src="/img/adlister.png" alt="" style="max-width: 60px; max-height: 64px" >--%>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
                aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

<%--        <div class="collapse navbar-header">--%>
<%--            <a class="navbar-brand" href="/ads">Adlister</a>--%>
<%--        </div>--%>

        <div class="collapse navbar-collapse" id="navbarText">
            <%--        <ul class="nav navbar-nav navbar-right">--%>
            <ul class="navbar-nav mr-auto"  >
                <li class="nav-item active">
                    <a class="nav-link red-hover w-text" href="/">
                        <i class="fa fa-fw fa-home"></i> Home <span class="sr-only">(current)</span></a>
                </li>
            </ul>
            <span class="navbar-text">
                <ul class="navbar-nav mr-auto">
                    <form class="form-inline my-2 my-lg-0" action="/searchAds" method="POST">
                             <%--      <input class="btn btn-outline-danger my 2 my-sm-0" type="submit">--%>
                            <input class="form-control mr-sm-2" name="keyword" type="search" placeholder="Search for ad" aria-label="Search">
<%--                                                <a href="/searchAds"></a>--%>
<%--                          <input class="btn btn-outline-danger my-2 my-sm-0" type="submit">--%>
<%--                                 <a href="/searchAds"></a> --%>
                    </form>

                    <c:choose>
                        <c:when test="${sessionScope.user != null}">
                            <li class="nav-item active">
                                <a class="nav-link red-hover w-text" href="/ads/create">
                                    <i class="fab fa-buysell"></i> Create Ad <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link red-hover w-text" href="/logout">
                                    <i class="fas fa-logout-alt"></i> LOGOUT <span class="sr-only">(current)</span>
                                </a>
                            </li>
                            <li class="nav-item active" >
                                <a class="nav-link red-hover w-text" href="/profile">
                                    <i class="fa fa-fw fa-user"></i> Profile <span class="sr-only">(current)</span> </a>
                            </li>
                        </ul>
                        </c:when>
                        <c:otherwise>
<%--                            <ul>--%>
<%--                            <li class="nav-item active" style="align-self: flex-end">--%>
<%--                                <a class="nav-link red-hover w-text" href="/login">--%>
<%--                                    <i class="fa fa-edit"></i> Login <span class="sr-only">(current)</span></a>--%>
<%--                            </li>--%>
<%--                            </ul>--%>
<%--            <li class="nav-item active">--%>
<%--                <a class="nav-link red-hover w-text" href="/register">--%>
<%--                    <i class="fa fa-list" aria-hidden="true"> Register <span class="sr-only">(current)</span>--%>
<%--                </i></a>--%>
<%--            </li>--%>
                            <ul class="navbar-nav ms-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown" aria-expanded="false">Account</a>
                        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/login">Login</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/register">Register</a></li>
                        </ul>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </span>
        </div><!-- /.navbar-collapse -->
        <div id="content"></div>
    </div><!-- /.container-fluid -->
<%--    <div class="navbar-right">--%>
<%--        <ul class="nav navbar-nav navbar-right">--%>
<%--            <li><a href="/login">Login</a></li>--%>
<%--            <li><a href="/logout">Logout</a></li>--%>
<%--        </ul>--%>
<%--    </div>--%>
</nav>
