<%@ page import="java.util.List" %>
<%@ page import="model.Bank" %>

<%
List<Bank> banks =
(List<Bank>) request.getAttribute("banks");

double amount =
(Double) request.getAttribute("amount");

double income =
(Double) request.getAttribute("income");

int tenure =
(Integer) request.getAttribute("tenure");

String loanType =
(String) request.getAttribute("loanType");

String reason =
(String) request.getAttribute("reason");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Compare Banks</title>

<link rel="preconnect"
href="https://fonts.googleapis.com">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
rel="stylesheet">

<link rel="stylesheet"
href="${pageContext.request.contextPath}/css/compareBanks.css">

</head>

<body>

<h1 class="page-title">
Compare Loan Offers
</h1>

<p class="page-subtitle">
Loan Type:
<%= loanType %>
</p>

<div class="summary-card">
    <h3>Loan Comparison Results</h3>
    <p>Compare EMI, eligibility, and processing fees before applying.</p>
</div>

<div class="table-container">

<table>

<tr>

<th>Bank</th>
<th>Interest Rate</th>
<th>Processing Fee</th>
<th>EMI</th>
<th>Eligibility</th>
<th>Action</th>

</tr>

<%
for(Bank bank : banks){

boolean eligible =
income >= bank.getMinIncome()
&& amount <= bank.getMaxAmount()
&& tenure <= bank.getMaxTenure();

double monthlyRate =
bank.getInterestRate() / 12 / 100;

double emi =
(amount * monthlyRate *
Math.pow(1 + monthlyRate, tenure))
/
(Math.pow(1 + monthlyRate, tenure) - 1);
%>

<tr>

<td>
<%= bank.getBankName() %>
</td>

<td>
<%= bank.getInterestRate() %> %
</td>

<td>
&#8377; <%= bank.getProcessingFee() %>
</td>

<td>
&#8377; <%= String.format("%.2f", emi) %>
</td>

<td>

<%
if(eligible){
%>

<span class="eligible">
Eligible
</span>

<%
}else{
%>

<span class="not-eligible">
Not Eligible
</span>

<%
}
%>

</td>

<td>

<%
if(eligible){
%>

<a href="ApplySelectedBankServlet?
loanType=<%= loanType %>
&amount=<%= amount %>
&income=<%= income %>
&tenure=<%= tenure %>
&reason=<%= reason %>
&bankName=<%= bank.getBankName() %>
&interestRate=<%= bank.getInterestRate() %>
&processingFee=<%= bank.getProcessingFee() %>"
class="apply-btn">

Apply

</a>

<%
}else{
%>

-

<%
}
%>

</td>

</tr>

<%
}
%>

</table>

</div>

<a href="applyLoan.jsp"
class="back-btn">

← Back

</a>

</body>

</html>