<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container-expand center p-4">

        <div class="card card-bg card-border" style="width: 18rem;">
            <div class="card-body">
                <h1 class="card-txt">Welcome, ${sessionScope.user.username}!</h1>
                <br>
                <p class="card-txt">Username: ${sessionScope.user.username}</p>
                <p class="card-txt">Email: ${sessionScope.user.email}</p>
                <a class="btn card-btn" href="/updateinfo">Update Info</a>

            </div>
        </div>

<%--        <h1 class="card-txt">Welcome, ${sessionScope.user.username}!</h1>--%>
<%--        <p class="card-txt">Username: ${sessionScope.user.username}</p>--%>
<%--        <p class="card-txt">Email: ${sessionScope.user.email}</p>--%>
<%--        <a class="card-txt" href="/updateinfo">Update Info</a>--%>
    </div>


    <div class="container-expand center p-4">
        <c:forEach var="ad" items="${ads}">
            <%--        <a href="/adpage?adId=${ad.getId()}">--%>
            <div id="${ad.id}" class="card card-bg m-4 p-3 card-txt card-border">
                <img src="https://w0.peakpx.com/wallpaper/158/947/HD-wallpaper-planet-076d-alien-black-cosmos-dark-light-neon-planets-space-stars-violet-thumbnail.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">${ad.title}</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    <a href="/adpage?adId=${ad.getId()}" class="btn card-btn">View Ad</a>
                        <%--                <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>--%>
                </div>
            </div>
            <%--        </a>--%>
        </c:forEach>
    </div>




<%--    <div>--%>
<%--        <c:forEach var="ad" items="${ads}">--%>
<%--            <div id="${ad.id}">--%>
<%--                <a href="/adpage?adId=${ad.getId()}">--%>
<%--                    <h2>${ad.title}</h2>--%>
<%--                </a>--%>
<%--            </div>--%>
<%--        </c:forEach>--%>

<%--    </div>--%>
</body>
</html>
