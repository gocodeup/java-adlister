<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="messages.jsp"%>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
    <link href="https://api.magicthegathering.io/v1/cards">
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1 style="text-transform: capitalize">Welcome, ${sessionScope.user.username}!</h1>
        <div class="col-lg-12">
            <h1>Your Ads:</h1>
            <c:forEach var="ad" items="${ads}">
                <div class="col-md-6" style="border: black 1px">
                    <h2>${ad.title}</h2>
                    <p>Description: ${ad.description}</p>
                    <h4>Block: ${ad.block}</h4>
                    <h4>Category: ${ad.category}</h4>
                    <h3>Date: ${ad.date},  Ad ID:${ad.id}</h3>
                </div>
<%--                    <div class="col-md-4" style="padding: 1em">--%>
<%--                    <h1>${ad.title}</h1>--%>
<%--                    <p>${ad.description}</p>--%>
<%--                        <hr>--%>
<%--                    <span style="position: relative; padding: 1em; height: 310px; width: 223px" id="card-name">Abundance</span>--%>
<%--                        <div id="card-pic"></div>--%>
<%--                    <hr>--%>
<%--                    </div>--%>
            </c:forEach>
        </div>
    </div>
</body>
</html>
