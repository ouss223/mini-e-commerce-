package com.example.dao;

import com.example.model.Produit;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO {
    public List<Produit> getAllProduits() throws SQLException {
        List<Produit> produits = new ArrayList<>();
        String query = "SELECT * FROM produits";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setDescription(rs.getString("description"));
                p.setPrix(rs.getDouble("prix"));
                p.setImage(rs.getString("image"));
                produits.add(p);
            }
        }
        return produits;
    }

    public void addProduit(Produit produit) throws SQLException {
        String query = "INSERT INTO produits (nom, description, prix, image) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, produit.getNom());
            pstmt.setString(2, produit.getDescription());
            pstmt.setDouble(3, produit.getPrix());
            pstmt.setString(4, produit.getImage());
            pstmt.executeUpdate();
        }
    }

    public void updateProduit(Produit produit) throws SQLException {
        String query = "UPDATE produits SET nom=?, description=?, prix=?, image=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, produit.getNom());
            pstmt.setString(2, produit.getDescription());
            pstmt.setDouble(3, produit.getPrix());
            pstmt.setString(4, produit.getImage());
            pstmt.setInt(5, produit.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteProduit(int id) throws SQLException {
        String query = "DELETE FROM produits WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    public Produit getProduitById(int id) throws SQLException {
        String query = "SELECT * FROM produits WHERE id=?";
        Produit p = new Produit();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    p.setId(rs.getInt("id"));
                    p.setNom(rs.getString("nom"));
                    p.setDescription(rs.getString("description"));
                    p.setPrix(rs.getDouble("prix"));
                    p.setImage(rs.getString("image"));
                }
            }
        }
        return p;
    }
}