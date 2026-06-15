<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Admin Login</title>

<link rel="preconnect"
href="https://fonts.googleapis.com">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
rel="stylesheet">

<link rel="stylesheet"
href="${pageContext.request.contextPath}/css/adminLogin.css">

</head>

<body>

<div class="login-card">

    <div class="logo">
        LendPy
    </div>

    <p class="subtitle">
        Administrator Portal
    </p>

    <form action="AdminLoginServlet"
          method="post">

        <div class="form-group">

            <label>Email</label>

            <input type="email"
                   name="email"
                   required>

        </div>

        <div class="form-group">

            <label>Password</label>

            <input type="password"
                   name="password"
                   required>

        </div>

        <button type="submit"
                class="login-btn">

            Login

        </button>

    </form>

</div>

</body>

</html>