<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style><%@include file="./CSS/style.css" %></style>
    <title>Adlister</title>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
    <script src="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"></script>
</head>
   <header>
       <jsp:include page="/WEB-INF/partials/navbar.jsp" />
        <h1>Welcome to the Adlister!</h1>
   </header>
   <script type="text/javascript"><%@include file="./JS/particles.js" %></script>
<div class="row">
    <div class="leftcolumn">
        <div class="card">
            <h2>Fav Ads</h2>

        </div>
        <div class="card">
            <h2>My Ads</h2>

        </div>
    </div>
    <div class="rightcolumn">
        <div class="card">
            <h2>General Fluff</h2>

        </div>
    </div>
</div>
<div class="footer">
</div>
</body>
</html>
