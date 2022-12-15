import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello-world")
public class HelloWorldServlet extends HttpServlet {
    private int hitCount;
    public void init() {
        // Reset hit counter.
        hitCount = 0;
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        hitCount++;
        String title = "Count of total number of hits";
        String docType
                = "<!doctype html public \"-//w3c//dtd html 4.0 "
                + "transitional//en\">\n";
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello, World!</h1>");
        out.println(
                docType + "<html>\n"
                        + "<head><title>" + title + "</title></head>\n"
                        + "<body bgcolor = \"#f0f0f0\">\n"
                        + "<h1 align = \"center\">" + title + "</h1>\n"
                        + "<h2 align = \"center\">" + hitCount
                        + "</h2>\n"
                        + "</body>"
                        + "</html>");
    }

}

