<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h1>Check out this popular listing!</h1>
    <div>
        <h2>${ad.title}</h2>
        <h3>From ${adUser.username}</h3>
        <p>${ad.description}</p>
    </div>
</div>
<br>
<a href="/index"><h4>Return to All Ads Page</h4></a>
</body>
</html>
