package com.chenzhong.week6;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@WebListener
public class JDBCServletContextLister implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context=sce.getServletContext();
        String JDBC_DRIVER=context.getInitParameter("driver");
        String DB_URL=context.getInitParameter("url");
        String USER=context.getInitParameter("username");
        String PASS=context.getInitParameter("password");
        System.out.println(DB_URL);

        try {
            System.out.println("context...");

            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            context.setAttribute("con",conn);
            System.out.println(conn.getClientInfo());

        } catch (Exception e) {
            System.out.println(e.getCause());

            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().removeAttribute("con");
    }

}
