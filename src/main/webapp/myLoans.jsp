<%@ page import="java.util.List" %>
<%@ page import="model.Loan" %>

<%
List<Loan> loans =
(List<Loan>)request.getAttribute("loans");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>My Loans</title>

<link rel="preconnect"
href="https://fonts.googleapis.com">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
rel="stylesheet">

<link rel="stylesheet"
href="${pageContext.request.contextPath}/css/myLoans.css">

</head>

<body>

<h1 class="page-title">
My Loan Applications
</h1>

<div class="table-container">

<table>

<tr>

<th>Loan ID</th>
<th>Bank</th>
<th>Loan Type</th>
<th>Amount</th>
<th>EMI</th>
<th>Processing Fee</th>
<th>Status</th>
<th>Applied Date</th>

</tr>

<%
if(loans != null && !loans.isEmpty()) {

for(Loan loan : loans) {
%>

<tr>

<td>
<%= loan.getId() %>
</td>

<td>
<%= loan.getBankName() %>
</td>

<td>
<%= loan.getLoanType() %>
</td>

<td>
&#8377; <%= String.format("%.2f", loan.getAmount()) %>
</td>

<td>
&#8377; <%= String.format("%.2f", loan.getEmi()) %>
</td>

<td>
&#8377; <%= String.format("%.2f", loan.getProcessingFee()) %>
</td>

<td>

<%
if("Approved".equalsIgnoreCase(loan.getStatus())){
%>

<span class="approved">
Approved
</span>

<%
}else if("Rejected".equalsIgnoreCase(loan.getStatus())){
%>

<span class="rejected">
Rejected
</span>

<%
}else{
%>

<span class="pending">
Pending
</span>

<%
}
%>

</td>

<td>
<%= loan.getCreatedAt() %>
</td>

</tr>

<%
}
}else{
%>

<tr>

<td colspan="8">
No Loan Records Found
</td>

</tr>

<%
}
%>

</table>

</div>

<br>

<a href="dashboard.jsp"
class="back-btn">

Back to Dashboard

</a>

</body>

</html>