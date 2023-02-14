<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>

<style>
    body{
        background: #2e303b;
        color: white;
    }

    :root {
        --main-bg: #E6ECF0;
        --link-color: #3B94D9;
        --main-link-color: #848487;
        --light-bg: #FFF;
        --separator-color: #DDD;
    }
    * {
        box-sizing: border-box;
    }
    body, html {
        background-color: var(--main-bg);
        line-height: 100%;
        height: 100%;
        width: 100%;
        margin: 0;
        padding: 0;
        font-family: Arial, Ubuntu, sans-serif;
    }
    header {
        background-image: url("https://picsum.photos/1200/300");
        background-size: cover;
        min-height: 300px;
        padding-top: 275px;
    }
    a {
        color: var(--link-color);
    }
    .nav li {
        display: inline-block;
        padding: 1.5em;
    }
    .nav-link:hover {
        color: var(--link-color);
    }
    .profile-image{
        position: absolute;
        top: -28px;
    }
    .profile {
        background: var(--light-bg);
        height: 80px;
        position: relative;
    }
    .profile-entry {
        margin: .5em;
    }
    .img-circle {
        border-radius: 100%;
        border: 4px solid var(--light-bg);
    }
    .text-muted {
        color: var(--main-link-color);
    }
    .container{
        margin-top: 2em;
    }
    .profile-details, .timeline{
        margin: 0 .5em;
        float: left;
    }
    .profile-details{
        width: calc(25% - 1em);
    }
    .profile-items {
        padding: 0;
        list-style: none;
    }
    .timeline {
        width: calc(50% - 1em);
    }
    .media {
        width: 100%;
        background-color: var(--light-bg);
        border-bottom: 1px solid var(--separator-color);
        padding: .5em;
        overflow: auto;
    }
    .media-image {
        max-width: 50px;
        float: left;
        margin-top: 1.33em;
    }
    .media-body {
        float: left;
        width: calc(100% - 50px);
    }
</style>


<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

<%--    <div class="container">--%>
<%--        <h1>Welcome, ${sessionScope.user.username}!</h1>--%>
<%--    </div>--%>
<%--    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>--%>

    <header>
        <section class="profile">
            <div class="profile-header">
                <img class="img-circle profile-image" src="https://randomuser.me/api/portraits/men/12.jpg" alt="user">
<%--                <h1 style="color: black">Welcome, ${sessionScope.user.username}!</h1>--%>
            </div>
<%--            <div class="profile-form">--%>
<%--                <form action="#" class="text-right">--%>
<%--                    <button class="btn btn-large">Edit profile</button>--%>
<%--                </form>--%>
<%--            </div>--%>
        </section>
    </header>
    <div class="container">
        <aside class="profile-details">

            <h3 style="color: black">Welcome, ${sessionScope.user.username}!</h3>

            <ul class="profile-items">
                <li class="profile-entry"><a href="#">San Antonio, TX</a></li>
                <li class="profile-entry"><a href="#">codeup.com</a></li>
                <li class="text-muted profile-entry">Joined June 2011</li>
            </ul>
        </aside>
        <main class="timeline">
            <div class="media">
                <img class="media-image img-circle" src="https://randomuser.me/api/portraits/women/18.jpg" alt="Random user">
                <div class="media-body">
                    <h4 class="tweet-user">Safia Abdalla <span class="text-muted">@captainsafia</span></h4>
                    Unit tests are an important part of self-care.
                </div>
            </div>
            <div class=media>
                <img class="media-image img-circle" src="https://randomuser.me/api/portraits/men/22.jpg" alt="Random user">
                <div class="media-body">
                    <h4 class="tweet-user">Little Idea <span class="text-muted">@littleidea</span></h4>
                    <p>I've only seen one thing produce software quality... conscientious people with quality as a high
                        priority.</p>
                    <p>Often those people should have prioritized 'valuable'.</p>
                    <p>Live and learn. Live and learn.</p>
                </div>
            </div>
        </main>
    </div>
<div>
    <h1>Favorites</h1>
    <c:forEach var="ad" items="${myFavs}">
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
            <c:forEach var="cat" items="${ad.categories}">
                <span>${cat.name}</span>
            </c:forEach>
            <a href="/ads/ad?${ad.id}">Click here to view ad</a>
        </div>
    </c:forEach>
</div>
</body>
</html>



