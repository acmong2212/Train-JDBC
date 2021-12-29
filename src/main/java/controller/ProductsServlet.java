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
import java.util.List;

@WebServlet(urlPatterns = "")
public class ProductsServlet extends HttpServlet {
    ProductsService productsService = new ProductsService();
    List<Products> products = productsService.fillAll();
    RequestDispatcher dispatcher;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "delete":
                int idDelete = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("idDelete", idDelete);
                dispatcher = req.getRequestDispatcher("/view/DeleteProducts.jsp");
                dispatcher.forward(req, resp);
                break;
            case "edit":
                int indexEdit = Integer.parseInt(req.getParameter("id"));
                Products products = productsService.fillAll().get(productsService.findIndexById(indexEdit));

                req.setAttribute("indexEdit", indexEdit);
                req.setAttribute("editProducts", products);
                dispatcher = req.getRequestDispatcher("/view/EditProducts.jsp");
                dispatcher.forward(req, resp);
                break;
            default:
                showHome(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    private void showHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", products);
        dispatcher = req.getRequestDispatcher("/view/home.jsp");
        dispatcher.forward(req, resp);
    }
}
