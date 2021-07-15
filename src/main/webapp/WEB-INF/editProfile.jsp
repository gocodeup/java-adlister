<%--
  Created by IntelliJ IDEA.
  User: juanperez
  Date: 7/14/21
  Time: 10:17 PM
  To change this template use File | Settings | File Templates.
--%>
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
<%--got the proper items to scope and linked the java class, use that going forward for whatever.
 also have the tab for how to update a mysql file, and see if you can just use the
 files from the mySQLYUsersDao or add the edit one inside of there it makes sense.
 User.java also has conveneient Set methods i can try to possibly use instead since theyre already
 made--%>

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
            <label for="password">Password</label>
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
