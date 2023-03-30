package com.chenzhong.week5;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(
        urlPatterns ={"/login"},
        initParams = {
                @WebInitParam(name="driver",value = "com.mysql.jdbc.Driver"),
                @WebInitParam(name="url",value = "jdbc:mysql://139.224.68.119:3306/userdb?characterEncoding=utf-8"),
                @WebInitParam(name="username",value = "user"),
                @WebInitParam(name="password",value = "123456"),

        },loadOnStartup = 1
)
public class LoginServlet extends HttpServlet {
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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String sql = String.format("select * from usertable where username='%s' and password='%s'",username,password);
        System.out.println(sql);
        PrintWriter out=response.getWriter();

        try {
            boolean pass= stmt.executeQuery(sql).next();
            if(pass){
                out.println("login successful");
                out.println("welcome:"+username);
            }else out.println("login failed");
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }
}
