package dao;

import table.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by FromxSoul on 07.06.2016.
 */
public interface ProductDao {

    void addProduct(Product product) throws SQLException;
    void deleteProduct(Product product) throws SQLException;
    void editProduct(Product product) throws SQLException;
    Product getProduct(int productId) throws SQLException;
    List<Product> getAllProducts() throws SQLException;

}
