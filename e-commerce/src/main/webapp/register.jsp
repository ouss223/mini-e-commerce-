<%@ page import="com.ecommerce.model.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="styles/register.css">
</head>
<body>
<div class="container">
    <h1>Register</h1>

    <%-- Display Error Message if Password Validation Fails --%>
    <div class="error-message">
        <%
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
        %>
            <p style="color: red;"><%= errorMessage %></p>
        <% } %>
    </div>

    <form action="register" method="post">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>

        <button type="submit">Register</button>
    </form>

    <a href="login.jsp">Already have an account? Login</a>
</div>
</body>
</html>
