<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color: #f2f4f7">
<%@ include file="header.jsp" %>

<div class="container">
    <h1 class="fs-3 mb-4 mt-5 mt-3 text-center">Register</h1>
    <div class="d-flex justify-content-center pb-5">
        <form action="register" method="post" class="mt-2 border border-3 p-4 rounded-4 w-50 bg-light"
              style="box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15)">

            <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
            <% if (errorMessage != null) { %>
                <div class="alert alert-danger" role="alert">
                    <%= errorMessage %>
                </div>
            <% } %>

            <div class="mb-4">
                <label class="fs-5 mb-2 ms-1" for="username">Username:</label>
                <input type="text" id="username" name="username" required class="form-control py-2 fs-5 border-3">
            </div>

            <div class="mb-4">
                <label class="fs-5 mb-2 ms-1" for="email">Email:</label>
                <input type="email" id="email" name="email" required class="form-control py-2 fs-5 border-3">
            </div>

            <div class="mb-4">
                <label class="fs-5 mb-2 ms-1" for="password">Password:</label>
                <input type="password" id="password" name="password" required class="form-control py-2 fs-5 border-3">
            </div>

            <div class="d-flex justify-content-center gap-2">
                <button type="submit" class="btn fw-bold border border-3">Register</button>
            </div>

            <p class="mt-3 text-center">
                <a href="login.jsp" class="text-decoration-none">Already have an account? Login</a>
            </p>
        </form>
    </div>
</div>

</body>
</html>
