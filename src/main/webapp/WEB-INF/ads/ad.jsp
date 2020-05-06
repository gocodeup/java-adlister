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
    <h1>Here is the selected ad!</h1>


        <div>
            <h2>${ad.title}</h2>
            <h3>From ${adUser.username}</h3>
            <p>${ad.description}</p>
        </div>
</div>

</body>
</html>
