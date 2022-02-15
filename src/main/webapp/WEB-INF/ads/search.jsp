<%--
  Created by IntelliJ IDEA.
  User: aidajimenez
  Date: 2/14/22
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Search Ads" />
    </jsp:include>

    <title>Search</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">
    <h1>You Search Results  ${sessionScope.user.username}!</h1>
<c:forEach var="ad" items="${ads}">
    <div class="col-md-6">
        <h2>${ad.title}</h2>
        <p>${ad.description}</p>
    </div>
</c:forEach>

</div>

</body>
</html>
