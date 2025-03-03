<%@ page import="com.example.model.Produit" %>
<!DOCTYPE html>
<html>
<head>
    <title>Modifier un Produit</title>
    <link rel="stylesheet" type="text/css" href="styles/modifier.css">
</head>
<body>
<div class="container">
    <h1>Modifier Produit</h1>
    <% Produit p = (Produit) request.getAttribute("produit"); %>
    <form action="produit" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="<%= p.getId() %>">

        <div class="form-group">
            <label for="nom">Nom:</label>
            <input type="text" id="nom" name="nom" value="<%= p.getNom() %>" required>
        </div>

        <div class="form-group">
            <label for="description">Description:</label>
            <textarea id="description" name="description" required><%= p.getDescription() %></textarea>
        </div>

        <div class="form-group">
            <label for="prix">Prix:</label>
            <input type="number" id="prix" name="prix" step="0.01" value="<%= p.getPrix() %>" required>
        </div>

        <div class="form-group">
            <label for="image">Image URL:</label>
            <input type="text" id="image" name="image" value="<%= p.getImage() %>" required>
        </div>

        <button type="submit" class="btn-submit">Modifier</button>
    </form>
    <a href="produit" class="btn-cancel">Annuler</a>
</div>
</body>
</html>