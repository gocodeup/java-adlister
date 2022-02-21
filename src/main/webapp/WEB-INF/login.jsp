<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
    <title>Login</title>
    <link rel="stylesheet" href="/WEB-INF/css/mainNav.css">
    <link rel="stylesheet" href="/WEB-INF/css/globalVar.css">
    <link rel="stylesheet" href="/WEB-INF/css/login.css">
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Please Log In</h1>
        <form action="${pageContext.request.contextPath}/login" method="POST">
            <div class="loginDiv">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input id="username" name="username" class="form-control" type="text">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input id="password" name="password" class="form-control" type="password">
                </div>
            <input type="submit" class="btn btn-primary btn-block" value="Log In">
            </div>

        </form>
    </div>
</body>
</html>
