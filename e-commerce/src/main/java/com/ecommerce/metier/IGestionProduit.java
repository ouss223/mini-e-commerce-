package com.ecommerce.metier;

import com.ecommerce.model.Produit;
import java.sql.SQLException;
import java.util.List;

public interface IGestionProduit {
    List<Produit> getAllProduits() throws SQLException;
    List<Produit> searchProduits(String query) throws SQLException;

    void addProduit(Produit produit) throws SQLException;
    void updateProduit(Produit produit) throws SQLException;
    void deleteProduit(int id) throws SQLException;
    Produit getProduitById(int id) throws SQLException;
}
