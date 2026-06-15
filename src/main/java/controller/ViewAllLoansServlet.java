package controller;

import java.io.IOException;
import java.util.List;

import dao.LoanDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Loan;

@WebServlet("/ViewAllLoansServlet")
public class ViewAllLoansServlet
extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession();

        String adminEmail =
                (String)session.getAttribute(
                        "adminEmail");

        if(adminEmail == null) {

            response.sendRedirect(
                    "adminLogin.jsp");

            return;
        }

        LoanDAO dao =
                new LoanDAO();

        List<Loan> loans =
                dao.getAllLoans();

        request.setAttribute(
                "loans",
                loans);

        request.getRequestDispatcher(
                "allLoans.jsp")
                .forward(
                        request,
                        response);
    }
}