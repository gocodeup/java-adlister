<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/4/23
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Ads</title>
  </head>
  <body>

    <div class="container">

        <c:forEach var="ad" items="${ads}">

            <div>

                <p>Title: ${ad.title}</p>
                <p>Description: ${ad.description}</p>

            </div>

        </c:forEach>

    </div>
  </body>
</html>
