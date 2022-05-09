<head>
    <title>Navbar</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>


<header>

    <nav class="navbar navbar-light bg-light">
        <a class="navbar-brand d-flex flex-column justify-content-center" href="#">SA Lister</a>
        <div class="container d-flex flex-row justify-content-end">
            <button class="nav-item bg-light border border-0">
                <a class="nav-link" href="/ads">Ads</a>
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
            <div class="offcanvas-body">
                <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">

                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/profile">Home</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="/login">Login</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</header>
<%--    <nav class="navbar navbar-default">--%>
<%--        <div class="container-fluid">--%>
<%--            <!-- Brand and toggle get grouped for better mobile display -->--%>
<%--            <div class="navbar-header">--%>
<%--                <a class="navbar-brand" href="/ads">Adlister</a>--%>
<%--            </div>--%>
<%--            <ul class="nav navbar-nav navbar-right">--%>
<%--                <li><a href="/ads" >Ads</a></li>--%>
<%--                <li><a href="/login">Login</a></li>--%>
<%--                <li><a href="/logout">Logout</a></li>--%>
<%--            </ul>--%>

<%--        </div><!-- /.navbar-collapse -->--%>
<%--        </div><!-- /.container-fluid -->--%>
<%--    </nav>--%>
