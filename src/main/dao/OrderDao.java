package dao;

import table.Order;

import java.sql.SQLException;

/**
 * Created by FromxSoul on 07.06.2016.
 */
public interface OrderDao {

    Order getOrderById(int orderId) throws SQLException;
    void addOrder(Order order) throws SQLException;

}
