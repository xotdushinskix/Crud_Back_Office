package dao;

import table.Admin;

import java.sql.SQLException;

/**
 * Created by nikita on 15.06.16.
 */
public interface AdminDao {

    Admin getAdminById(String adminId) throws SQLException;
    void addAdmin(Admin admin) throws SQLException;
    Admin getAdminByLogin(String adminLogin) throws SQLException;

}
