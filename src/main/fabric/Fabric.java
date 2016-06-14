package fabric;

import dao.OrderDao;
import dao.ProductDao;
import dao.UserDao;
import dao.UserProductsDao;
import dao_impl.OrderDaoImpl;
import dao_impl.ProductDaoImpl;
import dao_impl.UserDaoImpl;
import dao_impl.UserProductsDaoImpl;

/**
 * Created by FromxSoul on 07.06.2016.
 */
public class Fabric {

    private static UserDao userDao = null;
    private static ProductDao productDao = null;
    private static UserProductsDao userProductsDao = null;
    private static OrderDao orderDao = null;
    private static Fabric instance = null;

    public static synchronized Fabric getInstance() {
        if (instance == null) {
            instance = new Fabric();
        }
        return instance;
    }


    public static synchronized UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }


    public static synchronized ProductDao getProductDao() {
        if (productDao == null) {
            productDao = new ProductDaoImpl();
        }
        return productDao;
    }


    public static synchronized UserProductsDao getUserProductsDao() {
        if (userProductsDao == null) {
            userProductsDao = new UserProductsDaoImpl();
        }
        return userProductsDao;
    }


    public static synchronized OrderDao getOrderDao() {
        if (orderDao == null) {
            orderDao = new OrderDaoImpl();
        }
        return orderDao;
    }


}
