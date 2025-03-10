<%@ page import="com.example.model.Produit" %>
<!DOCTYPE html>
<html>
<head>
    <title>Détails du Produit</title>
    <link rel="stylesheet" type="text/css" href="styles/details.css">
</head>
<body>
<div class="container">
    <h1>Détails</h1>
    <% Produit p = (Produit) request.getAttribute("produit"); %>
    <div class="details-card">
        <p><strong>ID:</strong> <%= p.getId() %></p>
        <p><strong>Nom:</strong> <%= p.getNom() %></p>
        <p><strong>Description:</strong> <%= p.getDescription() %></p>
        <p><strong>Prix:</strong> <%= p.getPrix() %></p>
        <p><strong>Image:</strong></p>
        <img src="<%= p.getImage() %>" alt="Produit Image" class="product-image">
    </div>
    <a href="produit" class="btn-back">Retour</a>
</div>
</body>
</html>