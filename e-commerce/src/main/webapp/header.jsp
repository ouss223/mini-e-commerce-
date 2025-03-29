<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
    <link rel="stylesheet" type="text/css" href="styles/header.css">
</head>

<div class="header">
    <div class="logo">
        <h2>E-commerce</h2>
    </div>
    <div class="navigation">
        <ul>
            <li><a href="produit">Produits</a></li>
            <!-- Other links, if needed -->
        </ul>
    </div>
    <div class="user-actions">
        <c:choose>
            <c:when test="${not empty sessionScope.user}">
                <!-- Show the logout button if the user is logged in -->
                <form action="logout" method="get">
                    <button type="submit">Logout</button>
                </form>
            </c:when>
            <c:otherwise>
                <!-- If the user is not logged in, show nothing or display a login link -->
                <a href="login">Login</a>
            </c:otherwise>
        </c:choose>
    </div>
</div>
