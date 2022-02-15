<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/login">Login</a></li>
            <li><a href="/register">Register</a></li>
            <li><a href="/logout">Logout</a></li>
            <li>
                <form action="/ads/search" METHOD="POST">
                    <input id="keyword" name="keyword" class="form-control" type="text">
                    <button type="submit" class="btn btn-primary btn-block" value="Search">Search</button>
                </form>
            </li>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
