import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet ",urlPatterns = "/helloLecture")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        if(name == null){
           name = "World";
        }else if(name .equalsIgnoreCase("kelvon")){
            name = "Mr.Patterson";
        }
        request.setAttribute("viewName", name);
        request.getRequestDispatcher("/hello.jsp").forward(request,response);
    }
}
