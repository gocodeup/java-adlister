<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar-login.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>

    <c: var="ad" items="${ads}">
        <div class="col-md-7">
            <div class="ad-box" style="border: 1px solid black">
                <h2>${ad.title}</h2>
                <p>${ad.description}</p>
            </div>
        </div>
    </c:>
</div>

</body>
</html>
