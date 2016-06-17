package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by nikita on 16.06.16.
 */
@WebServlet("/main")
public class MainView extends Forward {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            super.requestAction(request);
            String forwardString = "/allUserProduct.jsp";
            super.forward(forwardString, request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
