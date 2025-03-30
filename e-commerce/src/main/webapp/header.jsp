<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
    <link rel="stylesheet" type="text/css" href="styles/header.css">
</head>

<div class="header">
    <div class="logo">
        <h2>E-commerce</h2>
    </div>
    <div class="navigation">
        <!-- Add navigation links here if needed -->
    </div>
    <div class="user-actions">
        <!-- If user is logged in -->
        ${sessionScope.user != null ?
            '<form action="logout" method="get">
                <button type="submit">Logout</button>
            </form>' :
            '<a href="login">Login</a>'
        }
    </div>
</div>
