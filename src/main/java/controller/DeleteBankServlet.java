package controller;

import java.io.IOException;

import dao.BankDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteBankServlet")
public class DeleteBankServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int id =
        Integer.parseInt(
        request.getParameter("id"));

        BankDAO dao = new BankDAO();

        dao.deleteBank(id);

        response.sendRedirect(
                "ManageBanksServlet");
    }
}