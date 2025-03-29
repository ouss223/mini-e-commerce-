package com.ecommerce.metier;

import com.ecommerce.dao.GestionUserDAO;
import com.ecommerce.dao.IGestionUserDAO;
import com.ecommerce.model.User;
import java.sql.SQLException;

public class GestionUser implements IGestionUser {
    private IGestionUserDAO userDAO = new GestionUserDAO();

    @Override
    public void registerUser(User user) throws SQLException {
        userDAO.registerUser(user);
    }

    @Override
    public User authenticateUser(String email, String password) throws SQLException {
        User user = userDAO.getUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user; //todo : add hadhing
        }
        return null;
    }
}


