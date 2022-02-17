<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>
    <div class="display-cards row row-cols-4" >
    <c:forEach var="ad" items="${ads}">
        <div class="card" style="width: 25rem">
            <form action="/ads/individualAd" method="GET">
<%--            <h2><a href="/ads/individualAd">${ad.id}</a></h2>--%>
            <input type="hidden" name="ad" value="${ad.id}">
<%--            <h2><a href="<c:url value='/ads/individualAd?id=${ad.id}'/>"${ad.title}/></h2>--%>
            <h3>${ad.title}</h3>
            <p>${ad.description}</p>
            <button class="btn-light ">Show Ad</button>
            </form>

<%--            <p>${ad.description}</p>--%>

        </div>

    </c:forEach>
    </div>
</div>

</body>
</html>
