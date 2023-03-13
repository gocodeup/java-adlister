<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body class="bg-dark">
<jsp:include page="/WEB-INF/partials/navbar.jsp" />


<div class="container" style="text-align: center">
    <h1 class="text">Here Are all the ads!</h1>
</div>
<%--    <c:forEach var="ad" items="${ads}">--%>
<%--        <div class="col-md-6">--%>
<%--            <a href="/adpage?adId=${ad.getId()}">--%>
<%--                <h2>${ad.title}</h2>--%>
<%--            </a>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>
<div class="container-expand center p-4">

    <c:forEach var="ad" items="${ads}">
<%--    <div class="card card-bg card-txt card-border m-4">--%>
<%--        <img src="https://w0.peakpx.com/wallpaper/158/947/HD-wallpaper-planet-076d-alien-black-cosmos-dark-light-neon-planets-space-stars-violet-thumbnail.jpg" class="card-img-top" alt="...">--%>
<%--        <div class="card-body">--%>
<%--            <h5 class="card-title">${ad.title}</h5>--%>
<%--            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>--%>
<%--            <a href="/adpage?adId=${ad.getId()}" class="btn card-btn">View Ad</a>--%>
<%--        </div>--%>
        </c:forEach>


    <c:forEach var="ad" items="${ads}">
<%--        <a href="/adpage?adId=${ad.getId()}">--%>
            <div class="card card-bg m-4 p-3 card-txt card-border">
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




    </div>






<%--<form action="/ads/search" method="GET">--%>
<%--    <input id="s" name="s" type="search" placeholder="Search Ads..." aria-label="Search">--%>
<%--    <button class="btn btn-outline-success" type="submit"></button>--%>
<%--</form>--%>

</body>
</html>
