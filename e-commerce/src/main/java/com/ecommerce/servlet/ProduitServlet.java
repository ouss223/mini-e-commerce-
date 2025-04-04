package com.ecommerce.servlet;

import com.ecommerce.metier.GestionProduit;
import com.ecommerce.metier.IGestionProduit;
import com.ecommerce.model.Produit;
import com.ecommerce.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProduitServlet", urlPatterns = {"/produit"})
public class ProduitServlet extends HttpServlet {
    private IGestionProduit gestionProduit;

    @Override
    public void init() {
        gestionProduit = new GestionProduit();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login");
            return;
        }

        String action = request.getParameter("action");
        if (action == null) action = "list";

        try {
            switch (action) {
                case "new":
                    request.getRequestDispatcher("/WEB-INF/ajouterProduit.jsp").forward(request, response);
                    break;

                case "edit":
                    int idEdit = Integer.parseInt(request.getParameter("id"));
                    Produit produitEdit = gestionProduit.getProduitById(idEdit);
                    request.setAttribute("produit", produitEdit);
                    request.getRequestDispatcher("/WEB-INF/modifierProduit.jsp").forward(request, response);
                    break;

                case "details":
                    int idDetails = Integer.parseInt(request.getParameter("id"));
                    Produit produitDetails = gestionProduit.getProduitById(idDetails);
                    request.setAttribute("produit", produitDetails);
                    request.getRequestDispatcher("/WEB-INF/detailsProduit.jsp").forward(request, response);
                    break;

                case "list":
                default:
                    String searchQuery = request.getParameter("search");
                    List<Produit> produits;

                    if (searchQuery != null && !searchQuery.trim().isEmpty()) {
                        produits = gestionProduit.searchProduits(searchQuery);
                        request.setAttribute("searchQuery", searchQuery);
                    } else {
                        produits = gestionProduit.getAllProduits();
                    }

                    request.setAttribute("produits", produits);
                    request.getRequestDispatcher("/WEB-INF/listeProduits.jsp").forward(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // false means don't create a new session if it doesn't exist
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login");
            return;
        }

        String action = request.getParameter("action");

        try {
            switch (action) {
                case "add":
                    Produit pAdd = new Produit();
                    pAdd.setNom(request.getParameter("nom"));
                    pAdd.setDescription(request.getParameter("description"));
                    pAdd.setPrix(Double.parseDouble(request.getParameter("prix")));
                    pAdd.setImage(request.getParameter("image"));
                    gestionProduit.addProduit(pAdd);
                    break;

                case "update":
                    Produit pUpdate = new Produit();
                    pUpdate.setId(Integer.parseInt(request.getParameter("id")));
                    pUpdate.setNom(request.getParameter("nom"));
                    pUpdate.setDescription(request.getParameter("description"));
                    pUpdate.setPrix(Double.parseDouble(request.getParameter("prix")));
                    pUpdate.setImage(request.getParameter("image"));
                    gestionProduit.updateProduit(pUpdate);
                    break;

                case "delete":
                    int idDelete = Integer.parseInt(request.getParameter("id"));
                    gestionProduit.deleteProduit(idDelete);
                    break;
            }
            response.sendRedirect("produit");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
