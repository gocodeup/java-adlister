<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="../partials/navbar.jsp" />
    <div class="container">
        <h1 class="text-center mt-5">Create a new Ad</h1>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text"></textarea>
            </div>
            <div class="form-group">
                <label for="price">Price</label>
                <input class="form-control" type="number" step="0.1" id="price" name="price" />
            </div>





            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" name="categoryCheckbox" id="Cars" value="1">
                <label class="form-check-label" for="Cars">Cars</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" name="categoryCheckbox" id="Home-Decor" value="2">
                <label class="form-check-label" for="Home-Decor">Home Decor</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" name="categoryCheckbox" id="Electronic" value="3">
                <label class="form-check-label" for="Electronic">Electronic</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" name="categoryCheckbox" id="Animals" value="4">
                <label class="form-check-label" for="Animals">Animals</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" name="categoryCheckbox" id="Services" value="5">
                <label class="form-check-label" for="Services">Services</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" name="categoryCheckbox" id="Tools" value="6">
                <label class="form-check-label" for="Tools">Tools</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" name="categoryCheckbox" id="Furniture" value="7">
                <label class="form-check-label" for="Furniture">Furniture</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" name="categoryCheckbox" id="Real-Estate" value="8">
                <label class="form-check-label" for="Real-Estate">Real Estate</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" name="categoryCheckbox" id="Jobs" value="9">
                <label class="form-check-label" for="Jobs">Jobs</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" name="categoryCheckbox" id="Other" value="10">
                <label class="form-check-label" for="Other">Other</label>
            </div>
            <input type="submit" class="btn btn-block btn-info">
        </form>
    </div>
</body>
</html>
