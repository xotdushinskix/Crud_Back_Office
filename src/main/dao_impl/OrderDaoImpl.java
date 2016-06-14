package dao_impl;

import dao.OrderDao;
import org.hibernate.Session;
import table.Order;
import util.HibernateUtil;

import java.sql.SQLException;

/**
 * Created by FromxSoul on 07.06.2016.
 */
public class OrderDaoImpl implements OrderDao {
    public Order getOrderById(int orderId) throws SQLException {
        Order order = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            order = session.get(Order.class, orderId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return order;
    }


    public void addOrder(Order order) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }

    }

}
