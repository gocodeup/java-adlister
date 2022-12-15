import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    private int hitCount;

    public void init() {
        // Reset hit counter.
        hitCount = 0;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        hitCount++;
        response.setContentType("text/html");
        String name = request.getParameter("name");
        PrintWriter out = response.getWriter();
        String edge = name == (null)||name.isEmpty()?"World":name;
        String query = request.getParameter("some");
        if (query != null) {
            hitCount = 0;
        }
        out.printf("<h1>Hello, %s</h1>", edge);
        out.println("Here is the count " + hitCount);
        out.println("<h2>HEy there</h2>");
        out.println("<form method=POST action=/hello> <label for=email>Email:</label> <input id=email name=email placeholder=Enter your name /> </form>");
        }
     @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         String emailID = request.getParameter("email");
        PrintWriter in = response.getWriter();
        in.println("<h1> Hello "  + emailID + "</h1>");

     }


}
