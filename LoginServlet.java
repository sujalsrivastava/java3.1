package com.example.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            resp.sendRedirect("login.html?error=Please+enter+credentials");
            return;
        }

        if (userDAO.validate(username, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            session.setAttribute("fullname", userDAO.getFullName(username));
            resp.sendRedirect("welcome.jsp");
        } else {
            resp.sendRedirect("login.html?error=Invalid+credentials");
        }
    }
}
