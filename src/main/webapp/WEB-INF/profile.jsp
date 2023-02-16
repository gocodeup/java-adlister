<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>

<style>
    :root {
        --main-bg: #E6ECF0;
        --main-link-color: #848487;
        --light-bg: #FFF;
        --separator-color: #DDD;
    }
    body, html {
        background-color: var(--main-bg);
        line-height: 100%;
        height: 100%;
        width: 100%;
        margin-right: 0;
        padding: 0;
        color: black;
    }
    header {
        background-image: url("https://picsum.photos/1200/300");
        background-size: cover;
        min-height: 300px;
        padding-top: 275px;
    }
    .nav li {
        display: inline-block;
        padding: 1.5em;
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
   .info{
       margin-right: 2em;
   }
    .profile-details{
        text-align: center;
    }
    .profile-items {
        padding: 0;
        list-style: none;
    }
    h3{
        text-align: center;
    }
    .container{
        margin: 2em 0 0 0;
    }
    h2{
        text-align: center;
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

    </section>
</header>


        <div class="container">
            <div class="row">
                <div class="col info">
                    <aside class="profile-details">
                        <h3>Welcome, ${sessionScope.user.username}!</h3>
                        <ul class="profile-items">
                            <li class="profile-entry">San Antonio, TX</li>
                            <li class="profile-entry">codeup.com</li>
                            <li class="profile-entry">Joined June 2011</li>
                        </ul>
                    </aside>
                </div>
                <div class="col-6">
                    <h2>Personal</h2>
                    <hr>
                    <c:forEach var="ad" items="${myFavs}">
                        <div class="ads">
                            <h3>${ad.title}</h3>
                            <p>${ad.description}</p>
                            <c:forEach var="cat" items="${ad.categories}">
                                <span>${cat.name}</span>
                            </c:forEach>
                            <a href="/ads/ad?${ad.id}">Click here to view ad</a>
                        </div>
                        <br>
                    </c:forEach>
                </div>
                <div class="col">
                    <h2>Favorites</h2>
                    <hr>
                    <c:forEach var="ad" items="${myFavs}">
                        <div class="ads">
                            <h3>${ad.title}</h3>
                            <p>${ad.description}</p>
                            <c:forEach var="cat" items="${ad.categories}">
                                <span>${cat.name}</span>
                            </c:forEach>
                            <a href="/ads/ad?${ad.id}">Click here to view ad</a>
                        </div>
                        <br>
                    </c:forEach>
                </div>
            </div>
        </div>




<%--</div>--%>
<%--        <jsp:include page="./partials/footer.jsp"></jsp:include>--%>
</body>
</html>



