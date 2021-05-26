import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
//added

    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException {
        String name = req.getParameter("name");
        if( name == null){
            name = "World";
            res.getWriter().println("<h1>Hello World</h1>");
        }

        res.getWriter().println("<h1> hello, " + name + " !</h1>");


    }

}
