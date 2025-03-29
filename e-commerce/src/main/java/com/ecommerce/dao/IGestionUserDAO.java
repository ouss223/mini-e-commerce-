package com.ecommerce.dao;

import com.ecommerce.model.User;
import java.sql.SQLException;

public interface IGestionUserDAO {
    void registerUser(User user) throws SQLException;
    User getUserByEmail(String email) throws SQLException;
}
