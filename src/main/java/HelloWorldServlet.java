import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



    @WebServlet(name = "HelloWorld", urlPatterns = "/hello")// metadata to go along with our servlet
    public class HelloWorldServlet extends HttpServlet { // defining the class name / extending from HttpServlet
//        private int counter = 0;
//
//        public void init() {
//
//        }
        // Put doGet doPost methods in here
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

            String name = request.getParameter("name");
            response.getWriter().println("<h1>Hello World!</h1");
            response.getWriter().printf("<h1>Hello, %s !</h1>", name);

//            counter++;
//            response.getWriter().println("<h3>This is how many times you viewed the page: " + counter + " </h3>");







        }
    }

