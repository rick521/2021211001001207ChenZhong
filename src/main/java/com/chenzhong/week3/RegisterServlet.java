package com.chenzhong.week3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(
        urlPatterns ={"/register"}
)

public class RegisterServlet extends HttpServlet {
    private Connection conn;
    private Statement stmt;

    @Override
    public void init() throws ServletException {
        conn=(Connection)getServletContext().getAttribute("con");
        try {
            stmt=conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthdate=request.getParameter("birthdate");
        String sql = String.format("insert into usertable (username,password,email,gender,birthdate) VALUES ('%s','%s','%s','%s','%s')",username,password,email,gender,birthdate);
        System.out.println(sql);


        try {
            stmt.execute(sql);
            response.sendRedirect("login.jsp");

        } catch (SQLException e) {
            response.sendRedirect("register.jsp");

            throw new RuntimeException(e);
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    @Override
    public void destroy() {
        try {
            conn.close();
            stmt.close();
        } catch (SQLException e) {throw new RuntimeException(e);}

    }
}
