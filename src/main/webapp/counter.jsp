<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! int counter = 0; int two = 2; %>
<% counter += 1; System.out.println("This is in console");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>The current count is <%= counter %>.</h1>

<p> Your number is <%= two %></p>

<p>The current date is <%= java.time.LocalDate.now() %></p>

View the page source!

<%-- this is a JSP comment, you will *not* see this in the html --%>

<!-- this is an HTML comment, you *will* see this in the html -->

</body>
</html>
