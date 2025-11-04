package com.example.app;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class AttendanceDAO {
    public boolean insert(String studentId, java.util.Date date, String status, String recordedBy) {
        String sql = "INSERT INTO attendance (student_id, attendance_date, status, recorded_by) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, studentId);
            ps.setDate(2, new Date(date.getTime()));
            ps.setString(3, status);
            ps.setString(4, recordedBy);
            int updated = ps.executeUpdate();
            return updated > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
