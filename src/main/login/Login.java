package login;

import controller.Forward;
import dao.AdminDao;
import fabric.Fabric;
import table.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by nikita on 15.06.16.
 */
@WebServlet("/login/error")
public class Login extends Forward {

    private Fabric fabric = Fabric.getInstance();
    private AdminDao adminDao = fabric.getAdminDao();
    private Admin admin;


    private String INVALID_LOGIN = "/invalidLogin.jsp";
    private static String SHOW_ALL = "/allUserProduct.jsp";
    private String INVALID_PASSWORD = "/invalidPassword.jsp";
    private String EMPTY_LOGIN = "/emptyLogin.jsp";
    private String EMPTY_PASSWORD = "/emptyPassword.jsp";
    private String EMPTY_ALL = "/loginEmptyAllFields.jsp";


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String adminLogin = request.getParameter("login");
        String adminPassword = request.getParameter("password");


        if (adminLogin.length() == 0 & adminPassword.length() == 0) {
            super.forward(EMPTY_ALL, request, response);
            return;
        }



        if (adminLogin.length() == 0) {
            super.forward(EMPTY_LOGIN, request, response);
        } else {
            if (adminPassword.length() == 0) {
                super.forward(EMPTY_PASSWORD, request, response);

            } else {
                try {
                    admin = adminDao.getAdminByLogin(adminLogin);
                    admin.getAdminLogin();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                    super.forward(INVALID_LOGIN, request, response);
                }

                try {
                    String customerPassword = admin.getAdminPassword();
                    if (customerPassword.equals(adminPassword)) {
                        HttpSession session = request.getSession();
                        session.setAttribute("userLogin", adminLogin);

                        adminLogin = session.getAttribute("userLogin").toString();
                        admin = adminDao.getAdminByLogin(adminLogin);
                        response.sendRedirect("/main");

                    } else {
                        super.forward(INVALID_PASSWORD, request, response);
                    }

                } catch (NullPointerException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
