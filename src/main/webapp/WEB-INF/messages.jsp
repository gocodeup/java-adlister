<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!"/>
    </jsp:include>
</head>
<body>

<%@ include file="/WEB-INF/partials/navbar.jsp" %>

<c:set var="exception" value="${requestScope['javax.servlet.error.exception']}"/>

<div class="container">
    <h1>Oops! An Error has Occurred.</h1>
    <!-- Stack trace -->
    <jsp:scriptlet>

          exception.printStackTrace(new java.io.PrintWriter(out));

    </jsp:scriptlet>

    <h2>Click <a href="/index">here</a> to go back to the homepage.</h2>

</div>
</body>
</html>
