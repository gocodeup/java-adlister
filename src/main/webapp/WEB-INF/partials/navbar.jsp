<nav class="navbar navbar-default bg-light">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <form action="/search" method="POST" class="form-inline my-2 my-sm-0">
            <a class="navbar-brand text-dark ml-1" href="/ads">Adlister</a>
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"
                       name="query" id="query">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>

                <div class="input-group">
                    <div class="input-group-prepend">
                        <div class="input-group-text bg-light" style="border: none">
                            <input type="radio" name="choice" value="title" checked>
                            <span class="ml-1">Title Search</span>
                        </div>
                        <div class="input-group-text bg-light" style="border:none">
                            <input type="radio" name="choice" value="category">
                            <span class="ml-1">Category Search</span>
                        </div>
                    </div>
                </div>

            </form>
        </div>
        <!--FIX TRANSITION BETWEEN SMALL AND MEDIUM SCREENS FOR BELOW LATER -->
        <div class="">
        <ul class="nav navbar-nav navbar-right d-flex flex-row">
            <% if (request.getSession().getAttribute("user") != null) { %>
            <li><a class="text-dark ml-0 mr-2" href="ads/create">Create an Ad</a></li>
            <li ><a class = "text-dark ml-0 mr-2" href = "/profile" > Profile </a ></li >
            <li ><a class = "text-dark ml-1" href = "/logout" > Logout </a ></li >
            <% } else { %>
            <li ><a class = "text-dark ml-0 mr-2" href = "/login" > Login </a ></li >
            <li ><a class = "text-dark ml-1" href = "/register" > Register </a ></li>
            <% } %>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
