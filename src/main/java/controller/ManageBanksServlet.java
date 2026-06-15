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

@WebServlet("/ManageBanksServlet")
public class ManageBanksServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        BankDAO dao = new BankDAO();

        List<Bank> banks =
                dao.getAllBanks();

        request.setAttribute("banks", banks);

        request.getRequestDispatcher(
                "manageBanks.jsp")
                .forward(request, response);
    }
}