package table;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by FromxSoul on 07.06.2016.
 */
@SuppressWarnings("ALL")
@Entity
@Table(name = "user_m2m")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "firts_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "shop_experience")
    private int shopExperience;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<UserProducts> userProducts = new ArrayList<UserProducts>();

    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getShopExperience() {
        return shopExperience;
    }

    public void setShopExperience(int shopExperience) {
        this.shopExperience = shopExperience;
    }

    public List<UserProducts> getUserProducts() {
        return userProducts;
    }

    public void setUserProducts(List<UserProducts> userProducts) {
        this.userProducts = userProducts;
    }
}
