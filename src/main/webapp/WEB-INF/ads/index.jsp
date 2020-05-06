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
    <form method="POST" action = "/ads" id="search_form">
        <input type="text" name="search" id="search" placeholder="Search">
        <button type="submit">Search</button>
    </form>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2><c:out value="${ad.title}"/></h2>
                <%--            <p><c:out value="${ad.user_id}"/></p>--%>
            <p><c:out value="${ad.description}"/></p>
            <a href=“/ads?id=${ad.id}&button=edit” name=“button”>Edit</a>
            <a href=“/ads?id=${ad.id}&button=delete” name=“button”>Delete</a>
            <p>${editDelMessage}</p>
            <a href="/ad?name=${ad.title}">Click here to view more about this ad!</a>
        </div>
    </c:forEach>
</div>

</body>
</html>