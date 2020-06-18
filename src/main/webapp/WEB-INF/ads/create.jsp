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
    <strong>Error!</strong> Please make sure all fields are filled out before creating a post!
</div>


    <div class="container">
        <h1>Create a new Ad</h1>
        <form name="title" action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text">
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

    $(document).ready(function () {


        $('form[name="title"]').on("submit", function (e) {

            var title = $(this).find('input[name="title"]');
            if ($.trim(title.val()) === "") {
                e.preventDefault();
                $("#formAlert").slideDown(400);
            }
        });

        $(".alert").find(".close").on("click", function (e) {
            e.stopPropagation();
            e.preventDefault();
            $(this).closest(".alert").slideUp(400);
        });
    });
</script>
</body>
</html>
