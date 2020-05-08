<%@ page import="com.codeup.adlister.dao.DaoFactory" %>
<%@ page import="com.codeup.adlister.models.Ad" %>
<%@ page import="java.util.List" %>
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
<%--search form is POST--%>
    <div class="container">
        <form action="/ads/search" method="POST" >
            <div class="form-group">
                <label for="search">Search</label>
                <input id="search" name="search" class="form-control" type="search">
            </div>
            <input type="submit" class="btn btn-primary btn-block" value="search">
        </form>

        <h1>Here Are all the ads!</h1>
<%--shows all the ads--%>
        <c:forEach var="ad" items="${ads}">
            <div class="col-md-6">
<%--make index of ads links--%>
                <img src="${ad.imageURL}">
                <a href="/ad?id=${ad.id}"><h2>${ad.name}</h2></a>
                <p>${ad.description}</p>
            </div>
        </c:forEach>
    </div>
</body>
</html>
