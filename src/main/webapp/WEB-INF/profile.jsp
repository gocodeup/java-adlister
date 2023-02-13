<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <form action="/" method="post">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" value="${sessionScope.user.username}" class="form-control">
            </div>
            <div class="form-group">
                <label for="username">Email:</label>
                <input type="text" id="email" name="username" value="${sessionScope.user.email}" class="form-control">
            </div>
            <input type="submit" value="update-info" class="btn btn-primary btn-block">
        </form>

    </div>
</body>
</html>
