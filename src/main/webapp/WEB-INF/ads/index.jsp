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
    <jsp:include page="../partials/message.jsp" />
    <h1>Here are all the ads!</h1>

    <c:forEach var="ad" items="${ads}" varStatus="status">
        <div class="col-md-6">
            <h2><a href="/ad?name=${ad.title}"><c:out value="${ad.title}"/></a></h2>
            <h4>By <c:out value="${users[status.index]}"/></h4>
            <p><c:out value="${ad.description}"/></p>
        </div>
    </c:forEach>
</div>

</body>
</html>