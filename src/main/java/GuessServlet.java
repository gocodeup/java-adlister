import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(name = "GuessServlet", urlPatterns = "/GuestServlet")
public class GuessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String guess = request.getParameter("guess");
        if (guess.equals("2")) {

            response.sendRedirect("/CorrectServlet");
        } else {
            response.sendRedirect("/IncorrectServlet");
        }
        PrintWriter out = response.getWriter();
    }


}