<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body class="profile-Body">

<%--Profile Header--%>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<header>
    <section class="profile">
        <div class="profile-header">
            <img class="img-circle profile-image" src="https://randomuser.me/api/portraits/men/12.jpg" alt="user">
        </div>
    </section>
</header>

    <%--Profile Personal Info--%>
        <div class="container">
            <div class="row">
                <div class="col info">
                    <aside class="profile-details">
                        <h3>Welcome, ${sessionScope.user.username}!</h3>
                        <ul class="profile-items">
                            <li class="profile-entry">San Antonio, TX</li>
                            <li class="profile-entry">Adlister.com</li>
                            <li class="profile-entry">Joined January 2023</li>
                        </ul>
                    </aside>
                </div>

        <%--      Users Ads Section      --%>
                <div class="col-6">
                    <h2>Your Ads</h2>
                    <hr>
                    <c:forEach var="ad" items="${myAds}">
                        <div class="ads">
                            <h1>${ad.title}</h1>
                            <p>${ad.description}</p>
                            <c:forEach var="cat" items="${ad.categories}">
                                <span>${cat.name}</span>
                            </c:forEach>
                            <a href="/ads/ad?${ad.id}">Click here to view ad</a>
                        </div>
                        <br>
                    </c:forEach>
                </div>

        <%--    Users Favorite Ads Section     --%>
                <div class="col">
                    <h1>Favorites</h1>
                    <hr>
                    <c:forEach var="ad" items="${myFavs}">
                        <div class="ads">
                            <a href="/ads/favorite?${ad.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true" style="width: 50%">Remove Favorite</a>
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
        <%--Footer--%>
        <jsp:include page="./partials/footer.jsp"></jsp:include>
</body>
</html>



