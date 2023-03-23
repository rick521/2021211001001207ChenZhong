package com.chenzhong.week4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(
        urlPatterns ={"/jdbc_week4"},
        initParams = {
                @WebInitParam(name="driver",value = "com.mysql.jdbc.Driver"),
                @WebInitParam(name="url",value = "jdbc:mysql://139.224.68.119:3306/userdb?characterEncoding=utf-8"),
                @WebInitParam(name="username",value = "user"),
                @WebInitParam(name="password",value = "123456"),

        },loadOnStartup = 1
)
public class JDBCDemoServlet extends HttpServlet {
    private Connection conn;

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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
