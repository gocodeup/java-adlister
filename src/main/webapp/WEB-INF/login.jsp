<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div id="formAlert" class="alert alert-warning hide collapse" role="alert">
        <a class="close" data-dismiss="alert">×</a>
        <strong>Warning!</strong> Cannot login without credentials.
    </div>

    <div class="container">
        <h1>Please Log In</h1>

        <form name="username" action="/login" method="POST">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
          
            <input id="btn" type="submit" class="btn btn-primary btn-block" value="Log In">
        </form>
    </div>

    <div class="container">
    <form action="/register">
        <div class="form-group">
        <input type="submit" class="btn btn-success btn-block" value="Create an account">
        </div>
    </form>
    </div>

    <script>

        $(document).ready(function () {


            $('form[name="username"]').on("submit", function (e) {

                var username = $(this).find('input[name="username"]');
                if ($.trim(username.val()) === "") {
                    e.preventDefault();
                    $("#formAlert").slideDown(400);
                }else var password =$(this).find('input[name="password"]');
                if ($.trim(password.val()) === "") {
                    e.preventDefault();
                    $("#formAlert").slideDown(400);
                }

            });

            $(".alert").find(".close").on("click", function (e) {
                e.stopPropagation();
                e.preventDefault();
                $(this).closest(".alert").slideUp(400);
            });

            $('#btn').click(function () {
                setTimeout(function () {
                    $('#formAlert').hide('fade');
                }, 2000);
            });

        });


    </script>
</body>
</html>
