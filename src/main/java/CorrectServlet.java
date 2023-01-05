import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(name = "CorrectServlet", urlPatterns = "/CorrectServlet")
public class CorrectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination = "/choice.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
        String won = "<h1>You Won</h1>";
        request.setAttribute("won", won);
        requestDispatcher.forward(request, response);
        response.sendRedirect("/choice.jsp");
    }


}