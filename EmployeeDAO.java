package com.example.app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public static class Employee {
        public int empId;
        public String name;
        public double salary;

        public Employee(int empId, String name, double salary) {
            this.empId = empId;
            this.name = name;
            this.salary = salary;
        }
    }

    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT EmpID, Name, Salary FROM employees";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Employee(rs.getInt("EmpID"), rs.getString("Name"), rs.getDouble("Salary")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Employee getById(int id) {
        String sql = "SELECT EmpID, Name, Salary FROM employees WHERE EmpID=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Employee(rs.getInt("EmpID"), rs.getString("Name"), rs.getDouble("Salary"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
