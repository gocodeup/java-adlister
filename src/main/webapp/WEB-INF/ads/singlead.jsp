<%--
  Created by IntelliJ IDEA.
  User: smurfkat
  Date: 5/6/20
  Time: 12:30 PM
  To change this template use File | Settings | File Templates.
--%>
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
        <div class="col-md-6">
           <h2>${ad.name}</h2>
            <p>${ad.description}</p>
            <p>${ad.price}</p>
            <p>${ad.condition}</p>
            <p>${ad.shiny}</p>
            <p>${ad.type}</p>

        </div>

</div>

</body>
</html>

