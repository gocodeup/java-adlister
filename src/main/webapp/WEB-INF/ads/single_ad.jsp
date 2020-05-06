<%--
  Created by IntelliJ IDEA.
  User: asanmiguel
  Date: 5/5/20
  Time: 9:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Single Ad"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h2><c:out value="${ad.title}"/></h2>
    <p><c:out value="${ad.user_id}"/></p>

    <div class="col-md-6">
        <p><c:out value="${ad.description}"/></p>
        <a href="/index.jsp">Return to All Ads</a>
    </div>
</div>

</body>
</html>