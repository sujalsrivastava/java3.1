CREATE DATABASE nimbus_app;
USE nimbus_app;

-- Users for login (simple)
CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL,
  fullname VARCHAR(200)
);

-- sample user
INSERT INTO users (username, password, fullname) VALUES ('john', 'pass123', 'John Doe');

-- Employee table
CREATE TABLE employees (
  EmpID INT PRIMARY KEY,
  Name VARCHAR(200),
  Salary DECIMAL(10,2)
);

INSERT INTO employees (EmpID, Name, Salary) VALUES
(101, 'Amit Sharma', 30000.00),
(102, 'Priya Singh', 35000.00),
(103, 'Rakesh Kumar', 28000.00);

-- Attendance table
CREATE TABLE attendance (
  id INT AUTO_INCREMENT PRIMARY KEY,
  student_id VARCHAR(50),
  attendance_date DATE,
  status VARCHAR(20),
  recorded_by VARCHAR(100)
);
