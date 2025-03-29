<%@ page import="com.ecommerce.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="styles/login.css">
</head>
<body>
<div class="container">
    <h1>Login</h1>

    <%-- Display Error Message if Login Fails --%>
    <div class="error-message">
        <%
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
        %>
            <p style="color: red;"><%= errorMessage %></p>
        <% } %>
    </div>

    <form action="login" method="post">
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>

        <button type="submit">Login</button>
    </form>

    <a href="register.jsp">Don't have an account? Register</a>
</div>
</body>
</html>
