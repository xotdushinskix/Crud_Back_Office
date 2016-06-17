package controller;

import dao.OrderDao;
import dao.ProductDao;
import dao.UserDao;
import fabric.Fabric;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import table.Order;
import util.HibernateUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by FromxSoul on 07.06.2016.
 */
public class Forward extends HttpServlet {
    private Fabric fabric = Fabric.getInstance();
    private UserDao userDao = fabric.getUserDao();
    private ProductDao productDao = fabric.getProductDao();
    private OrderDao orderDao = fabric.getOrderDao();

    protected void forward(String to, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(to);
        requestDispatcher.forward(request, response);
//        response.sendRedirect(to);
    }


    protected void requestAction(HttpServletRequest request) throws ServletException, IOException, SQLException {
        request.setAttribute("users", userDao.getAllUsers());
        request.setAttribute("products", productDao.getAllProducts());
        Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(Order.class)
                .add(Restrictions.eq("shipStatus", false));
        List<Order> ordersDNShip = criteria.list();

        Criteria criteria1 = HibernateUtil.getSessionFactory().openSession().createCriteria(Order.class)
                .add(Restrictions.eq("shipStatus", true));
        List<Order> ordersShip = criteria1.list();

        request.setAttribute("ordersDNShip", ordersDNShip);
        request.setAttribute("ordersShip", ordersShip);
    }




}
