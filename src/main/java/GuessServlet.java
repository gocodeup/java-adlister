import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="GuessServlet", urlPatterns = "/guess")
public class GuessServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/guess.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int random = (int) Math.ceil(Math.random()*3);
        int guess = Integer.parseInt(req.getParameter("guess"));
        if(random == guess){
            res.sendRedirect("/correct");
        } else if (guess != 1 && guess != 2 && guess != 3){
            res.sendRedirect("/guess");
        } else {
            res.sendRedirect("/incorrect");
        }
    }
}