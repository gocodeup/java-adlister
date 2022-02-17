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
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>

    <h2>Here are your ads:</h2>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
<%--for cleaner look putting ad title in a tag on click will take to individual ad page--%>
<%--would like ads to be placed in a table will configure later--%>
            <a href="/ad" methods="get" name="id"><h2>${ad.title}</h2></a>
            <p>${ad.description}</p>

<%--            <form action="/ad" method="get">--%>
<%--                <input type="hidden" name="id">--%>
<%--                <button>Submit</button>--%>
<%--            </form>--%>
        </div>
    </c:forEach>
</body>
</html>
