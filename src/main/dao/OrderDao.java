package dao;

import table.Order;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by FromxSoul on 07.06.2016.
 */
public interface OrderDao {

    Order getOrderById(int orderId) throws SQLException;
    void addOrder(Order order) throws SQLException;
    void editOrder(Order order) throws SQLException;
    List<Order> getAllOrders() throws SQLException;

}
