<%--
  Created by IntelliJ IDEA.
  User: nayoungkim
  Date: 6/16/20
  Time: 12:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Events" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container mt-4">

    <h1>Here are your events</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.category}</p>
            <p>${ad.description}</p>
            <p>${ad.displayUser()}</p>
        </div>
    </c:forEach>
</div>

</body>
</html>
