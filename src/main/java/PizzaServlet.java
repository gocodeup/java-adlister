import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="PizzaServlet", urlPatterns="/pizza-order")
public class PizzaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/pizza.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        String pizzaSize = req.getParameter("size");
        String pizzaCrust = req.getParameter("crust");
        String pizzaSauce = req.getParameter("sauce");
        String[] pizzaToppings = req.getParameterValues("meat");

        System.out.println(pizzaSize);
        System.out.println(pizzaCrust);
        System.out.println(pizzaSauce);
        for(int i = 0; i < pizzaToppings.length; i++){
            System.out.println(pizzaToppings[i]);
        }

    }
}