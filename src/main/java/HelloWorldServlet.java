import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello-world")
public class HelloWorldServlet extends HttpServlet {
    private int hitCount;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello, World!</h1>");

        // Set response content type
        response.setContentType("text/html");

        // This method executes whenever the servlet is hit
        // increment hitCount
        hitCount++;
        PrintWriter out2 = response.getWriter();
        String title = "Times you've visited page";
        String docType
                = "<!doctype html public \"-//w3c//dtd html 4.0 "
                + "transitional//en\">\n";

        response.getWriter().println("You should see this in the browser");

        out2.println(
                docType + "<html>\n"
                        + "<head><title>" + title + "</title></head>\n"
                        + "<body bgcolor = \"#f0f0f0\">\n"
                        + "<h1 align = \"center\">" + title + "</h1>\n"
                        + "<h2 align = \"center\">" + hitCount
                        + "</h2>\n"
                        + "</body>"
                        + "</html>");
//        The information being appended to the HTML page
    }

}


