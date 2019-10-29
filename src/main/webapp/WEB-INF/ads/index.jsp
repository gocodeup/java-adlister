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
            <div class="header" style="height: 150px;width: 100%;">
                <div class="col-md-6">
                    <h1>Here Are all the ads!</h1>
                    <h3><a href="/ads/create">Create an ad</a></h3>
                </div>
                <div class="col-md-6">
                    <form method="post" style="padding-top: 30px;">
                        <input class="form-control" type="search" value="How do I shoot web" id="search" style="display: inline-block;width: 85%;">
                        <button type="submit" style="display: inline-block;">Search</button>
                    </form>
                </div>
            </div>

            <div class="row">
                <c:forEach var="ad" items="${ads}">
                    <div class="col-md-6">
                        <h2><a href="/ads/?ad_id=${ad.id}">${ad.title}</a></h2>
                        <h2><em>${ad.username}</em></h2>
                        <p>${ad.description}</p>
                    </div>
                </c:forEach>
            </div>
        </div>


    </body>
</html>