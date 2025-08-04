package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        // SECURITY ISSUE #1: SQL Injection vulnerability
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            Statement stmt = conn.createStatement();

            // Vulnerable SQL Query (no sanitization)
            String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet rs = stmt.executeQuery(query);

            // SECURITY ISSUE #2: Sensitive information in response
            if (rs.next()) {
                response.getWriter().println("Welcome " + username + "! Your password is: " + password);
            } else {
                response.getWriter().println("Invalid login");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
