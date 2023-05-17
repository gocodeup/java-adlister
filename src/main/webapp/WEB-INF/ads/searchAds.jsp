<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="serch Result"/>
    </jsp:include>
</head>
<body>
<%--<c:if test="session is true">--%>
<%--<jsp:include page="/WEB-INF/partials/navbarLoggedIn.jsp" />--%>
<%--</c:if>--%>
<%--<c:if test="session is false">--%>
<%--    <jsp:include page="/WEB-INF/partials/navbar.jsp" />--%>
<%--</c:if>--%>

<jsp:include page="/WEB-INF/partials/navbarLoggedIn.jsp"/>

<div class="container">
    <h1>Here Are Your search Result!</h1>

    <div class="ms-5 row">
        <div class="col-3 m-3">
            <div class="my-2">
                <jsp:useBean id="ads" scope="request" type="java.util.List"/>
                <c:forEach var="ad" items="${ads}">
                    <div class="card text-center" style=" width: 18rem;border:5px solid cornflowerblue">
                        <div style="margin: 1em" class="card-body">
                            <h5 class="card-title">${ad.title}</h5>
                            <p class="card-text">${ad.description}</p>
                            <a href="#" class="card-link">Card link</a>
                            <a href="#" class="card-link">Another link</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</body>
</html>
