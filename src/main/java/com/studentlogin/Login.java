package com.studentlogin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user use = new user(username, password); // Ensure User class is used
        LoginDAO logindao = new LoginDAO();

        try {
            if (logindao.insert(use)) {
                response.sendRedirect("NewFile2.jsp"); // Redirect to success page
            } else {
                response.sendRedirect("NewFile.jsp"); // Redirect to failure page
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            //response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request.");
        }
    }
}
