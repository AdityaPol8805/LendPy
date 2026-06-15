package controller;

import java.io.IOException;

import dao.LoanDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/UpdateLoanStatusServlet")
public class UpdateLoanStatusServlet
extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession();

        String adminEmail =
                (String) session.getAttribute(
                        "adminEmail");

        if(adminEmail == null) {

            response.sendRedirect(
                    "adminLogin.jsp");

            return;
        }

        int loanId =
                Integer.parseInt(
                        request.getParameter("id"));

        String status =
                request.getParameter("status");

        LoanDAO dao =
                new LoanDAO();

        dao.updateLoanStatus(
                loanId,
                status);

        response.sendRedirect(
                "ViewAllLoansServlet");
    }
}