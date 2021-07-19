<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <h1>Please fill in your information.</h1>
        <form name="loginForm" action="/register" method="post">
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
                <label for="confirmPassword">Confirm Password</label>
                <input id="confirmPassword" name="confirmPassword" class="form-control" type="password">
            </div>
            <input type="submit" class="btn btn-primary btn-block" onclick="return passwordsMatch();">
        </form>
    </div>
<script>
    function passwordsMatch() {
        pw1 = document.loginForm.password.value;
        pw2 = document.loginForm.confirmPassword.value;
        if (pw1 == "" || pw2 == "") {
            alert("Please enter a password")
        } else if (pw1 !== pw2) {
            alert("Passwords Do Not Match. Please Try Again")
        }
    }
</script>
</body>
</html>
