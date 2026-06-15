package controller;

import java.io.IOException;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
protected void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

    String email = request.getParameter("email");
    String password = request.getParameter("password");

    UserDAO dao = new UserDAO();

    if (dao.loginUser(email, password)) {

        int userId = dao.getUserIdByEmail(email);

        HttpSession session = request.getSession();

        session.setAttribute("userId", userId);
        session.setAttribute("email", email);

        response.sendRedirect("dashboard.jsp");

    } else {

        response.getWriter().println("Invalid Email or Password");

    }
}


}
