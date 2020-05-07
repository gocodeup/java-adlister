<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <a href="/update"><h4>Click here to update ads you posted, or update your login data</h4></a>
    <br>
    <a href="/ads"><h4>Click here to see all current listings!</h4></a>
    <br>
    <a href="/ads/create"><h4>Click here to create an ad of your own!</h4></a>
</body>
</html>
