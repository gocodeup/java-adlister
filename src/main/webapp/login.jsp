<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@WebServlet(name = "LoginPage", urlPatterns = "/login.jsp")--%>
<%--public class HelloWorldServlet1 extends HttpServlet {--%>

<%--@Override--%>
<%--protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {--%>
<%--response.setContentType("text/html");--%>
<%--PrintWriter out = response.getWriter();--%>
<%--out.println("<h1>Hello, World!</h1>");--%>
<%--}--%>
<%--}--%>

<%
    if(request.getMethod().equals("POST")) {
        String userName = request.getParameter("userName");
        String pass = request.getParameter("pass");
        if (userName.equals("admin") && pass.equals("password")) {
            response.sendRedirect("/profile.jsp");
        }
    }

%>

<html>
<head>
    <title>LoginServlet page</title>
</head>
<body>
<div class="container">
    <div class="row">
        <form action="/login.jsp" method="POST">
            <div class="form-group">
                <h1>This is where you login</h1>
            </div>
            <div class="form-group">
                <lebel>Username:</lebel>
                <input type="text" id="userName" name="userName" class="form-control">
            </div>
            <div class="form-group">
                <lebel>Password:</lebel>
                <input type="password" id="pass" name="pass" class="form-control">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-success">Submit</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
