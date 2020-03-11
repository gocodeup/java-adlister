<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="../partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>
    <div class="row">
    <c:forEach var="ad" items="${ads}">
        <br>
            <div class="col-12 col-md-4 mb-1">
                <div class="text-center card shadow p-3 mt-5 mb-5 bg-white rounded" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">${ad.title}</h5>
                        <%--            <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>--%>
                    <p class="card-text">${ad.description}</p>
                    <form action = "/adDetails" method="POST">
                        <button name="button" class="edit button" type=submit value="${ad.id}">adDetails</button>
                    </form>
<%--                    <a href="#" class="card-link">Card link</a>--%>
<%--                    <a href="#" class="card-link">Another link</a>--%>
                </div>
                </div>
<%--            <form action = "/adDetails" method="POST">--%>
<%--                <button name="button" class="edit button" type=submit value="${ad.id}">adDetails</button>--%>
<%--            </form>--%>
        </div>
    </c:forEach>
    </div>
    <br>
</div>

</body>
</html>
