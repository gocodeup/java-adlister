<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="View an Ad" />
    </jsp:include>
</head>
<body>
<div class="container">
    <h1>${ad.title}</h1>
    <p>${ad.description}</p>
</div>
</body>
</html>
