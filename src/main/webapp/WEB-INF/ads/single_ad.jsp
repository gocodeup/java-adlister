<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="View an Ad" />
    </jsp:include>
</head>
<body>
<div class="container">
    <h1>Check out this popular listing!</h1>
    <div>
        <h2>${ad.title}</h2>
        <h3>From ${adUser.username}</h3>
        <p>${ad.description}</p>
    </div>
</div>
</body>
</html>
