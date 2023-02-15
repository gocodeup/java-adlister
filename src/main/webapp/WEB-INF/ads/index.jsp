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
    <h1 style="color: blueviolet">Here Are all the ads!</h1>
</div>
<%--    <c:forEach var="ad" items="${ads}">--%>
<%--        <div class="col-md-6">--%>
<%--            <a href="/adpage?adId=${ad.getId()}">--%>
<%--                <h2>${ad.title}</h2>--%>
<%--            </a>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>
<div class="container-expand bg-primary ms-5 me-5" style="display: flex; flex-wrap: wrap">
    <c:forEach var="ad" items="${ads}">
        <a href="/adpage?adId=${ad.getId()}"><div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">${ad.title}</h5>
<%--                <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>--%>
                <p class="card-text">Click Card to View ad page</p>
            </div>
        </div></a>
    </c:forEach>



</div>


<%--<form action="/ads/search" method="GET">--%>
<%--    <input id="s" name="s" type="search" placeholder="Search Ads..." aria-label="Search">--%>
<%--    <button class="btn btn-outline-success" type="submit"></button>--%>
<%--</form>--%>

</body>
</html>
