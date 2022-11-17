<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand link-dark" href="/ads">Adlister</a>
        </div>
        <form action="/ads" method="post" class="w-75 pt-1 m-0">
            <div class="form-group w-50 d-flex">
                <input id="search" name="search" class="form-control" type="text" placeholder="Search Ads">
                <button type="submit" class="btn btn-dark">Submit</button>
            </div>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/ads/create" class="link-dark me-3">Create Ad</a></li>
            <li><a href="/login" class="link-dark">Profile</a></li>
        </ul>

    </div><!-- /.navbar-collapse -->

    </div><!-- /.container-fluid -->

</nav>
