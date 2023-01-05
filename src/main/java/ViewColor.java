import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(name = "/ViewColor", urlPatterns = "/viewcolor.jsp")
public class ViewColor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String color = request.getParameter("color");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<title>ViewColor</title>");
            out.println("<style>");
            out.println("html {");
            out.println("background-color: " +  color + ";");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
