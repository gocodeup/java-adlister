<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: julianmartinez
  Date: 2/14/22
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<%--consider page being a card--%>
<main class="container">
    <h2>Your Ad Title: <c:out value="${ad.title}"/></h2>
    <p>${ad.description}</p>
    <h5>${adUser.username}</h5>
    <h6>${adUser.email}</h6>
    <%--FOR LOOP to display all categories an ad belongs to ad.category_id.getName()--%>
<%--Still need to work on categories--%>
<%--    <ul>--%>
<%--        <li>Jobs</li>--%>
<%--        <li>Housing</li>--%>
<%--        <li>For Sale</li>--%>
<%--        <li>Community</li>--%>
<%--    </ul>--%>
</main>
</body>
</html>
