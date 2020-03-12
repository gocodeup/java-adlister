<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body >
    <jsp:include page="partials/navbar.jsp" />
    <br>
    <br>
    <br>
    <br>
    <section class="jumbotron mt-5" style="height: 50%">
        <div class="container">
            <div class="row">
                <div class="col-12 text-center mt-5">
                    <h1>Welcome to the Adlister!</h1>
                    <div class="d-inline"><div class="row align-items-center justify-content-center mt-5"><a href="/login" style="float: left;" class="p-1">Login</a><p style="float: left;" class="p-1 m-0"> or</p><a href="/register" style="float: left;" class="p-1">Register</a><p style="float: left;" class="p-1 m-0">to post your ads!</p></div></div>
                    <p></p>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
