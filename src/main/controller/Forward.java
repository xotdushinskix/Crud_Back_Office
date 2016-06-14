package controller;

import dao.ProductDao;
import dao.UserDao;
import fabric.Fabric;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by FromxSoul on 07.06.2016.
 */
public class Forward extends HttpServlet {
    private Fabric fabric = Fabric.getInstance();
    private UserDao userDao = fabric.getUserDao();
    private ProductDao productDao = fabric.getProductDao();

    protected void forward(String to, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(to);
        requestDispatcher.forward(request, response);
    }


    protected void requestAction(HttpServletRequest request) throws ServletException, IOException, SQLException {
        request.setAttribute("users", userDao.getAllUsers());
        request.setAttribute("products", productDao.getAllProducts());
    }

}
