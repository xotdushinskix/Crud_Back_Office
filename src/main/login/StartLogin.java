package login;

import controller.Forward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by nikita on 16.06.16.
 */
@WebServlet("/login")
public class StartLogin extends Forward {
    private String forwardString = "/login.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            super.requestAction(request);
            super.forward(forwardString, request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
