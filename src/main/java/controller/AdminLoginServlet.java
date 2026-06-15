package controller;

import java.io.IOException;

import dao.AdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet
extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");

        AdminDAO dao =
                new AdminDAO();

        if(dao.loginAdmin(email,password)) {

            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "adminEmail",
                    email);

            response.sendRedirect(
                    "adminDashboard.jsp");

        } else {

            response.getWriter().println(
                    "Invalid Admin Credentials");

        }
    }
}