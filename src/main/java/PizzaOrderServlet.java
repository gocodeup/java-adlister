import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="PizzaOrderServlet", urlPatterns = "/pizza-order")
public class PizzaOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pizza-order.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("crust"));
        System.out.println(req.getParameter("sauce"));
        System.out.println(req.getParameter("crust-size"));
        System.out.println(req.getParameter("pepperoni"));
        System.out.println(req.getParameter("sausage"));
        System.out.println(req.getParameter("bacon"));
        System.out.println(req.getParameter("onion"));
        System.out.println(req.getParameter("mushrooms"));
        System.out.println(req.getParameter("pineapple"));
        System.out.println(req.getParameter("address"));
       req.getRequestDispatcher("/pizza-order.jsp").forward(req,resp);
    }
}
