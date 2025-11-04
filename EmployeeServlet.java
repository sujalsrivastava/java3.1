package com.example.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {
    private final EmployeeDAO dao = new EmployeeDAO();

    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp)
            throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                EmployeeDAO.Employee emp = dao.getById(id);
                req.setAttribute("employee", emp);
            } catch (NumberFormatException e) {
                req.setAttribute("error", "Invalid ID format.");
            }
        } else {
            List<EmployeeDAO.Employee> list = dao.getAll();
            req.setAttribute("employees", list);
        }
        req.getRequestDispatcher("employees.jsp").forward(req, resp);
    }
}
