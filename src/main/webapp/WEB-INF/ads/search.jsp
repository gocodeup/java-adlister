<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Search for an Ad!</h1>
    <form action="/ads/search" method="get">
        <div class="form-group">
            <label for="search">Search</label>
            <input id="search" name="search" class="form-control" type="text" value="${param.searched}">
        </div>
        <input type="submit" class="btn btn-block btn-primary">

    </form>
    <c:choose>
        <c:when test="${param.search != null}">
            <c:forEach var="ad" items="${ads}">
                <c:if test="${fn:containsIgnoreCase(ad.title, param.search) || fn:containsIgnoreCase(ad.description, param.search)
                || fn:containsIgnoreCase(ad.block, param.search)|| fn:containsIgnoreCase(ad.date, param.search)|| fn:containsIgnoreCase(ad.id, param.search)
                || fn:containsIgnoreCase(ad.category, param.search)}">
                    <div class="col-md-6">
                        <a href="/ad/id/?${ad.id}">

                        <h2>${ad.title}</h2>
                        </a>
                        <p>Description: ${ad.description}</p>
                        <h4>Block: ${ad.block}</h4>
                        <h4>Category: ${ad.category}</h4>
                        <h3>Date: ${ad.date},  Ad ID:${ad.id}</h3>
                    </div>
                </c:if>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <p>${param.search}</p>
            <c:forEach var="ad" items="${ads}">
                <div class="col-md-6">
                    <a href="/ad/id/?${ad.id}">

                    <h2>${ad.title}</h2>
                    </a>
                    <p>Description: ${ad.description}</p>
                    <h4>Block: ${ad.block}</h4>
                    <h4>Category: ${ad.category}</h4>
                    <h3>Date: ${ad.date},  Ad ID:${ad.id}</h3>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
