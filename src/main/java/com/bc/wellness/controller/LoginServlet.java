package com.bc.wellness.controller;
// servlet acts as the controller for user authentication.
/*It receives POST requests from the login form, validates
the user's credentials against the PostgreSQL database using the UserDAO,
 and redirects the user to dashboard.jsp upon success or
 error.jsp if authentication fails.
 */
import com.bc.wellness.dao.UserDAO;
import com.bc.wellness.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        try {
            User user = userDAO.validateUser(email, password);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("username", user.getName());
                session.setAttribute("email", user.getEmail());
                response.sendRedirect("WEB-INF/jsp/dashboard.jsp");
            } else {
                request.setAttribute("error", "Invalid email or password.");
                request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Database error: " + e.getMessage());
            request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
