<%--
  Created by IntelliJ IDEA.
  User: juanperez
  Date: 7/14/21
  Time: 10:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit Profile" />
    </jsp:include>
    <title>Edit Profile</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<%--got the proper items to scope and linked the java class, use that going forward for whatever.
 also have the tab for how to update a mysql file, and see if you can just use the
 files from the mySQLYUsersDao or add the edit one inside of there it makes sense.
 User.java also has conveneient Set methods i can try to possibly use instead since theyre already
 made--%>
<div class="container">
    <h1>Edit ${sessionScope.user.username}</h1>
    <h1>Edit ${sessionScope.user.email}</h1>
    <h1>Edit ${sessionScope.user.password}</h1>
</div>

</body>
</html>
