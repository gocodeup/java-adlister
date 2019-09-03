<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="/WEB-INF/messages.jsp" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">
    <h1>Please Log In</h1>
    <c:if test="${sessionScope.error != null}">
        <h3 style='color:red; text-align: center'>"${sessionScope.error}"</h3>
        <% request.getSession().removeAttribute("error");%>
    </c:if>

    <form action="/login" method="POST">
        <div class="form-group">
            <label for="username">Username</label>
            <c:choose>
                <c:when test="${sessionScope.username!=null}">
                    <input id="username" name="username" class="form-control" type="text" value= ${sessionScope.username}>
                    <%request.getSession().removeAttribute("username");%>
                </c:when>
                <c:otherwise>
                    <input id="username" name="username" class="form-control" type="text">
                </c:otherwise>
            </c:choose>
            <input type="hidden" name="from" value="${param.from}"/>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input id="password" name="password" class="form-control" type="password">
        </div>
        <input type="submit" class="btn btn-primary btn-block" value="Log In">
    </form>
</div>
</body>
</html>
