<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LendPy Register</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

<link rel="stylesheet" href="css/auth.css">

</head>
<body>

<div class="left-panel">

<h1>LendPy</h1>

<p>
Compare loans from multiple banks,
calculate EMI, and choose the best
financial option for your future.
</p>

</div>

<div class="right-panel">

<div class="auth-card">

<h2>Create Account</h2>

<p class="subtitle">
Register to access LendPy platform
</p>

<form action="RegisterServlet"
method="post">

<div class="form-group">

<label>Full Name</label>

<input type="text"
name="name"
required>

</div>

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

Create Account

</button>

</form>

<div class="bottom-link">

Already have an account?

<a href="login.jsp">
Login
</a>

</div>

</div>

</div>

</body>
</html>