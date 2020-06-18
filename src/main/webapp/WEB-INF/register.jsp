<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />

    <div id="formUserAlert" class="alert alert-dark hide collapse " role="alert">
        <a class="close" data-dismiss="alert">×</a>
        <strong>Error!</strong> Please make sure you create a cool username (: .
    </div>

    <div id="formEmailWarning" class="alert alert-warning hide collapse " role="alert">
        <a class="close" data-dismiss="alert">×</a>
        <strong>Error!</strong> Email is needed for user creation!
    </div>

    <div id="formPasswordAlert" class="alert alert-danger hide collapse " role="alert">
        <a class="close" data-dismiss="alert">×</a>
        <strong>Error!</strong> You need a password or you will get hacked!
    </div>

    <div id="formConfirmPwAlert" class="alert alert-danger hide collapse " role="alert">
        <a class="close" data-dismiss="alert">×</a>
        <strong>Error!</strong> Your passwords don't match silly.
    </div>






    <div class="container">
        <h1>Please fill in your information.</h1>

        <form name="username" action="/register" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <div class="form-group">
                <label for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control" type="password">
            </div>
            <input id="btn" type="submit" class="btn btn-primary btn-block">
        </form>
    </div>

    <script>

        $(document).ready(function () {


            $('form[name="username"]').on("submit", function (e) {

                var username = $(this).find('input[name="username"]');
                if ($.trim(username.val()) === "") {
                    e.preventDefault();
                    $("#formUserAlert").slideDown(400);

                }else var email =$(this).find('input[name="email"]');
                if ($.trim(email.val()) === "") {
                    e.preventDefault();
                    $("#formEmailWarning").slideDown(400);

                }else var password =$(this).find('input[name="password"]');
                if ($.trim(password.val()) === ""){
                    e.preventDefault();
                    $("#formPasswordAlert").slideDown(400);

                }else var confirm_password =$(this).find('input[name="confirm_password"]');
                if ($.trim(confirm_password.val()) === "") {
                    e.preventDefault();
                    $("#formConfirmPwAlert").slideDown(400);

                }else var confirm_password =$(this).find('input[name="confirm_password"]');
                if ($.trim(confirm_password.val()) !== (password.val())) {
                    e.preventDefault();
                    $("#formConfirmPwAlert").slideDown(400);
                }

            });

            $('#btn').click(function () {
                setTimeout(function () {
                    $('#formUserAlert').hide('fade');
                }, 2000);
            });

            $('#btn').click(function () {
                setTimeout(function () {
                    $('#formEmailWarning').hide('fade');
                }, 2000);
            });

            $('#btn').click(function () {
                setTimeout(function () {
                    $('#formPasswordAlert').hide('fade');
                }, 2000);
            });

            $('#btn').click(function () {
                setTimeout(function () {
                    $('#formConfirmPwAlert').hide('fade');
                }, 2000);
            });



            $(".alert").find(".close").on("click", function (e) {
                e.stopPropagation();
                e.preventDefault();
                $(this).closest(".alert").slideUp(400);
            });


        });
    </script>
</body>
</html>
