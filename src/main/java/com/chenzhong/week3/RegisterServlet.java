package com.chenzhong.week3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(
        urlPatterns ={"/register"},
        initParams = {
                @WebInitParam(name="driver",value = "com.mysql.jdbc.Driver"),
                @WebInitParam(name="url",value = "jdbc:mysql://139.224.68.119:3306/userdb?characterEncoding=utf-8"),
                @WebInitParam(name="username",value = "user"),
                @WebInitParam(name="password",value = "123456"),

        },loadOnStartup = 1
)

public class RegisterServlet extends HttpServlet {
    private Connection conn;
    private Statement stmt;

    @Override
    public void init() throws ServletException {
        ServletConfig config=getServletConfig();
        String JDBC_DRIVER=config.getInitParameter("driver");
        String DB_URL=config.getInitParameter("url");
        String USER=config.getInitParameter("username");
        String PASS=config.getInitParameter("password");
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM usertable");PrintWriter out=response.getWriter();
            out.println("<table border='1'>");
            out.println("<tr><th>Username</th><th>Password</th><th>Email</th><th>Gender</th><th>Birthdate</th></tr>");

            while(rs.next()){
                String username  = rs.getString("username");
                String password = rs.getString("password");
                String email= rs.getString("email");
                String gender  = rs.getString("gender");
                String birthdate = rs.getString("birthdate");
                out.println("<tr><td>" + username + "</td><td>" + password + "</td><td>" + email + "</td><td>" + gender + "</td><td>" + birthdate + "</td></tr>");

            }
            rs.close();
        }catch (Exception e){

        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthdate=request.getParameter("birthdate");
        String sql = String.format("insert into usertable (username,password,email,gender,birthdate) VALUES ('%s','%s','%s','%s','%s')",username,password,email,gender,birthdate);
        System.out.println(sql);
        try {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void destroy() {
        try {
            conn.close();
            stmt.close();
        } catch (SQLException e) {throw new RuntimeException(e);}

    }
}
