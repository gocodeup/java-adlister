<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
//import com.codeup.adlister.dao.MySQLCategoryDao;

%>




<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
    <style><%@include file="/WEB-INF/partials/design.css"%></style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1 style="text-align: center;">Here Are all the ads!</h1>

    <c:forEach var="ad" items="${ads}">


        <div class="col-md-6">

        <div class="card col-md-6">

            <h2>${ad.title}</h2>
            <p>${ad.description}</p>

<%--            <c:forEach var="cat" items="ad."--%>
            <a href="/ad?id=${ad.id}" class="btn btn-primary">More Details</a>
        </div>

    </c:forEach>

</div>

</body>
</html>
