<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The results" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="container">
    <h1 style="text-align: center">Here Are All The Results!</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="card col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
            <a href="/ad?id=${ad.id}" class="btn btn-primary" style="align-content: center">More Details</a>
        </div>
    </c:forEach>
</div>

</body>
</html>
