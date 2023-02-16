
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Info</title>
<jsp:include page="/WEB-INF/partials/head.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1 class="card-txt">Update Info <c:out value="${sessionScope.user.username}"/>:</h1>

    <form class="card-txt" action="/updateinfo" method="post">
        <div class="form-group">
            <label for="email">Username</label>
            <input id="username" name="username" class="form-control" type="text" value="${sessionScope.user.username}">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input id="email" name="email" class="form-control" type="text" value="${sessionScope.user.email}">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input id="password" name="password" class="form-control" type="password"  required>
        </div>
        <div class="form-group">
            <label for="confirm_password">Confirm Password</label>
            <input id="confirm_password" name="confirm_password" class="form-control" type="password"  required>
        </div>
        <input type="submit" name="editButton" class="btn card-btn">
    </form>
    <form action="/updateinfo" method="post">
        <button class="btn delete-btn" type="submit" name="delete-account" value="${sessionScope.user.id}" onclick="return confirm('This will delete all info are you sure?')" >Delete Account?</button>

    </form>
<%--    <div>--%>
<%--        <c:if test="${invalidUsername}">--%>
<%--            <small>Sorry, that username is already taken.</small>--%>
<%--        </c:if>--%>
<%--        <c:if test="${inputHasErrors}">--%>
<%--            <small>Please make sure your password and password confirmation are the same.</small>--%>
<%--        </c:if>--%>
<%--    </div>--%>
</div>
</body>
</html>
