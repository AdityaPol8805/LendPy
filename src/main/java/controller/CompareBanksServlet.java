package controller;

import java.io.IOException;
import java.util.List;

import dao.BankDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Bank;

@WebServlet("/CompareBanksServlet")
public class CompareBanksServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

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

        BankDAO dao =
                new BankDAO();

        List<Bank> banks =
                dao.getBanksByLoanType(loanType);

        request.setAttribute("banks", banks);

        request.setAttribute("amount", amount);
        request.setAttribute("income", income);
        request.setAttribute("tenure", tenure);
        request.setAttribute("reason", reason);
        request.setAttribute("loanType", loanType);

        request.getRequestDispatcher(
                "compareBanks.jsp")
                .forward(request, response);
    }
}