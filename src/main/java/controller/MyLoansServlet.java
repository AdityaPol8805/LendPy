package controller;

import java.io.IOException;
import java.util.List;

import dao.LoanDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Loan;

@WebServlet("/MyLoansServlet")
public class MyLoansServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Integer userId =
                (Integer) session.getAttribute("userId");

        if(userId == null) {

            response.sendRedirect("login.jsp");
            return;
        }

        LoanDAO dao = new LoanDAO();

        List<Loan> loans =
                dao.getLoansByUserId(userId);

        request.setAttribute("loans", loans);

        request.getRequestDispatcher("myLoans.jsp")
               .forward(request, response);
    }
}