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

        if (FunctionsUtils.isValidPassword(user.getPassword())) {
            String hash = FunctionsUtils.hashPassword(user.getPassword()) ;
            user.setPassword(hash);
            userDAO.registerUser(user);
        } else {
            throw new IllegalArgumentException("Password is too weak");
        }
    }

    @Override
    public User authenticateUser(String email, String password) throws SQLException {
        User user = userDAO.getUserByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("Invalid email or password");
        }
        if (!FunctionsUtils.checkPassword(password, user.getPassword())) {
            throw new IllegalArgumentException("Invalid email or password");
        }
        return user;
    }

}
