<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.getSession().removeAttribute("user");
    request.getSession().invalidate();
%>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/style.jsp"/>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>You have been logged out</h1>
    <h3>Redirecting to login page</h3>
    <script>
        console.log("logout jsp")
        setTimeout(
            function(){
                window.location = "/login"
            },
            3000);
    </script>
</div>
</body>
</html>
