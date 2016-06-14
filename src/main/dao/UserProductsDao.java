package dao;

import table.Product;
import table.User;
import table.UserProducts;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by FromxSoul on 07.06.2016.
 */
public interface UserProductsDao {

    UserProducts getUserProducts(int userProductsId) throws SQLException;
    void editUserProducts(UserProducts userProducts) throws SQLException;
    void deleteUserProducts(UserProducts userProducts) throws SQLException;
    List<UserProducts> getAllUserProducts() throws SQLException;
    UserProducts getUsProdByUserAndProds(User user, Product product) throws SQLException;
    List<UserProducts> getAllUsProdByRequiredUserId(User user) throws SQLException;

}
