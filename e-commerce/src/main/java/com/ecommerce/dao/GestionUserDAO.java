package com.ecommerce.dao;

import com.ecommerce.model.User;
import com.ecommerce.utils.DBConnection;
import java.sql.*;

public class GestionUserDAO implements IGestionUserDAO {

    @Override
    public void registerUser(User user) throws SQLException {
        String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword()); // Store hashed password in production
            pstmt.executeUpdate();
        }
    }

    @Override
    public User getUserByEmail(String email) throws SQLException {
        String query = "SELECT * FROM users WHERE email = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("email"),
                            rs.getString("password") // todo : use hashing
                    );
                }
            }
        }
        return null;
    }
}
