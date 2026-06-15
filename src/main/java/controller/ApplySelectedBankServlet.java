package controller;

import java.io.IOException;

import dao.LoanDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Loan;

@WebServlet("/ApplySelectedBankServlet")
public class ApplySelectedBankServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession();

        Integer userId =
                (Integer) session.getAttribute("userId");

        if(userId == null){

            response.sendRedirect("login.jsp");
            return;
        }

        String loanType =
                request.getParameter("loanType");

        double amount =
                Double.parseDouble(
                        request.getParameter("amount"));

        double income =
                Double.parseDouble(
                        request.getParameter("income"));

        int tenure =
                Integer.parseInt(
                        request.getParameter("tenure"));

        String reason =
                request.getParameter("reason");

        String bankName =
                request.getParameter("bankName");

        double interestRate =
                Double.parseDouble(
                        request.getParameter("interestRate"));

        double processingFee =
                Double.parseDouble(
                        request.getParameter("processingFee"));

        double monthlyRate =
                interestRate / 12 / 100;

        double emi =
                (amount * monthlyRate *
                Math.pow(1 + monthlyRate, tenure))
                /
                (Math.pow(1 + monthlyRate, tenure) - 1);

        Loan loan = new Loan();

        loan.setUserId(userId);
        loan.setLoanType(loanType);
        loan.setAmount(amount);
        loan.setIncome(income);
        loan.setInterestRate(interestRate);
        loan.setTenure(tenure);
        loan.setEmi(emi);
        loan.setStatus("Pending");
        loan.setReason(reason);

        loan.setBankName(bankName);
        loan.setProcessingFee(processingFee);

        LoanDAO dao = new LoanDAO();

        if(dao.applyLoan(loan)){

            response.sendRedirect("MyLoansServlet");

        }else{

            response.getWriter().println(
                    "Loan Application Failed");
        }
    }
}