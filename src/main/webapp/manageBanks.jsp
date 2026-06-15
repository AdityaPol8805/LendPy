<%@ page import="java.util.List" %>
<%@ page import="model.Bank" %>

<%
List<Bank> banks =
(List<Bank>)request.getAttribute("banks");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Manage Banks</title>

<link rel="preconnect"
href="https://fonts.googleapis.com">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
rel="stylesheet">

<link rel="stylesheet"
href="${pageContext.request.contextPath}/css/manageBanks.css">

</head>

<body>

<h1 class="page-title">
Manage Banks
</h1>

<div class="form-card">

<form action="AddBankServlet"
      method="post">

<input type="text"
       name="bankName"
       placeholder="Bank Name"
       required>

<input type="text"
       name="loanType"
       placeholder="Loan Type"
       required>

<input type="number"
       step="0.01"
       name="interestRate"
       placeholder="Interest Rate"
       required>

<input type="number"
       name="minIncome"
       placeholder="Minimum Income"
       required>

<input type="number"
       name="maxAmount"
       placeholder="Maximum Amount"
       required>

<input type="number"
       name="maxTenure"
       placeholder="Maximum Tenure"
       required>

<input type="number"
       step="0.01"
       name="processingFee"
       placeholder="Processing Fee"
       required>

<button type="submit">
Add Bank
</button>

</form>

</div>

<div class="table-card">

<table>

<tr>

<th>ID</th>
<th>Bank</th>
<th>Loan Type</th>
<th>Interest</th>
<th>Action</th>

</tr>

<%
for(Bank bank : banks){
%>

<tr>

<td><%= bank.getId() %></td>

<td><%= bank.getBankName() %></td>

<td><%= bank.getLoanType() %></td>

<td><%= bank.getInterestRate() %>%</td>

<td>

<a href="DeleteBankServlet?id=<%=bank.getId()%>"
class="delete-btn">

Delete

</a>

</td>

</tr>

<%
}
%>

</table>

</div>

</body>

</html>