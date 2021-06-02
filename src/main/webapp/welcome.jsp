<%--
  Created by IntelliJ IDEA.
  User: Kelvon
  Date: 5/27/21
  Time: 9:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome, Marco</title>
    <%--must remember to not have any servlets listening on root --%>
    <link rel = "stylesheet" href = "css/styles.css">
</head>
<body>
<%@ include file="partials/navbar.jsp" %>
<% int counter = 0; %>
        <% counter++;
        request.setAttribute("age",24);
        request.setAttribute("numbers",new int[] { 1,2,3,4,5,6});
        %>

<h1>Hello, Marco</h1>

What is 1+1? <%= 1+1 %> would be the answer.

<p>This page was requested using the method <span><%=request.getMethod()%></span></p>
<p>Path: <%=request.getRequestURL()%></p>
<p>Name of parameter in query string <%=request.getParameter("name")%></p>
<p>name: ${param.name}</p>

<p>Kelvon is ${age} years old</p>
<div>This page has been viewed <%=counter %> times</div>

<%--<c:if test = "${age <= 10}" >--%>
<%--    <a href="http://www.neopets.com/"> Neopets for the win!</a>--%>
<%--</c:if>--%>

<%--<c:if test="${age >10}">--%>
<%--    <p>You really should go find stuff</p>--%>
<%--    <a href="http://www.google.com">Google</a>--%>
<%--</c:if>--%>
<ul>
<c:forEach items = "${numbers}" var="number">
<li>Item number ${number}</li>
</c:forEach>
</ul>
<c:choose>
    <c:when test ="${age <= 10}">
        <a href="http://www.neopets.com/"> Neopets for the win!</a>
    </c:when>
    <c:otherwise>
        <a href="http://www.google.com">Google</a>
    </c:otherwise>
</c:choose>
<!--Hello Marco -->
<script src="js/scripts.js"></script>
</body>
</html>
