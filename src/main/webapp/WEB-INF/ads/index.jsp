<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbarLoggedIn.jsp" />

<div class="container">
    <h1 class="text-center">Here Are all the ads!</h1>

    <c:forEach var="ad" items="${ads}">

            <div class="card text-center" style="width: 18rem;border:5px solid cornflowerblue">
                <div class="card-body">
                    <h5 class="card-title">${ad.title}</h5>
                    <p class="card-text">${ad.description}</p>
                    <a href="#" class="card-link">Card link</a>
                    <a href="#" class="card-link">Another link</a>
                </div>
            </div>


    </c:forEach>
</div>
</body>
</html>
