<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.codeup.adlister.models.User" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}<c:url value="/ads"/>">Adlister</a>
            <a class="navbar-brand" href="${pageContext.request.contextPath}<c:url value="/ads/create"/>">Create an Ad</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <% User user = (User) session.getAttribute("user");
            if (user == null) {
            %>
            <li><jsp:include page="/WEB-INF/partials/search.jsp"/></li>
            <li><a href="${pageContext.request.contextPath}<c:url value="/register"/>">Register</a></li>
            <li><a href="${pageContext.request.contextPath}<c:url value="/login"/>">Login</a></li>
            <%
            }else{
            %>
            <li><jsp:include page="/WEB-INF/partials/search.jsp"/></li>
            <li><a href="${pageContext.request.contextPath}<c:url value="/profile"/>"><i class="fa-solid fa-user"></i> Profile</a></li>
            <li><a href="${pageContext.request.contextPath}<c:url value="/logout"/>"><i class="fa-solid fa-right-from-bracket"></i> Logout</a></li>
            <%
                }
            %>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<%--Fontawesome JS--%>
<script src="https://kit.fontawesome.com/cc15ef4101.js" crossorigin="anonymous"></script>
