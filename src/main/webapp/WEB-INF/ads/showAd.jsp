<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <jsp:include page="/WEB-INF/partials/head.jsp">
            <jsp:param name="title" value="${ad.title}"/>
        </jsp:include>
    </title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <div class="row">
        <div class="col">
            <h1>${ad.title}</h1>
            <p>${ad.description}</p>
            <p>This ad posted by: ${user.getUsername()}</p>
        </div>
    </div>
</div>
</body>
</html>
