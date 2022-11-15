<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="serch Result" />
    </jsp:include>
</head>
<body>
<%--<c:if test="session is true">--%>
<%--<jsp:include page="/WEB-INF/partials/navbarLoggedIn.jsp" />--%>
<%--</c:if>--%>
<%--<c:if test="session is false">--%>
<%--    <jsp:include page="/WEB-INF/partials/navbar.jsp" />--%>
<%--</c:if>--%>

<jsp:include page="/WEB-INF/partials/navbarLoggedIn.jsp" />

<div class="container">
    <h1>Here Are Your search Result!</h1>

    <jsp:useBean id="ads" scope="request" type="java.util.List"/>
    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
        </div>
    </c:forEach>
</div>
</body>
</html>
