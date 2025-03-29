<%@ page import="com.ecommerce.model.Produit" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ecommerce.utils.FunctionsUtils" %>



<!DOCTYPE html>
<html>
<head>
  <title>Liste des Produits</title>
     <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
      >
</head>
<body class="d-flex flex-column">
<%@ include file="header.jsp" %>
<div class="container">
  <h1>Produits</h1>

  <!-- Search Form -->
  <form action="produit" method="get">
    <input type="text" name="search" class="form-control" placeholder="Rechercher un produit..."
           value="<%= request.getAttribute("searchQuery") != null ? request.getAttribute("searchQuery") : "" %>">
    <button type="submit">Rechercher</button>
  </form>

  <a href="produit?action=new" class="btn-add">Ajouter</a>

  <!-- Get Products from Request -->
  <% List<Produit> produits = (List<Produit>) request.getAttribute("produits"); %>

  <% if (produits != null && !produits.isEmpty()) { %>
    <table>

      <tbody>
        <% for (Produit p : produits) { %>
          <div>
            <h1><%= p.getNom() %></h1>
            <p><%= FunctionsUtils.Slice(p.getDescription(),40) %></p>
            <h2><%= p.getPrix() %></h2>
            <div><img src="<%= p.getImage() %>" alt="Produit Image" class="product-image"></div>
            <div>
              <a href="produit?action=edit&id=<%= p.getId() %>" class="btn-edit">Modifier</a>
              <a href="produit?action=details&id=<%= p.getId() %>" class="btn-details">Details</a>
              <form action="produit" method="post">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="<%= p.getId() %>">
                <button type="submit" class="btn-delete">Supprimer</button>
              </form>
            </div>
          </div>
        <% } %>
      </tbody>
    </table>
  <% } else { %>
    <p class="no-results">Aucun produit trouve.</p>
  <% } %>
</div>
</body>
</html>
