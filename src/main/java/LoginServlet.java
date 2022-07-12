import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        request.getRequestDispatcher("/login.jsp").forward(request, response);
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        String pass = request.getParameter("password");
//        if (userName.equals("admin") && pass.equals("password")) {
//            response.sendRedirect("/profile");
//        } else {
//            response.sendRedirect("/login");
//        }
        boolean validAttempt = true;
        if (validAttempt) {
            // TODO: store the logged in user object in the session, instead of just the username
            request.getSession().setAttribute("user", userName);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }
}

