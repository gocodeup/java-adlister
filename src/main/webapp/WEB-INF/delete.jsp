<%--
  Created by IntelliJ IDEA.
  User: gdev
  Date: 5/5/20
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Update Ad"/>
    </jsp:include>
</head>
<body>
    <p><c:out value="${ad.id}"></c:out></p>
</body>
</html>
