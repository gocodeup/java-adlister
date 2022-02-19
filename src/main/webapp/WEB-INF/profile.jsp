<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Welcome, ${sessionScope.user.username}!</h1>
</div>

<h2>Here are your ads:</h2>

<%--for cleaner look putting ad title in a tag on click will take to individual ad page--%>
<%--need to rethink the a tag as it's not grabbing info for query--%>
<%--            <a href="/ad" methods="get" id="id"><h4>${ad.title}</h4></a>--%>

<c:forEach var="ad" items="${ads}">
    <div class="col-md-6">
        <h2>${ad.title}</h2>
        <p>${ad.description}</p>
        <form action="/ads/update" method="get">
            <input type="hidden" name="ad_id" value="${ad.id}">
            <input class="btn btn-secondary btn-sm" name="update" type="submit" value="Edit">
        </form>
        <form action="/ads/delete" method="post">
            <input type="hidden" name="ad_id" value="${ad.id}">
            <input class="btn btn-danger btn-sm" type="submit" value="Delete">
        </form>

        <form action="<c:url value="/ad?id="/>" method="get">
                <%--assigned value to input type of ad.id, allowing us to grab the ad's id--%>
            <input type="hidden" name="id" value="${ad.id}">
            <button>Submit</button>
        </form>
    </div>
</c:forEach>

</body>
</html>
