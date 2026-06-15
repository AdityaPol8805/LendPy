<%@ page import="dao.LoanDAO"%>

<%
String adminEmail = (String) session.getAttribute("adminEmail");

if (adminEmail == null) {

	response.sendRedirect("adminLogin.jsp");
	return;
}

LoanDAO dao = new LoanDAO();

int totalLoans = dao.getTotalLoans();
int approvedLoans = dao.getApprovedLoans();
int rejectedLoans = dao.getRejectedLoans();
int pendingLoans = dao.getPendingLoans();
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Admin Dashboard</title>

<link rel="preconnect" href="https://fonts.googleapis.com">

<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/adminDashboard.css">

</head>

<body>

	<div class="sidebar">

		<div class="logo">LendPy</div>

		<a href="adminDashboard.jsp" class="active"> Dashboard </a> <a
			href="ViewAllLoansServlet"> All Loans </a> <a
			href="ManageBanksServlet"> Manage Banks </a> <a
			href="adminLogout.jsp"> Logout </a>

	</div>

	<div class="main-content">

		<div class="header">

			<h1>Admin Dashboard</h1>

			<p>
				Welcome,
				<%=adminEmail%>
			</p>

		</div>

		<div class="cards">

			<div class="card">

				<h3>Total Loans</h3>

				<h2>
					<%=totalLoans%>
				</h2>

			</div>

			<div class="card">

				<h3>Approved</h3>

				<h2>
					<%=approvedLoans%>
				</h2>

			</div>

			<div class="card">

				<h3>Rejected</h3>

				<h2>
					<%=rejectedLoans%>
				</h2>

			</div>

			<div class="card">

				<h3>Pending</h3>

				<h2>
					<%=pendingLoans%>
				</h2>

			</div>

		</div>

		<div class="actions">

			<h2>Quick Actions</h2>

			<a href="ViewAllLoansServlet" class="action-btn"> View All Loans

			</a>

		</div>

	</div>

</body>

</html>