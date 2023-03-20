<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>

<jsp:include page="/WEB-INF/partials/style.jsp"/>


    <div class="card" style="width: 18rem;">
        <img src="https://cdn.vectorstock.com/i/1000x1000/15/40/blank-profile-picture-image-holder-with-a-crown-vector-42411540.webp" class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title"><h2>Welcome, ${sessionScope.user.username}!</h2></h5>
        </div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item"><h4>${sessionScope.user.email}!</h4></li>
        </ul>
        <div class="card-body">
            <a href="/edit-profile" class="card-link">Edit Profile</a>
            <a href="/ads">Your Ads!</a>
        </div>
    </div>

<%--    <div class="container">--%>
<%--        <h1>Welcome, ${sessionScope.user.username}!</h1>--%>
<%--    </div>--%>

</body>
</html>


<%--//TODO The profile page should display the username and email of the logged-in user and a list of links to all the ads a user has created in the AdLister.&ndash;%&gt;--%>

<%--//TODO When a user logs in the user should be redirected to their profile page.--%>
<%--done--%>

<%--//TODO The profile view should only be accessible to users that are logged in.--%>
<%--done--%>