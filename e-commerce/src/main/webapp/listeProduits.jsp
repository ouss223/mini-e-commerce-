<%@ page import="com.example.model.Produit" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
  <title>Liste des Produits</title>
  <link rel="stylesheet" type="text/css" href="styles/liste.css"> <!-- Link to your CSS file -->
</head>
<body>
<div class="container">
  <h1>Produits</h1>
  <a href="produit?action=new" class="btn-add">Ajouter</a>
  <table>
    <thead>
    <tr>
      <th>ID</th>
      <th>Nom</th>
      <th>Description</th>
      <th>Prix</th>
      <th>Image</th>
      <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <% List<Produit> produits = (List<Produit>) request.getAttribute("produits");
      for (Produit p : produits) { %>
    <tr>
      <td><%= p.getId() %></td>
      <td><%= p.getNom() %></td>
      <td><%= p.getDescription() %></td>
      <td><%= p.getPrix() %></td>
      <td><img src="<%= p.getImage() %>" alt="Produit Image" class="product-image"></td>
      <td class="actions">
        <a href="produit?action=edit&id=<%= p.getId() %>" class="btn-edit">Modifier</a>
        <a href="produit?action=details&id=<%= p.getId() %>" class="btn-details">Détails</a>
        <form action="produit" method="post">
          <input type="hidden" name="action" value="delete">
          <input type="hidden" name="id" value="<%= p.getId() %>">
          <button type="submit" class="btn-delete">Supprimer</button>
        </form>
      </td>
    </tr>
    <% } %>
    </tbody>
  </table>
</div>
</body>
</html>