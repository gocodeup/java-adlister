import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "CounterServlet", urlPatterns = "/count")
public class CounterServlet extends HttpServlet {
    int count  = 0;
//added
    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException {
      String reset = req.getParameter("reset");
      if(reset !=  null){
          count = 0;
      }

        count++;
        res.getWriter().println("this page has been visited " + count + " times!");


    }

}

