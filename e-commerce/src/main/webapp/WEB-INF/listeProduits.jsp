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
<body class="d-flex flex-column pb-5" style="background-color : #f2f4f7">
<%@ include file="../header.jsp" %>
<div>

  <form action="produit" method="get" class="d-flex gap-3 align-items-center container mt-4">
      <a href="produit?action=new" class="btn m-0 p-0 h-100 d-flex align-items-center bg-light">
          <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
            <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
            <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4"/>
          </svg>
      </a>
    <input type="text" name="search" class="form-control border-2" placeholder="Rechercher un produit..."
           value="<%= request.getAttribute("searchQuery") != null ? request.getAttribute("searchQuery") : "" %>">
    <button type="submit" class="btn border border-2 bg-light">Rechercher</button>

  </form>


  <% List<Produit> produits = (List<Produit>) request.getAttribute("produits"); %>

  <% if (produits != null && !produits.isEmpty()) { %>
    <div class="d-flex flex-wrap gap-4 px-5 mt-3 justify-content-center">
        <% for (Produit p : produits) { %>

          <div class='d-flex border  border-3 p-2 mt-4 rounded-4 flex-column justify-content-between' style="width : 320px ; height : 530px ; box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15); background-color : #f2f4f7
">
          <div>
             <div class="w-100 overflow-hidden " style="height:220px">
                <img class="w-100 rounded-4 border border-4 h-100" style="object-fit : cover " src="<%= p.getImage() %>" alt="Produit Image" class="product-image">
             </div>
             <h1 class="fs-4 text-start  text-capitalize mt-2 ms-1"><%= p.getNom() %></h1>
             <p class="fs-5 text-secondary m-0 ms-1"><%= FunctionsUtils.Slice(p.getDescription(),40) %></p>
             <h2 class="fs-4 mt-3  w-100  me-3">
                <span class =" ms-2 rounded-3"> <%= p.getPrix()  %> DT </span>
             </h2>
          </div>

            <div class="d-flex mt-3 justify-content-end gap-2 ">

              <a class="btn p-2 border-2 border text-secondary d-flex justify-content-center align-items-center m-0 p-0" href="produit?action=details&id=<%= p.getId() %>" style="font-weight : 600">
                 Details
               </a>

              <a class=" btn  p-2 border-2 border  d-flex justify-content-center align-items-center m-0 p-0" href="produit?action=edit&id=<%= p.getId() %>" >
                <svg xmlns="http://www.w3.org/2000/svg" width="23" height="23" fill="currentColor" class="bi bi-pencil-square text-primary" viewBox="0 0 16 16">
                  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
                </svg>
              </a>

              <form action="produit" method="post">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="<%= p.getId() %>">
                <button class="btn p-2 border-2 border" type="submit" >
                    <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-trash-fill text-danger" viewBox="0 0 16 16">
                      <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5M8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5m3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0"/>
                    </svg>
                </button>
              </form>


            </div>
          </div>

        <% } %>
    </div>
  <% } else { %>
    <p class="no-results mt-5  text-center fs-4 text-muted  ">Aucun produit trouve.</p>
  <% } %>
</div>
</body>
</html>
