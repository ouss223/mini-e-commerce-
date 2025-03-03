package com.example.servlet;

import com.example.dao.ProduitDAO;
import com.example.model.Produit;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProduitServlet", urlPatterns = {"/produit"})
public class ProduitServlet extends HttpServlet {
    private ProduitDAO produitDAO = new ProduitDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";
        try {
            switch (action) {
                case "new":
                    request.getRequestDispatcher("/ajouterProduit.jsp").forward(request, response);
                    break;
                case "edit":
                    int idEdit = Integer.parseInt(request.getParameter("id"));
                    Produit produitEdit = produitDAO.getProduitById(idEdit);
                    request.setAttribute("produit", produitEdit);
                    request.getRequestDispatcher("/modifierProduit.jsp").forward(request, response);
                    break;
                case "details":
                    int idDetails = Integer.parseInt(request.getParameter("id"));
                    Produit produitDetails = produitDAO.getProduitById(idDetails);
                    request.setAttribute("produit", produitDetails);
                    request.getRequestDispatcher("/detailsProduit.jsp").forward(request, response);
                    break;
                default:
                    request.setAttribute("produits", produitDAO.getAllProduits());
                    request.getRequestDispatcher("/listeProduits.jsp").forward(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "add":
                    Produit pAdd = new Produit();
                    pAdd.setNom(request.getParameter("nom"));
                    pAdd.setDescription(request.getParameter("description"));
                    pAdd.setPrix(Double.parseDouble(request.getParameter("prix")));
                    pAdd.setImage(request.getParameter("image"));
                    produitDAO.addProduit(pAdd);
                    break;
                case "update":
                    Produit pUpdate = new Produit();
                    pUpdate.setId(Integer.parseInt(request.getParameter("id")));
                    pUpdate.setNom(request.getParameter("nom"));
                    pUpdate.setDescription(request.getParameter("description"));
                    pUpdate.setPrix(Double.parseDouble(request.getParameter("prix")));
                    pUpdate.setImage(request.getParameter("image"));
                    produitDAO.updateProduit(pUpdate);
                    break;
                case "delete":
                    int idDelete = Integer.parseInt(request.getParameter("id"));
                    produitDAO.deleteProduit(idDelete);
                    break;
            }
            response.sendRedirect("produit");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}