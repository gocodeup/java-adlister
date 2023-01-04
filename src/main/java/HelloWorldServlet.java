import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(name = "HelloWorldServlet", urlPatterns = "/java-adlister/hello-world")
public class HelloWorldServlet extends HttpServlet {
    private int hitCount;

    public void init() {
        // Reset hit counter.
        hitCount = 0;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        hitCount++;


        if (name == null) {
            out.println("<h1>Hello, World!</h1>");
            out.println("<h2>HEy there</h2>");

            out.println("<h2>Hello, " + hitCount + "!</h2>");
        } else {
            out.println("<h1>Hello, " + name + "!</h1>");
            out.println("<h2>HEy there</h2>");

            out.println("<h2>Hello, " + hitCount + "!</h2>");
        }

    }

}
