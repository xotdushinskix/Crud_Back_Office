package table;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by FromxSoul on 07.06.2016.
 */
@SuppressWarnings("JpaAttributeTypeInspection")
@Entity
@Table(name = "user_products")
public class UserProducts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_product_id")
    private int userProductsId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "bought_quantity")
    private int boughtQuantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


    public int getUserProductsId() {
        return userProductsId;
    }

    public void setUserProductsId(int userProductsId) {
        this.userProductsId = userProductsId;
    }

    public int getBoughtQuantity() {
        return boughtQuantity;
    }

    public void setBoughtQuantity(int boughtQuantity) {
        this.boughtQuantity = boughtQuantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
