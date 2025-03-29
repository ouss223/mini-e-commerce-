package com.ecommerce.metier;

import com.ecommerce.model.User;
import java.sql.SQLException;

public interface IGestionUser {
    void registerUser(User user) throws SQLException;
    User authenticateUser(String email, String password) throws SQLException;
}
