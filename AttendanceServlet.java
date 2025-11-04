package com.example.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/attendance")
public class AttendanceServlet extends HttpServlet {
    private final AttendanceDAO dao = new AttendanceDAO();

    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp)
            throws ServletException, IOException {
        // show the attendance form JSP
        req.getRequestDispatcher("attendance.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp)
            throws ServletException, IOException {
        String studentId = req.getParameter("studentId");
        String dateStr = req.getParameter("date");
        String status = req.getParameter("status");
        HttpSession session = req.getSession(false);
        String recordedBy = (session != null && session.getAttribute("username") != null)
                ? (String) session.getAttribute("username") : "anonymous";

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            boolean ok = dao.insert(studentId, date, status, recordedBy);
            if (ok) {
                resp.sendRedirect("success.jsp?msg=Attendance+recorded");
            } else {
                resp.sendRedirect("attendance.jsp?error=Unable+to+save");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("attendance.jsp?error=Invalid+date+format");
        }
    }
}
