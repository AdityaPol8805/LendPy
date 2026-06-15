<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LendPy Login</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

<link rel="stylesheet" href="css/auth.css">

</head>
<body>

<div class="left-panel">

<h1>Welcome to LendPy</h1>

<p>
Compare loan offers from multiple banks,
calculate EMI, and choose the best financial
solution for your needs.
</p>

</div>

<div class="right-panel">

<div class="auth-card">

<h2>Login</h2>

<p class="subtitle">
Access your LendPy dashboard
</p>

<form action="LoginServlet" method="post">

<div class="form-group">

<label>Email Address</label>

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
class="auth-btn">

Login

</button>

</form>

<div class="bottom-link">

Don't have an account?

<a href="register.jsp">
Register
</a>

</div>

</div>

</div>

</body>
</html>