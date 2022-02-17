
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous">
</script>

<nav id="mainNav" class="navbar navbar-expand-lg red-hover">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
<%--        <a class="navbar-brand w-text" href="#">logo</a>--%>
<%--        <img src="../../img/adlister.png" alt="" style="max-width: 20px; max-height: 24px" >  --%>
        <img src="<c:url value="/img/adlister.png"/>" alt=""  width="20px" height="24px">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
                aria-controls="navbarText" aria-expanded="false" aria-label="Toggle nav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <div class="collapse navbar-collapse" id="navbartext">
<%--        <ul class="nav navbar-nav navbar-right">--%>
           <ul class="navbar-mr-auto" style=" list-style: none"  >
                <li class="nav-item active">
                   <a class="nav-link red-hover w-text" href="/home">
                       <i class="fa fa-fw fa-home"></i> Home <span class="sr-only">(current)</span></a>
                </li>
           </ul>
            <span class="navbar-text">
                <ul class="navbar-nav mr-auto">
            <form class="form-inline my-2 my-lg-0" action="/searchAds" method="POST">
<%--                        <input class="btn btn-outline-danger my 2 my-sm-0" type="submit">--%>
                 <div>
                     <input type="text" id="twotabsearchtextbox"  class="searchSelect"
                                name="field-keywords" value="" size="50"
                                title="Search for" style="width:50%; background-color: #FFF;" />
                            <span class=lsbb><input name=button type=submit value="Search" ></span>
                 </div>
                    <a href="/searchAds"></a>
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
        </c:when>
        <c:otherwise>
            <li class="nav-item active">
                <a class="nav-link red-hover w-text" href="/login">
                    <i class="fa fa-edit"></i> Login to go in.<span class="sr-only">(current)</span></a>
            </li>
<%--            <li class="nav-item active">--%>
<%--                <a class="nav-link red-hover w-text" href="/register">--%>
<%--                    <i class="fa fa-list" aria-hidden="true"> Register <span class="sr-only">(current)</span>--%>
<%--                </i></a>--%>
<%--            </li>--%>
        </c:otherwise>
    </c:choose>
                </ul>
            </span>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
<%--    <div class="navbar-right">--%>
<%--        <ul class="nav navbar-nav navbar-right">--%>
<%--            <li><a href="/login">Login</a></li>--%>
<%--            <li><a href="/logout">Logout</a></li>--%>
<%--        </ul>--%>
<%--    </div>--%>
</nav>
