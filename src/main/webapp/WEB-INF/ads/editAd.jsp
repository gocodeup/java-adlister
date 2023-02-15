<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Editing ad" />
  </jsp:include>
</head>
<body>
<div class="container ">
  <h1>Edit your Ad "${ad.title}"</h1>
  <form action="/ads/edit" method="post">
    <input class="d-none" name="id" value="${ad.id}">
    <div class="form-group">
      <label for="title">Title</label>
      <input id="title" name="title" class="form-control" type="text" value="${ad.title}">
    </div>
    <div class="form-group">
      <label for="description">Description</label>
      <textarea id="description" name="description" class="form-control" type="text">${ad.description}</textarea>
    </div>
    <input type="submit" class="btn btn-block btn-primary">
  </form>
</div>
<jsp:include page="../partials/footer.jsp"></jsp:include>
</body>
</html>

