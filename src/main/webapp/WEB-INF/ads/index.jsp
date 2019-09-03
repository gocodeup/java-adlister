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
    <h1>Here Are all the ads!</h1>
    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6" style="border: black 1px">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
<%--            <h4>${ad.category}</h4>--%>
            <h4>${ad.block}</h4>
<%--            <h4>${param.block}</h4>--%>
<%--            NEED TO CONVERT THE BLOCKSID TO THE BLOCK NAME.--%>
            <h3>${ad.date}, ${ad.id}</h3>
<%--            NEED TO REMOVE AD ID BECAUSE IT IS NOT FUNCTIONAL FOR THE USER IN THEIR VIEW.--%>

        </div>
    </c:forEach>
</div>
</body>
</html>
