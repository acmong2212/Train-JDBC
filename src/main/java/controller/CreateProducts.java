package controller;

import Service.ProductsService;
import dao.ProductDao;
import model.Products;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/create")
public class CreateProducts extends HttpServlet {
    ProductsService productsService = new ProductsService();
    RequestDispatcher dispatcher;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/view/CreateProducts.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("addName");
        int price = Integer.parseInt(req.getParameter("addPrice"));
        String img = req.getParameter("addImage");

        try {
            productsService.createProduct(new Products(name, price, img));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("products", productsService.fillAll());
        dispatcher = req.getRequestDispatcher("/view/home.jsp");
        dispatcher.forward(req, resp);
    }
}
