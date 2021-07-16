<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit Profile" />
    </jsp:include>
    <title>Edit Profile</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Enter New Information Below</h1>
    <form action="/editProfile" method="POST">
        <div class="form-group">
            <label for="username">New Username</label>
            <input id="username" name="username" class="form-control" type="text" placeholder="${sessionScope.user.username}">
        </div>
        <div class="form-group">
            <label for="email">New E-Mail</label>
            <input id="email" name="email" class="form-control" type="text" placeholder="${sessionScope.user.email}">
        </div>
        <div class="form-group">
            <label for="password">New Password</label>
            <input id="password" name="password" class="form-control" type="password">
        </div>
        <div class="form-group">
            <label for="newPassword">Confirm Password</label>
            <input id="newPassword" name="newPassword" class="form-control" type="password">
        </div>
        <input type="submit" class="btn btn-primary btn-block" value="Submit Changes">
    </form>
</div>

</body>
</html>
