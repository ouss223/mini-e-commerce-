package com.ecommerce.metier;

import com.ecommerce.dao.GestionUserDAO;
import com.ecommerce.dao.IGestionUserDAO;
import com.ecommerce.model.User;
import com.ecommerce.utils.FunctionsUtils;
import java.sql.SQLException;

public class GestionUser implements IGestionUser {
    private  IGestionUserDAO userDAO = new GestionUserDAO();

    @Override
    public void registerUser(User user) throws SQLException {
        // Validate password before registering
        if (FunctionsUtils.isValidPassword(user.getPassword())) {
            userDAO.registerUser(user);  //todo : add hashing
        } else {
            throw new IllegalArgumentException("Password does not meet the required criteria.");
        }
    }

    @Override
    public User authenticateUser(String email, String password) throws SQLException {
        User user = userDAO.getUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {  //todo : add hashing
            return user;
        }
        return null;
    }
}
