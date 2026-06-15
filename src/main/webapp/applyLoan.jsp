<%@ page session="true" %>

<%
Integer userId = (Integer)session.getAttribute("userId");

if(userId == null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Compare Loan Offers</title>

<link rel="preconnect"
href="https://fonts.googleapis.com">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
rel="stylesheet">

<link rel="stylesheet"
href="${pageContext.request.contextPath}/css/forms.css">

</head>

<body>

<div class="sidebar">

    <div class="logo">
        LendPy
    </div>

    <a href="dashboard.jsp">
        Dashboard
    </a>

    <a href="applyLoan.jsp" class="active">
        Compare Loans
    </a>

    <a href="MyLoansServlet">
        My Loans
    </a>

    <a href="logout.jsp">
        Logout
    </a>

</div>

<div class="main-content">

    <h1 class="page-title">
        Compare Loan Offers
    </h1>

    <p class="page-subtitle">
        Enter your requirements and compare loan offers from multiple banks.
    </p>

    <div class="form-card">

        <form action="CompareBanksServlet"
              method="post">

            <div class="form-grid">

                <div class="form-group">

                    <label>Loan Type</label>

                    <select name="loanType" required>

                        <option value="">
                            Select Loan Type
                        </option>

                        <option>Home Loan</option>
                        <option>Personal Loan</option>
                        <option>Education Loan</option>
                        <option>Business Loan</option>
                        <option>Vehicle Loan</option>

                    </select>

                </div>

                <div class="form-group">

                    <label>Loan Amount (₹)</label>

                    <input type="number"
                           name="amount"
                           required>

                </div>

                <div class="form-group">

                    <label>Monthly Income (₹)</label>

                    <input type="number"
                           name="income"
                           required>

                </div>

                <div class="form-group">

                    <label>Tenure (Months)</label>

                    <input type="number"
                           name="tenure"
                           required>

                </div>

                <div class="form-group full-width">

                    <label>Reason For Loan</label>

                    <textarea name="reason"
                              rows="5"
                              required></textarea>

                </div>

            </div>

            <div class="emi-card">

                <h3>
                    Compare banks to view EMI calculations,
                    eligibility criteria, and processing fees.
                </h3>

            </div>

            <div class="submit-container">

                <button type="submit"
                        class="submit-btn">

                    Compare Banks

                </button>

            </div>

        </form>

    </div>

</div>

</body>
</html>