<%@ page import="com.ecommerce.model.Produit" %>
<!DOCTYPE html>
<html>
<head>
    <title>Details du Produit</title>
         <link
              href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
              rel="stylesheet"
          >
</head>
<body class="d-flex flex-column" style="background-color : #f2f4f7">
<%@ include file="header.jsp" %>

<div class="px-5 pt-5 ">
<div class="container-fluid px-5 justify-content-center align-items-center py-5 mt-1 gap-4 d-flex rox border border-3  rounded-4 bg-light">
    <% Produit p = (Produit) request.getAttribute("produit"); %>

    <div  class="col-4">
        <img class="w-100 rounded-4" src="<%= p.getImage() %>" alt="Produit Image">
        <p class="fs-3 text-center text-secondary mt-4 border border-3 rounded-3  "><%= p.getPrix() %> DT</p>

    </div>

    <div class="ms-1 col-8 px-3">
        <div class="d-flex">
            <p class="fs-2 m-0"> <%= p.getNom() %></p>
        </div>
        <p class="fs-5 mt-3 m-0 text-secondary"> <%= p.getDescription() %></p>
    </div>


</div>
    <div class="d-flex justify-content-center mt-3">
        <a href="produit" class="btn btn-outline-secondary fw-bold fs-5 border-2 mb-3">Retour</a>
    </div>
</div>
</body>
</html>