<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
<%
    String username = request.getParameter("username");
    if (username == null) username = "";
    String email = request.getParameter("email");
    if (email == null) email = "";
    String password = request.getParameter("password");
    if (password == null) password = "";
    String passwordConfirmation = request.getParameter("confirm_password");
    if (passwordConfirmation == null) passwordConfirmation = "";

    if (request.getMethod().equals("POST")){
        boolean allEntriesPresent = true;
        String skipped_inputs = "";
        if (username.isEmpty())
        {
            skipped_inputs = "You forgot to enter your username<br>";
            allEntriesPresent = false;
        }
        if (email.isEmpty())
        {
            skipped_inputs = skipped_inputs + "You forgot to enter your email<br>";
            allEntriesPresent = false;
        }
        if (password.isEmpty())
        {
            skipped_inputs = skipped_inputs + "You forgot to enter your password<br>";
            allEntriesPresent = false;
        }
        if (passwordConfirmation.isEmpty())
        {
            skipped_inputs = skipped_inputs + "You forgot to confirm your password<br>";
            allEntriesPresent = false;
        }

        if (!allEntriesPresent){
            System.out.println(skipped_inputs);
        } else {
            String identifierString = "Your username: " + username + " " + email + "<br>" + "Your password: " + password + "<br>";
            System.out.println("<p>" + identifierString);
        }
    }

%>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <h1>Please fill in your information.</h1>
        <form action="/register" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text" value="<%=username%>">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text" value="<%=email%>">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password" value="<%=password%>">
            </div>
            <div class="form-group">
                <label for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control" type="password" value="<%=passwordConfirmation%>">
            </div>
            <input type="submit" class="btn btn-primary btn-block">
            <p>Already have an account? <a href="/login">Log In</a></p>
        </form>
    </div>
</body>
</html>
