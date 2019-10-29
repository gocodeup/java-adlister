<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Yael-PC1
  Date: 10/28/2019
  Time: 10:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <jsp:include page="/WEB-INF/partials/head.jsp">
            <jsp:param name="title" value="A single ad!"/>
        </jsp:include>
    </head>
    <body>
        <jsp:include page="/WEB-INF/partials/navbar.jsp" />

        <div class="container">
            <h1>Title: ${ad.title}</h1>
            <h2>Username: <em>${ad.username}</em></h2>
            <h3>Description: ${ad.description}</h3>
            <p></p>
            <p><a href="/ads">Go back and view all ads</a></p>
            <p><a href="/ads/create">Create an ad</a></p>
        </div>

    </body>
</html>
