<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/stylesheets/styles.css">
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!"/>
    </jsp:include>

</head>
<%

//exploring sticky forms
    //  obtaining the inputs from the form into local variables
    String username = request.getParameter("username");
    if (username == null) username = "";

    String email = request.getParameter("email");
    if (email == null) email = "";

    String password = request.getParameter("password");
    if (password == null) password = "";
// checking to see if this form has been submitted
    if (request.getMethod().equals("POST"))
    {
// initializing a boolean for errors
        boolean allEntriesPresent = true;
// initializing a string for the error message
        String skipped_inputs = "";
        if (username.length( ) == 0)
        {

            skipped_inputs = "You forgot to enter your username<br>";
            allEntriesPresent = false;

        }
        if (email.length( ) == 0)
        {

            skipped_inputs = skipped_inputs + "You forgot to enter your email<br>";
            allEntriesPresent = false;

        }
        if (password.length( ) == 0)
        {

            skipped_inputs = skipped_inputs + "You forgot to enter your password<br>";
            allEntriesPresent = false;

        }

// if all of the required fields haven't been entered
// inform the user
        if (!allEntriesPresent)
        {

            out.println(skipped_inputs);

        }
        else
        {

// display the name and address that have been entered
            String identifierString = "Your name: " + username + " " +  "<br>" +
                    "Your email: " + email + "<br>";
            out.println("<p>" + identifierString);

        }

    }
%>
<body>
<jsp:include page="partials/navbar.jsp"/>




<div class="container">
    <h1>Please fill in your information.</h1>
    <form action="/register" method="POST">
        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username" class="form-control" type="text" value="<%=username%>">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input id="email" name="email" class="form-control" type="email" value="<%=email%>">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input id="password" name="password" class="form-control" type="password" value="<%=password%>">
        </div>
        <div class="form-group">
            <label for="confirm_password">Confirm Password</label>
            <input id="confirm_password" name="confirm_password" class="form-control" type="password" value="<%=password%>">
        </div>
        <%--error attribute posts error message from registerservlet --%>
        <h3 style="color: red">${error}</h3>
        <input type="submit" class="btn btn-dark btn-block">
    </form>
</div>

<div class="container-fluid my-5">
    <a class="back-button mx-auto" href="/index.jsp"><i class="fa fa-chevron-left" aria-hidden="true">Return Home</i></a>

</div>

<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
<script>
    window.onbeforeunload = function () {
        sessionStorage.setItem("username", $('#username').value);
    }
    window.onload = function () {
        var user = sessionStorage.getItem("username");
        if (user !== null) $('#username').value = user;
    }


</script>


</body>
</html>
