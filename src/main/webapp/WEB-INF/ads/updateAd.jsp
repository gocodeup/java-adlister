<%
String title = request.getParameter("title");
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
    <jsp:include page="/WEB-INF/partials/navbarLoggedIn.jsp" />
</head>
<body>
<div class="container">
    <h1>Update <span class="text-primary"><%=request.getParameter("title")%></span></h1>
    <form action="updateAd" method="post">
        <div class="form-group">
            <label for="title">NeW Title</label>
            <input id="title" name="title" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="description">New Description</label>
            <textarea id="description" name="description" class="form-control" type="text"></textarea>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>
