<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, <c:out value="${sessionScope.user.username}"/>!</h1
        <h2>Recently Posted Ads</h2>
        <br>
        <br>
    </div>

    <div class="container">
        <div>
                <h5>Title: <c:out value="${sessionScope.title}"/></h5>
                <p>Description: <c:out value="${sessionScope.ad.description}"/></p>
                <p>Category: <c:out value="${sessionScope.ad.category}"/></p>
        </div>

        <h5>Ad ID: ${sessionScope.ad.id}</h5>
        <p>
            <h5>Posted By: ${sessionScope.user.username}</h5>
        </p>


    </div>

</body>
</html>