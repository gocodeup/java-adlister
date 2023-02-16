<%@ page import="com.codeup.adlister.models.User" %>
<%@ page import="com.codeup.adlister.models.Ad" %>
<%@ page import="com.codeup.adlister.dao.DaoFactory" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Ad Page" />
  </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container-expand center p-4 card-txt">


    <div class="card ad-card card-border">
      <div class="card-body">
        <h1>${ad.title}</h1>
        <br>
        <h2>${ad.description}</h2>
        <br>
        <h2>Ad created by: ${user.username}</h2>
        <br>
        <% User user =(User) request.getSession().getAttribute("user");

          if (user == null) {
        %>
        <p>Own this ad? <a class="adPage-login" href="/login">Login</a> to update or delete this ad.</p>
        <%
        } else {
          Long currentUser = user.getId();
          long adId = Long.parseLong(request.getParameter("adId"));
          User adUser = DaoFactory.getUsersDao().getUserByAd(adId);
          Long adUserId = adUser.getId();
          if (currentUser == adUserId) {
        %> <a class="btn update-redirect" href="/ads/update?adId=${ad.getId()}">Update Ad</a>
        <%
            }
          }
        %>
      </div>
    </div>

<%--    <h1>${ad.title}</h1>--%>
<%--    <h2>${ad.description}</h2>--%>
<%--    <h2>Ad created by: ${user.username}</h2>--%>

<%--  <% User user =(User) request.getSession().getAttribute("user");--%>

<%--    if (user == null) {--%>
<%--  %>--%>
<%--  <p>Own this ad? <a href="/login">Login</a> to update or delete this ad.</p>--%>
<%--  <%--%>
<%--  } else {--%>
<%--    Long currentUser = user.getId();--%>
<%--    long adId = Long.parseLong(request.getParameter("adId"));--%>
<%--    User adUser = DaoFactory.getUsersDao().getUserByAd(adId);--%>
<%--    Long adUserId = adUser.getId();--%>
<%--      if (currentUser == adUserId) {--%>
<%--  %> <a href="/ads/update?adId=${ad.getId()}">Update Ad</a>--%>
<%--  <%--%>
<%--      }--%>
<%--    }--%>
<%--  %>--%>
</div>

</body>
</html>
