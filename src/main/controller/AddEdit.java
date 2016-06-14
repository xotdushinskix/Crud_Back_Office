package controller;

import dao.ProductDao;
import dao.UserDao;
import fabric.Fabric;
import table.Product;
import table.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by FromxSoul on 07.06.2016.
 */
@SuppressWarnings("Since15")
@WebServlet("/AddEdit")
public class AddEdit extends Forward {

    private static String SHOW_ALL = "/allUserProduct.jsp";
    private Fabric fabric = Fabric.getInstance();
    private UserDao userDao = fabric.getUserDao();
    private ProductDao productDao = fabric.getProductDao();
    private Product product = new Product();
    private User user = new User();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("addEditProduct") != null) {

            String productBrand = request.getParameter("productbrand");
            String productModel = request.getParameter("productmodel");
            int productStock = Integer.parseInt(request.getParameter("productstock"));
            int productMPN = Integer.parseInt(request.getParameter("productmpn"));

            product.setProductBrand(productBrand);
            product.setProductModel(productModel);
            product.setProductStock(productStock);
            product.setProductMPN(productMPN);

            String productId = request.getParameter("productIdAddEditPage");
            if (productId.isEmpty()) {
                try {
                    productDao.addProduct(product);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                product.setProductId(Integer.parseInt(productId));
                try {
                    productDao.editProduct(product);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                super.requestAction(request);
            } catch (SQLException e) {
                e.printStackTrace();
            }



        } else if (request.getParameter("addEditUser") !=null) {
            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            int shopExperience = Integer.parseInt(request.getParameter("shopexperience"));

            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setShopExperience(shopExperience);

            String userId = request.getParameter("userIdAddEditPage");
            if (userId.isEmpty()) {
                try {
                    userDao.addUser(user);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                user.setUserId(Integer.parseInt(userId));
                try {
                    userDao.editUser(user);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                super.requestAction(request);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        super.forward(SHOW_ALL, request, response);
    }
}
