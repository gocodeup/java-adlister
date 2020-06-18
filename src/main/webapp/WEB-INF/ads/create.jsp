<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />


<div id="formAlert" class="alert alert-danger hide collapse" role="alert">
    <a class="close" data-dismiss="alert">×</a>
    <strong>Warning!</strong> Make sure all fields are filled and try again.
</div>


    <div class="container">
        <h1>Create a new Ad</h1>
        <form name="register" action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="username" class="form-control" type="text">
            </div>

            <div class="form-group">
                <label for="exampleFormControlSelect1">Category</label>
                <select class="form-control" name="category" id="exampleFormControlSelect1">
                    <option>Events</option>
                    <option>Business Operations</option>
                </select>
            </div>

            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text"></textarea>
            </div>
            <input type="submit" class="btn btn-block btn-primary" value="create a Post">
        </form>
    </div>






<script>
    // function validateForm() {
    //     var x = document.forms["myForm"]["title"].value;
    //     if (x == "") {
    //         alert();
    //         return false;
    //     }
    // }

    $(document).ready(function () {
        // Run this code only when the DOM (all elements) are ready

        $('form[name="register"]').on("submit", function (e) {
            // Find all <form>s with the name "register", and bind a "submit" event handler

            // Find the <input /> element with the name "username"
            var username = $(this).find('input[name="username"]');
            if ($.trim(username.val()) === "") {
                // If its value is empty
                e.preventDefault();    // Stop the form from submitting
                $("#formAlert").slideDown(400);    // Show the Alert
            }
        });

        $(".alert").find(".close").on("click", function (e) {
            // Find all elements with the "alert" class, get all descendant elements with the class "close", and bind a "click" event handler
            e.stopPropagation();    // Don't allow the click to bubble up the DOM
            e.preventDefault();    // Don't let any default functionality occur (in case it's a link)
            $(this).closest(".alert").slideUp(400);    // Hide this specific Alert
        });
    });
</script>
</body>
</html>
