package util;

import dao.AdminDao;
import dao.OrderDao;
import dao.UserDao;
import fabric.Fabric;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import table.Admin;
import table.Order;
import table.User;
import table.UserProducts;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by FromxSoul on 08.06.2016.
 */
public class Main {

    public static void main (String[] args) throws SQLException {
        HibernateUtil.getSessionFactory();

        Fabric fabric = Fabric.getInstance();
        AdminDao adminDao = fabric.getAdminDao();
        OrderDao orderDao = fabric.getOrderDao();

        Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(UserProducts.class)
                .add(Restrictions.eq("order.orderId", 1));
        List<UserProducts> orderLines = criteria.list();

        for (UserProducts userProducts : orderLines) {
            userProducts.getProduct().getProductBrand();
            userProducts.getProduct().getProductModel();
            userProducts.getUser().getFirstName();
        }



//        Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(Order.class)
//                .add(Restrictions.eq("shipStatus", false));
//        List<Order>orders = criteria.list();
//        for (Order order :orders) {
//            System.out.println(order.getOrderId());
//        }


        //UserDao userDao = fabric.getUserDao();
//        List<User>users = userDao.getAllUsers();
//        for (User user : users) {
//            System.out.println(user.getUserId());
//        }


//        Admin admin = new Admin();
//        admin.setAdminLogin("admin");
//        admin.setAdminPassword("admin");
//        adminDao.addAdmin(admin);

    }

}
