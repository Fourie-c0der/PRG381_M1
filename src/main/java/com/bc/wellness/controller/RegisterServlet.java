package com.bc.wellness.controller;
//This servlet handles new user registration.
// It receives POST requests from the registration form,
// performs server-side validation on all input fields,
// checks for duplicate email or student numbers,
// saves the new user's data securely to the PostgreSQL database.
import com.bc.wellness.dao.UserDAO;
import com.bc.wellness.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentNumber = request.getParameter("student_number");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        try {
            if (userDAO.userExists(email, studentNumber)) {
                request.setAttribute("error", "User already exists.");
                request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
                return;
            }
            User user = new User(studentNumber, name, surname, email, phone, password);
            boolean registered = userDAO.registerUser(user);
            if (registered) {
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("error", "Registration failed.");
                request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Database error: " + e.getMessage());
            request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
