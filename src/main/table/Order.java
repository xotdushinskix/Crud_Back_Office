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

    @Column(name = "created")
    private String currentData;

    @Column(name = "ship")
    private Boolean shipStatus;

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

    public String getCurrentData() {
        return currentData;
    }

    public void setCurrentData(String currentData) {
        this.currentData = currentData;
    }

    public Boolean getShipStatus() {
        return shipStatus;
    }

    public void setShipStatus(Boolean shipStatus) {
        this.shipStatus = shipStatus;
    }
}

