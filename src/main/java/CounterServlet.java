import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CounterServlet", urlPatterns = "/counter")
public class CounterServlet extends HttpServlet {
    public int counter = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("reset") != null && request.getParameter("reset").equalsIgnoreCase("reset")) {
            counter = 0;
        }
        counter++;
        response.getWriter().println("<h1>The page load count is: " + counter + "</h1>");
    }
}
