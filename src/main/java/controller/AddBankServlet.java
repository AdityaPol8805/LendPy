package controller;

import java.io.IOException;

import dao.BankDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Bank;

@WebServlet("/AddBankServlet")
public class AddBankServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        Bank bank = new Bank();

        bank.setBankName(
                request.getParameter("bankName"));

        bank.setLoanType(
                request.getParameter("loanType"));

        bank.setInterestRate(
                Double.parseDouble(
                request.getParameter("interestRate")));

        bank.setMinIncome(
                Double.parseDouble(
                request.getParameter("minIncome")));

        bank.setMaxAmount(
                Double.parseDouble(
                request.getParameter("maxAmount")));

        bank.setMaxTenure(
                Integer.parseInt(
                request.getParameter("maxTenure")));

        bank.setProcessingFee(
                Double.parseDouble(
                request.getParameter("processingFee")));

        BankDAO dao = new BankDAO();

        dao.addBank(bank);

        response.sendRedirect("ManageBanksServlet");
    }
}