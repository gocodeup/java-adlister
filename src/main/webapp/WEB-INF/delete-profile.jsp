<%--
  Created by IntelliJ IDEA.
  User: localdev
  Date: 11/16/22
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Update Your Ad" />
    </jsp:include>
    <title></title>
</head>
<body>
    <h1>Delete Your Profile</h1>
    <form action="/profile/delete" method="POST">
        <input name="userId" value="${userId}" style="display: none" />
        <input type="submit" class="btn btn-block btn-danger" value="Delete Profile" />
    </form>
</body>
</html>
