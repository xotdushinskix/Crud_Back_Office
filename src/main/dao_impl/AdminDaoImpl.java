package dao_impl;

import dao.AdminDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import table.Admin;
import util.HibernateUtil;

import java.sql.SQLException;

/**
 * Created by nikita on 15.06.16.
 */
public class AdminDaoImpl implements AdminDao {
    public Admin getAdminById(String adminId) throws SQLException {
        Admin admin = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            admin = session.get(Admin.class, adminId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return admin;
    }



    public void addAdmin(Admin admin) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(admin);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }



    public Admin getAdminByLogin(String adminLogin) throws SQLException {
        Session session = null;
        Admin admin = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Admin.class)
                    .add(Restrictions.like("adminLogin", adminLogin));
            admin = (Admin) criteria.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return admin;
    }
}
