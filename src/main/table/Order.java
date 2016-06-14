package table;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by FromxSoul on 07.06.2016.
 */
@Entity
@Table(name = "order_final")
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @OneToMany(mappedBy = "order")
    private List<UserProducts> userProducts = new ArrayList<UserProducts>();

    public Order() {

    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<UserProducts> getUserProducts() {
        return userProducts;
    }

    public void setUserProducts(List<UserProducts> userProducts) {
        this.userProducts = userProducts;
    }
}

