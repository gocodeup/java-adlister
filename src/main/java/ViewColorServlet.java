import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/view-color")
public class ViewColorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String color = request.getParameter("viewcolor"); //?viewcolor={grabthevaluehere}
        request.setAttribute("viewColor", color);
        request.getRequestDispatcher("/view-color.jsp").forward(request, response);

    }
}
