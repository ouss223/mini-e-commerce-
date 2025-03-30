<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un Produit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color: #f2f4f7">
<%@ include file="header.jsp" %>

<div class="container">
    <h1 class="fs-4 mt-3 text-center">Ajouter un Produit</h1>
    <div class="d-flex justify-content-center pb-5">
        <form action="produit" method="post" class="mt-2 border border-3 p-4 rounded-4 w-50 bg-light"
              style="box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15)">
            <input type="hidden" name="action" value="add">

            <div class="mb-4">
                <label class="fs-5 mb-2 ms-1" for="nom">Nom:</label>
                <input type="text" id="nom" name="nom" required class="form-control py-2 fs-5 border-3">
            </div>

            <div class="mb-4">
                <label class="fs-5 mb-2 ms-1" for="description">Description:</label>
                <textarea id="description" name="description" required class="form-control py-2 fs-5 border-3"></textarea>
            </div>

            <div class="mb-4">
                <label class="fs-5 mb-2 ms-1" for="prix">Prix:</label>
                <input type="number" id="prix" name="prix" step="0.01" required class="form-control py-2 fs-5 border-3">
            </div>

            <div class="mb-4">
                <label class="fs-5 mb-2 ms-1" for="image">Image URL:</label>
                <input type="text" id="image" name="image" required class="form-control py-2 fs-5 border-3">
            </div>

            <div class="d-flex justify-content-end gap-2">
                <a href="produit" class="btn text-danger fw-bold border border-3">Annuler</a>
                <button type="submit" class="btn fw-bold border border-3">Ajouter</button>
            </div>
        </form>
    </div>
</div>

</body>
</html>
