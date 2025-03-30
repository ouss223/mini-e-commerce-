package com.ecommerce.servlet;

import com.ecommerce.metier.GestionUser;
import com.ecommerce.metier.IGestionUser;
import com.ecommerce.model.User;

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
            gestionUser.registerUser(user);
            response.sendRedirect("login");
        } catch (IllegalArgumentException e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                request.setAttribute("errorMessage", "The email is already registered. Please choose a different one.");
            } else {
                request.setAttribute("errorMessage", "Database error during registration. Please try again.");
            }
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}
