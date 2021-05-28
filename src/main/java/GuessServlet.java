import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

import static java.lang.Integer.parseInt;

@WebServlet(name = "GuessServlet", urlPatterns = "/guess")
public class GuessServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("guessgame.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (request.getMethod().equalsIgnoreCase("POST")) {
            String guess = request.getParameter("guess");

            int numberGuessed = parseInt(guess);

            if (numberGuessed >= 1 & numberGuessed <= 3) {
                response.sendRedirect("/correct");
            } else {
                response.sendRedirect("/incorrect");
            }
        }
    }

}
