package com.codeup.adlister.controllers;

        import com.codeup.adlister.dao.DaoFactory;

        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

@WebServlet(name = "controllers.TestServlet", urlPatterns = "/test")
 class TestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = DaoFactory.getUsersDao().findById(1L).getUsername();

        System.out.println("/test was ran");

        response.getWriter().println("name is " + name);
    }
}
