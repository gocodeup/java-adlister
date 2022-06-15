
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Color</title>
    <%@include file="partials/head.jsp"%>
</head>
<body style="background-color: ${color}">
<%@ include file="partials/navbar.jsp"%>
<p class="text-center">Is this your favorite color? ${color}</p>

<%--<%@ include file="partials/footer.jsp"%>--%>
<%--<%@ include file="partials/scripts.jsp"%>--%>
</body>
</html>