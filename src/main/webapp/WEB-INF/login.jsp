<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
    <link rel="stylesheet" href="/stylesheets/styles.css">
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Please Log In</h1>

        <div class="container-fluid my-5 justify-content-around">
        <form action="/login" method="POST">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <%--loginError allows error message to display  --%>
            <h3 style="color: red">${loginError}</h3>
            <input type="submit" class="btn btn-dark btn-block" value="Log In">
        </form>
    </div>


        <a class="back-button mx-auto" href="/index.jsp"><i class="fa fa-chevron-left" aria-hidden="true"></i>Return Home</a>

    </div>




    <jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
</body>
</html>
