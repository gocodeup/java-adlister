<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>

</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    
    <div class="container">
        <h1>Please Log In</h1>
        <form name="loginForm" action="/login" method="POST">
            <div class="form-group">
                <div>${invalidUserMessage}</div>
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <input type="submit" class="btn btn-primary btn-block" onclick="return validate(); " value="Log In">
        </form>
    </div>
<script>

    function validate() {
        const username = document.loginForm.username.value;
        const password = document.loginForm.password.value;

        if (username == "") {
            alert("Please enter a username");
            document.loginForm.password.focus();
            return false;
        }

        if (password == "") {
            alert("Please Enter A Password");
            document.loginForm.password.focus();
            return false;
        }
    }
</script>
</body>
</html>
