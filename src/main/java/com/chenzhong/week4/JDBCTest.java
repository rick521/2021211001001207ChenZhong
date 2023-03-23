package com.chenzhong.week4;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCTest {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://139.224.68.119:3306/userdb?characterEncoding=utf-8";
    static final String USER = "user";
    static final String PASS = "123456";

    public JDBCTest() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println(conn.getClientInfo());
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new JDBCTest();
    }
}
