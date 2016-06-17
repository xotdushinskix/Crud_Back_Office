package controller;

import dao.ProductDao;
import dao.UserDao;
import dao.UserProductsDao;
import fabric.Fabric;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import table.Product;
import table.User;
import table.UserProducts;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by FromxSoul on 07.06.2016.
 */
@SuppressWarnings("Since15")
@WebServlet("/main/operation")
public class ShowAll extends Forward {

    private static String ADD_EDIT_USER_PAGE = "/editAndAddUser.jsp";
    private static String ADD_EDIT_PRODUCT_PAGE = "/editAndADDProduct.jsp";
    private static String MAKE_PURCHASE = "/makePurchase.jsp";
    private static String SHOW_PURCHASE = "/showPurchase.jsp";
    private static String CHANGE_ORDER = "/changeProdQuantityInOrder.jsp";
    private static String CONFIRM_DELETE_PRODUCT = "/confirmDeleteProduct.jsp";
    private static String CONFIRM_DELETE_USER = "/confirmDeleteUser.jsp";
    private static String CHANGE_SHIP_STATUS = "/changeShipStatus.jsp";
    private static String ORDER_LINES = "/orderLines.jsp";
    private Fabric fabric = Fabric.getInstance();
    private UserDao userDao = fabric.getUserDao();
    private ProductDao productDao = fabric.getProductDao();
    private UserProductsDao userProductsDao = fabric.getUserProductsDao();
    private User user = new User();
    private Product product = new Product();
    private UserProducts userProducts = new UserProducts();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HibernateUtil.getSessionFactory();
        String forwardString = null;
        String action = request.getParameter("action");
        if (action.equals("updateUser")) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            try {
                user = userDao.getUser(userId);
                request.setAttribute("user", user);
                forwardString = ADD_EDIT_USER_PAGE;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (action.equals("deleteUser")) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            request.setAttribute("userId", userId);
            forwardString = CONFIRM_DELETE_USER;

        } else if (action.equals("addUser")) {
            forwardString = ADD_EDIT_USER_PAGE; //if add new user

        } else if (action.equals("updateProduct")) {
            int productId = Integer.parseInt(request.getParameter("productId"));
            try {
                product = productDao.getProduct(productId);
                request.setAttribute("product", product);
                forwardString = ADD_EDIT_PRODUCT_PAGE;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (action.equals("deleteProduct")) {
            int productId = Integer.parseInt(request.getParameter("productId"));
            request.setAttribute("productId", productId);
            forwardString = CONFIRM_DELETE_PRODUCT;

        } else if (action.equals("addProduct")) {
            forwardString = ADD_EDIT_PRODUCT_PAGE;

        } else if (action.equals("purchase")){
            int productId = Integer.parseInt(request.getParameter("productId"));
            try {
                product = productDao.getProduct(productId);
                request.setAttribute("product", product);
                forwardString = MAKE_PURCHASE;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (action.equals("watchUserPurchases")) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            try {
                user = userDao.getUser(userId);
                Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(UserProducts.class)
                        .add(Restrictions.eq("user.userId", userId))
                        .add(Restrictions.isNull("order.orderId"));
                List<UserProducts> userProducts = criteria.list();
                request.setAttribute("userProductsesNew", userProducts);
                request.setAttribute("userId", userId);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            forwardString = SHOW_PURCHASE;

        } else if (action.equals("deletePurchQuantity")) {
            int userProductsId = Integer.parseInt(request.getParameter("userProductsId"));

            int boughtQuantityForDelete = 0;
            try {
                boughtQuantityForDelete = userProductsDao.getUserProducts(userProductsId).getBoughtQuantity();
                int productIdForEdit = userProductsDao.getUserProducts(userProductsId).getProduct().getProductId();
                product = productDao.getProduct(productIdForEdit);
                int stock = product.getProductStock();
                product.setProductStock(stock + boughtQuantityForDelete);
                productDao.editProduct(product);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                userProducts = userProductsDao.getUserProducts(userProductsId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int userId = userProducts.getUser().getUserId();
            int prodId = userProducts.getProduct().getProductId();
            try {
                user = userDao.getUser(userId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                product = productDao.getProduct(prodId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            user.getUserProducts().clear();
            product.getUserProducts().clear();
            try {
                userDao.editUser(user);
                productDao.editProduct(product);
                userProductsDao.deleteUserProducts(userProducts);
                Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(UserProducts.class)
                        .add(Restrictions.eq("user.userId", userId))
                        .add(Restrictions.isNull("order.orderId"));
                List<UserProducts>userProducts = criteria.list();
                request.setAttribute("userProductsesNew", userProducts);
                request.setAttribute("userId", userId);
                forwardString = SHOW_PURCHASE;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if(action.equals("updatePurchQuantity")) {
            int userProductsId = Integer.parseInt(request.getParameter("userProductsId"));
            try {
                int productIdForEditQuantity = userProductsDao.getUserProducts(userProductsId).getProduct().getProductId();
                product = productDao.getProduct(productIdForEditQuantity);
                int prodQuantityInOrderBeforeEdit = userProductsDao.getUserProducts(userProductsId).getBoughtQuantity();
                request.setAttribute("product", product);
                request.setAttribute("prodQuantityInOrderBeforeEdit", prodQuantityInOrderBeforeEdit);
                request.setAttribute("userId", userProductsDao.getUserProducts(userProductsId).getUser().getUserId());
                request.setAttribute("userProductsId", userProductsId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            forwardString = CHANGE_ORDER;

        } else if (action.equals("changeShipStatus")) {
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            request.setAttribute("orderId", orderId);
            forwardString = CHANGE_SHIP_STATUS;
        } else if (action.equals("orderLine")) {
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(UserProducts.class)
                    .add(Restrictions.eq("order.orderId", orderId));
            List<UserProducts> orderLines = criteria.list();
            request.setAttribute("orderLines", orderLines);
            forwardString = ORDER_LINES;
        }

        super.forward(forwardString, request, response);
    }

}

