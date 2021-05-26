import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "CountServer", urlPatterns = "/count")
public class Counter extends HttpServlet {
    private int counter = 0;

    public void init() {
        counter = 0;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("<h1>Hello from Counter!</h1>");

        counter++;

        response.getWriter().println("<h2> This is how many times you viewed this site: " + counter + "</h2>");






    }

}
