<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
    <title>my profile</title>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar-logged-in.jsp" />

    <div class="container">
        <h1>welcome, ${sessionScope.user.username}!</h1>
    </div>

</body>
</html>
