<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Ad Deleted Successfully" />
    </jsp:include>
</head>

<body>
<form action="/ads/profile" method="post">
    <a href="/ads/profile" class="btn btn-primary" type="submit">Return to profile</a>
</form>
</body>
</html>