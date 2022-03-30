import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String output = "<h1>Hello, World!</h1>";

        if (request.getParameter("name") != null) {
            output = "<h1>Hello, " + request.getParameter("name") + "!</h1>";
        }

        PrintWriter out = response.getWriter();
        out.println(output);
    }
}
