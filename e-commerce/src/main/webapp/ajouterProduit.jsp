<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un Produit</title>
    <link rel="stylesheet" type="text/css" href="styles/ajout.css">
</head>
<body>
<div class="container">
    <h1>Ajouter un Produit</h1>
    <form action="produit" method="post">
        <input type="hidden" name="action" value="add">

        <div class="form-group">
            <label for="nom">Nom:</label>
            <input type="text" id="nom" name="nom" required>
        </div>

        <div class="form-group">
            <label for="description">Description:</label>
            <textarea id="description" name="description" required></textarea>
        </div>

        <div class="form-group">
            <label for="prix">Prix:</label>
            <input type="number" id="prix" name="prix" step="0.01" required>
        </div>

        <div class="form-group">
            <label for="image">Image URL:</label>
            <input type="text" id="image" name="image" required>
        </div>

        <button type="submit" class="btn-submit">Ajouter</button>
    </form>
    <a href="produit" class="btn-cancel">Annuler</a>
</div>
</body>
</html>