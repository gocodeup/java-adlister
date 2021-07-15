<!-- Bootstrap CSS -->
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>
<!-- Font Awesome CSS -->
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
<!-- jQuery -->
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<!-- Bootstrap JS -->
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>

<nav class="navbar navbar-default navbar-inverse" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/ads">DreamTeam</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            <form class="navbar-form navbar-left" role="search" action="/search" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search" name="query">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <%--            Create an Ad and View my Profile buttons   --%>
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Where Dreams are Made <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li><a href="${pageContext.request.contextPath}/ads/create">Create an Ad</a></li>
                <li><a href="${pageContext.request.contextPath}/profile">View my profile</a></li>
                <li class="divider"></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><p class="navbar-text"></p></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Menu</b> <span
                            class="caret"></span></a>
                    <ul id="login-dp" class="dropdown-menu">
                        <li>
                            <div class="row">
                                <div class="col-md-12">
                                    <ul class="nav navbar-nav navbar-right">
                                        <%
                                            if (request.getSession().getAttribute("user") != null) {
                                        %>
                                        <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                                        <%
                                        } else {
                                        %>
                                        <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
                                        <%
                                            }
                                        %>

                                    </ul>
                                    <%--                                    <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">--%>
                                    <%--                                        <div class="form-group">--%>
                                    <%--                                            <label class="sr-only" for="exampleInputEmail2">Email address</label>--%>
                                    <%--                                            <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Email address" required>--%>
                                    <%--                                        </div>--%>
                                    <%--                                        <div class="form-group">--%>
                                    <%--                                            <label class="sr-only" for="exampleInputPassword2">Password</label>--%>
                                    <%--                                            <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password" required>--%>
                                    <%--                                        </div>--%>
                                    <%--                                    </form>--%>
                                </div>
                                <div class="bottom text-center">
                                    New here ? <a href="${pageContext.request.contextPath}/register">Join Us</a>
                                </div>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>


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
