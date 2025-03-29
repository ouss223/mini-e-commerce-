package com.ecommerce.dao;

import com.ecommerce.model.Produit;
import com.ecommerce.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestionProduitDAO implements IGestionProduitDAO {

    @Override
    public List<Produit> getAllProduits() throws SQLException {
        List<Produit> produits = new ArrayList<>();
        String query = "SELECT * FROM produits";
        try (Connection conn = DBConnection.getConnection();
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

    @Override
    public void addProduit(Produit produit) throws SQLException {
        String query = "INSERT INTO produits (nom, description, prix, image) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, produit.getNom());
            pstmt.setString(2, produit.getDescription());
            pstmt.setDouble(3, produit.getPrix());
            pstmt.setString(4, produit.getImage());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void updateProduit(Produit produit) throws SQLException {
        String query = "UPDATE produits SET nom=?, description=?, prix=?, image=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, produit.getNom());
            pstmt.setString(2, produit.getDescription());
            pstmt.setDouble(3, produit.getPrix());
            pstmt.setString(4, produit.getImage());
            pstmt.setInt(5, produit.getId());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void deleteProduit(int id) throws SQLException {
        String query = "DELETE FROM produits WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    @Override
    public Produit getProduitById(int id) throws SQLException {
        String query = "SELECT * FROM produits WHERE id=?";
        Produit p = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    p = new Produit();
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


    @Override
    public List<Produit> searchProduits(String keyword) throws SQLException {
        List<Produit> produits = new ArrayList<>();
        String query = "SELECT * FROM produits WHERE nom LIKE ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, "%" + keyword + "%"); // Search for partial matches
            try (ResultSet rs = pstmt.executeQuery()) {
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
        }
        return produits;
    }
}
