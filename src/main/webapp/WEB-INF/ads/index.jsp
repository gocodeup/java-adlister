<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/style.jsp"/>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/logout">Logout</a></li>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->

</nav><div class="d-flex row col-12">
    <h1 class="col-12 text-center">Adlister</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="ms-2 col-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
            <hr>
        </div>
    </c:forEach>
</div>
<div class="row">
    <a class="col-12 text-center" href="/ads/create"><strong>Make a new ad</strong></a>
</div>
</body>
</html>
