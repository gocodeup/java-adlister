import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name="GuessServlet", urlPatterns = "/guess")
public class GuessServlet extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String guess = request.getParameter("guess");
        int random = (int) Math.floor((Math.random() * 3) + 1);
        String randomNumString = Integer.toString(random);

         if(guess.equalsIgnoreCase(randomNumString)){
            response.sendRedirect("/correct.jsp");
        }else if(!guess.equalsIgnoreCase(randomNumString)){
            response.sendRedirect("/incorrect.jsp");
        }
    }
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/guess.jsp").forward(request, response);

    }
}
