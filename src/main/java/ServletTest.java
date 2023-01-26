import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletTest", urlPatterns = "/icon-servlet")
public class ServletTest extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        String favColor = req.getParameter("color");

        String favFood = req.getParameter("food");

        writer.println("<h1 style='color: "+ favColor + "'>Hello Icon!</h1><p>My favorite food is: " + favFood + "</p>");

    }

}
