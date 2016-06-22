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
 * Created by nikita on 16.06.16.
 */
@WebServlet("/login")
public class StartLogin extends Forward {
    private Fabric fabric = Fabric.getInstance();
    private AdminDao adminDao = fabric.getAdminDao();
    private Admin admin;
    private String LOGIN_PAGE = "/login.jsp";



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String adminLogin = request.getParameter("login");
        String adminPassword = request.getParameter("password");
        String message;


        if (adminLogin.length() == 0 & adminPassword.length() == 0) {
            message = "Login and password fields cannot be empty";
            request.setAttribute("message", message);
            super.forward(LOGIN_PAGE, request, response);
            return;
        }



        if (adminLogin.length() == 0) {
            message = "Login can not be empty";
            request.setAttribute("message", message);
            super.forward(LOGIN_PAGE, request, response);
        } else {
            if (adminPassword.length() == 0) {
                message = "Password can not be empty";
                request.setAttribute("message", message);
                super.forward(LOGIN_PAGE, request, response);

            } else {
                try {
                    admin = adminDao.getAdminByLogin(adminLogin);
                    admin.getAdminLogin();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                    message = "This customer doesn't register, login is invalid";
                    request.setAttribute("message", message);
                    super.forward(LOGIN_PAGE, request, response);
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
                        message = "Your password is invalid";
                        request.setAttribute("message", message);
                        super.forward(LOGIN_PAGE, request, response);
                    }

                } catch (NullPointerException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
    }






    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            super.requestAction(request);
            super.forward(LOGIN_PAGE, request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
