package controller;

import dao.ProductDao;
import dao.UserDao;
import fabric.Fabric;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by nikita on 15.06.16.
 */
@WebServlet("/delete")
public class Delete extends Forward {
    private Fabric fabric = Fabric.getInstance();
    private ProductDao productDao = fabric.getProductDao();
    private UserDao userDao = fabric.getUserDao();
    private String SHOW_ALL = "/main";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forwardString = null;
        if (request.getParameter("delete_product") != null) {
            int productId = Integer.parseInt(request.getParameter("productId"));
            try {
                productDao.deleteProduct(productDao.getProduct(productId));
                super.requestAction(request);
                forwardString = SHOW_ALL;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (request.getParameter("delete_user") != null) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            try {
                userDao.deleteUser(userDao.getUser(userId));
                super.requestAction(request);
                forwardString = SHOW_ALL;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect(forwardString);
    }
}
