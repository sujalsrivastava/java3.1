# Nimbus WebApp (Servlet + JSP + JDBC)

## Description
This is a simple Maven WAR Java web application demonstrating:
- User login via Servlet and HTML form
- Employee records display and search using JDBC and Servlet
- Student attendance form using JSP and Servlet and saving to DB

## Prerequisites
- Java 11+
- Maven
- Apache Tomcat (or other servlet container)
- MySQL (create DB and tables using provided SQL)

## Setup
1. Edit `src/main/java/com/example/app/DBUtil.java` and set DB URL/user/password.
2. Run SQL in MySQL to create `nimbus_app` database and tables (see SQL/create_db.sql).
3. Build WAR:
   ```
   mvn clean package
   ```
4. Deploy `target/nimbus-webapp.war` to Tomcat `webapps/` (or use your IDE).
5. Open: `http://localhost:8080/nimbus-webapp/`

## Default test user
username: `john`
password: `pass123`
