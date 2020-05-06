<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

<%--    form to update ad content    --%>
    <form method="POST" action="/update">
        <input type="hidden" name="updateAd" value="${ad.id}"/>
        <label>Title: </label>
        <input type="text" name="adName" value="${ad.name}"/>
        <br>
        <br>
        <label>Description:</label>
        <input type="text" name="adDescription" value="${ad.description}"/>
        <br>
        <br>
        <button type="submit" class="ui-button">Update Ad</button>
    </form>
    <br>

<%--for to update user profile--%>
    <div id="userProfileUpdateForm">
        <form method="POST" action="update">
        <input type="hidden" name="updateProfile" value="${profile.id}"/>
        <label>Change Username</label>
        <input type="text" name="userName" value="${user.userName}"/>
        <br>
        <label>Change Email</label>
        <input type="text" name="userEmail" value="${user.email}"/>
        <br>
        <label>Change Password</label>
        <input type="text" name="userPassword" value="${user.password}">
            <button type="submit" class="ui-button">Update User Profile</button>
        </form>
    </div>

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>

</body>
</html>
