<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>

    <title>Navbar</title>
<%--    icons--%>
    <script src="https://kit.fontawesome.com/5c1e7c5892.js" crossorigin="anonymous"></script>
<%--    bootstrap--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


</head>
<header>

    <nav class="navbar navbar-light bg-light ">
        <div class="container d-flex justify-content-start">
            <a class="navbar-brand d-flex flex-column justify-content-center" ><h2>SA Lister</h2></a>
            <div class="mt-4 mx-3">
<%--                        searchbar--%>
                <form action="/search" method="GET">
                    <label for="search" class="form-label text-style ">Search Ads</label>
                    <input type="text" name="search" placeholder="Enter keyword" id="search" class="">
                    <input id="submit" type="submit" value="search" class="btn-outline-primary">
                </form>
            </div>
<%--        </div>--%>

        <c:choose>
        <c:when test="${sessionScope.user != null}">
        <button class="nav-item bg-light border border-0">
            <a class="nav-link" href="/ads/create">Create Add</a>
        </button>
        </c:when>
        </c:choose>

        <div class="d-flex ms-auto">
            <button class="nav-item bg-light border border-0 ">
                <a class="nav-link" href="/ads"><h2>Ads</h2></a>
            </button>
            <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>

        <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
            <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasNavbarLabel">${sessionScope.user.username} Account</h5>
                <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>

            <div class="offcanvas-body d-flex justify-content-center">
                <ul class="navbar-nav flex-grow-1 pe-3 mx-4">
                    <c:choose>
                    <c:when test="${sessionScope.user != null}">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/profile">Home</a>
                    </li>
                    </c:when>
                    </c:choose>

                    <c:choose>
                    <c:when test="${sessionScope.user == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="/login">Login</a>
                    </li>
                    </c:when>
                    </c:choose>

                    <c:choose>
                    <c:when test="${sessionScope.user != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Logout</a>
                    </li>
                    </c:when>
                    </c:choose>

                    <c:choose>
                    <c:when test="${sessionScope.user == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="/register">Create Account</a>
                    </li>
                    </c:when>
                    </c:choose>
                </ul>
            </div>
        </div>
        </div>
    </nav>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</header>