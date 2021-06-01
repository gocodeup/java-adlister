package MvcLecture;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name= "ShowProductServlet", urlPatterns = "/products")
public class ShowProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //"Hey Servlet go instantiate from that getProductsDao method i set up! == get a DAI object
        Products productsDao= DaoFactory.getProductsDao();

        //Let's go get the products

        List<Product> showProducts = productsDao.all();


        req.setAttribute("products", showProducts);
        req.getRequestDispatcher("/productIndex.jsp").forward(req, res);
        //
    }
}
