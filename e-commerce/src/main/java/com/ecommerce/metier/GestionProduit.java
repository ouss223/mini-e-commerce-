package com.ecommerce.metier;

import com.ecommerce.dao.GestionProduitDAO;
import com.ecommerce.dao.IGestionProduitDAO;
import com.ecommerce.model.Produit;

import java.sql.SQLException;
import java.util.List;

public class GestionProduit implements IGestionProduit {
    private IGestionProduitDAO produitDAO;

    public GestionProduit() {
        this.produitDAO = new GestionProduitDAO();
    }

    @Override
    public List<Produit> getAllProduits() throws SQLException {
        return produitDAO.getAllProduits();
    }

    @Override
    public void addProduit(Produit produit) throws SQLException {
        // Business logic (e.g., validation) can be added here before saving
        produitDAO.addProduit(produit);
    }

    @Override
    public void updateProduit(Produit produit) throws SQLException {
        produitDAO.updateProduit(produit);
    }

    @Override
    public void deleteProduit(int id) throws SQLException {
        produitDAO.deleteProduit(id);
    }

    @Override
    public Produit getProduitById(int id) throws SQLException {
        return produitDAO.getProduitById(id);
    }

    @Override
    public List<Produit> searchProduits(String query) throws SQLException {
        return produitDAO.searchProduits(query); // Call DAO layer for search
    }
}
