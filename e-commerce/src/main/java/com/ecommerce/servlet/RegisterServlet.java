package com.ecommerce.servlet;

import com.ecommerce.metier.GestionUser;
import com.ecommerce.metier.IGestionUser;
import com.ecommerce.model.User;
import com.ecommerce.utils.FunctionsUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private IGestionUser gestionUser;

    @Override
    public void init() {
        gestionUser = new GestionUser(); // Using the Metier layer
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to the registration page (GET request)
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        try {
            gestionUser.registerUser(user); // Will throw exception if password is invalid
            response.sendRedirect("login.jsp"); // Redirect to login page on success
        } catch (IllegalArgumentException e) {
            // If password is invalid, show an error message
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database error during registration", e);
        }
    }
}
