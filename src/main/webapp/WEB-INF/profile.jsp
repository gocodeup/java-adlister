<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="messages.jsp"%>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <div class="col-lg-12">
            <h1>Here Are all the user ads!</h1>
            <c:forEach var="ad" items="${ads}">
                <div class="col-md-6" style="border: black 1px">
                    <h2>${ad.title}</h2>
                    <p>${ad.description}</p>
                    <h4>${ad.block}</h4>
                    <h3>Date: ${ad.date}</h3>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
