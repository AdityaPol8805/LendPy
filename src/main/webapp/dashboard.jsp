<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" session="true"%>

<%@ page import="dao.LoanDAO" %>

<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

String email = (String) session.getAttribute("email");

Integer userId =
(Integer) session.getAttribute("userId");

if(email == null || userId == null){

    response.sendRedirect("login.jsp");
    return;
}

LoanDAO dao = new LoanDAO();

int totalLoans =
dao.getUserLoanCount(userId);

int approvedLoans =
dao.getUserApprovedLoanCount(userId);

int pendingLoans =
dao.getUserPendingLoanCount(userId);
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>LendPy Dashboard</title>

<link rel="preconnect"
href="https://fonts.googleapis.com">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
rel="stylesheet">

<link rel="stylesheet"
href="${pageContext.request.contextPath}/css/dashboard.css">

</head>

<body>

<div class="sidebar">

    <div class="logo">
        LendPy
    </div>

    <a href="dashboard.jsp" class="active">
        Dashboard
    </a>

    <a href="applyLoan.jsp">
        Loan Application
    </a>

    <a href="MyLoansServlet">
        My Loans
    </a>

    <a href="logout.jsp">
        Logout
    </a>

</div>

<div class="main-content">

    <div class="header">

        <h1>Dashboard</h1>

        <p>
            Welcome back, <%= email %>
        </p>

    </div>

    <div class="cards">

        <div class="card">

            <h3>Total Loans</h3>

            <h2>
                <%= totalLoans %>
            </h2>

        </div>

        <div class="card">

            <h3>Approved Loans</h3>

            <h2>
                <%= approvedLoans %>
            </h2>

        </div>

        <div class="card">

            <h3>Pending Loans</h3>

            <h2>
                <%= pendingLoans %>
            </h2>

        </div>

    </div>

    <div class="table-box">

        <h2>Quick Actions</h2>

        <table>

            <tr>
                <th>Feature</th>
                <th>Action</th>
            </tr>

            <tr>
                <td>Apply New Loan</td>

                <td>
                    <a href="applyLoan.jsp">
                        Open
                    </a>
                </td>
            </tr>

            <tr>
                <td>View My Loans</td>

                <td>
                    <a href="MyLoansServlet">
                        Open
                    </a>
                </td>
            </tr>
        </table>

    </div>

</div>

</body>
</html>