<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nicholasdiazjr
  Date: 2/14/22
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
    <%--    needed this for css stylesheet!!   --%>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <title>Search</title>

</head>
<body>
<div class="row no-gutter">
    <%--        //add a sticky?--%>
    <div class="h-100 col-2 pt-4">
        <%--            add side image??  --%>
        <div id="side-img">
            <nav id="side-nav" class="nav flex-column">
                <%--                    add specific items/categories later--%>
                <a class="w-text nav-link active pl-5" href="/category?value=0">All</a>
                <a class="w-text nav-link active pl-5" href="/category?value=1"><i class="fa fa-example"></i>Cat. name</a>
                <a class="w-text nav-link active pl-5" href="/category?value=2"><i class="fa fa-example"></i>Cat. name</a>
                <a class="w-text nav-link active pl-5" href="/category?value=3"><i class="fa fa-example"></i>Cat. name</a>
                <a class="w-text nav-link active pl-5" href="/category?value=4"><i class="fa fa-example"></i>Cat. name</a>
                <a class="w-text nav-link active pl-5" href="/category?value=5"><i class="fa fa-example"></i>Cat. name</a>
                <a class="w-text nav-link active pl-5" href="/category?value=6"><i class="fa fa-example"></i>Cat. name</a>
                <a class="w-text nav-link active pl-5" href="/category?value=7"><i class="fa fa-example"></i>Cat. name</a>
                <a class="w-text nav-link active pl-5" href="/category?value=8">Other</a>
            </nav>
        </div>
    </div>
    <div class="col-10">
        <h1 class="w-text">Category of the Ads</h1>
        <c:if test="${zeroResults == true}">
            <p class="w-text">No results for <c:out value="${keyword}" /></p>
        </c:if>

        <c:if test="${zeroResults == false}">
            <h3 class="w-text">All ads in reference to: <c:out value="${keyword}" /></h3>
            <c:forEach var="ad" items="${ads}">
                <a class="blk" href="/viewAd?adId=${ad.id}">
                    <div class="cards mr-3 mb-3">
                        <h2>${ad.title}</h2>
                        <p>${ad.descritpion}</p>
                        <p>Created date: ${ad.dateCreated}</p>
                        <p>Categories: ${ad.category}</p>
                    </div>
                </a>
            </c:forEach>
        </c:if>
    </div>
<%--   Do we need/want a footer?--%>
</div>

</body>
</html>
