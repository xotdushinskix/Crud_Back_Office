package util;

import dao.UserDao;
import fabric.Fabric;
import table.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by FromxSoul on 08.06.2016.
 */
public class Main {

    public static void main (String[] args) throws SQLException {
        HibernateUtil.getSessionFactory();

        Fabric fabric = Fabric.getInstance();
        UserDao userDao = fabric.getUserDao();


        List<User>users = userDao.getAllUsers();
        for (User user : users) {
            System.out.println(user.getUserId());
        }
    }

}
