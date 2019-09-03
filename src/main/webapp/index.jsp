<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="/WEB-INF/messages.jsp"%>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
<%--<c:choose>--%>
<%--    <c:when test="${sessionScope.user == null}">--%>
        <%@ include file="/WEB-INF/partials/navbar.jsp" %>
<%--    </c:when>--%>
<%--</c:choose>--%>
 <div class="container">
        <h1>Welcome to the Adlister!</h1>
    </div>
</body>
</html>
