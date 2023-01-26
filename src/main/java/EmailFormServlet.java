import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EmailFormServlet", urlPatterns = "/email-form")
public class EmailFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        writer.println("<form method=\"POST\" action=\"/register\">\n" +
                "    <label for=\"email\">Email:</label>\n" +
                "    <input id=\"email\" name=\"email\" placeholder=\"Enter your email address\" />\n" +
                "<button type='submit'>Submit</button></form>");

//        Request Object Methods:
//        req.getParameterValues(); = returns an array of strings for input checkboxes
//        req.getParameter(parameter-name); = returns value of parameter
//        req.getSession(); = returns a HttpSession object - more later..

//        Response Object Methods:
//        resp.sendRedirect(); = redirects to a different URL
//        resp.setContentType(); = sets the Content-Type of the response
//        resp.getRequestDispatcher(); = forwards the information to a Java Server Page (JSP) - more later..
    }
}
