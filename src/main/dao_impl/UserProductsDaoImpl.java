package dao_impl;

import dao.UserProductsDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import table.Product;
import table.User;
import table.UserProducts;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by FromxSoul on 07.06.2016.
 */
public class UserProductsDaoImpl implements UserProductsDao {
    public UserProducts getUserProducts(int userProductsId) throws SQLException {
        UserProducts userProducts = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            userProducts = session.get(UserProducts.class, userProductsId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return userProducts;
    }



    public void editUserProducts(UserProducts userProducts) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(userProducts);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }



    public void deleteUserProducts(UserProducts userProducts) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(userProducts);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }



    public List<UserProducts> getAllUserProducts() throws SQLException {
        List<UserProducts> userProducts = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            userProducts = session.createCriteria(UserProducts.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return userProducts;
    }


    public UserProducts getUsProdByUserAndProds(User user, Product product) throws SQLException {
        Session session = null;
        UserProducts userProduct = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(UserProducts.class)
                    .add(Restrictions.like("user", user))
                    .add(Restrictions.like("product", product));
            userProduct = (UserProducts) criteria.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return userProduct;
    }



    public List<UserProducts> getAllUsProdByRequiredUserId(User user) throws SQLException {
        List<UserProducts>userProducts = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(UserProducts.class)
                    .add(Restrictions.like("user", user));
            userProducts = criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return userProducts;
    }
}
