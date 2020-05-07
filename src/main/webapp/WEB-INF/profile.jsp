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
        <form method="POST" action="/profile">
        <input type="hidden" name="updateprofile" value="${profile.id}"/>

        <label>Change Username</label>
        <input type="text" name="edit_username" value="${user.username}"/>
        <br>

        <label>Change Email</label>
        <input type="text" name="email" value="${user.email}"/>
        <br>

        <label>Change Password</label>
        <input type="text" name="password" value="${user.password}">

            <button type="submit" class="ui-button">Update User Profile</button>
        </form>
    </div>


</body>
</html>
