package com.chenzhong.week5;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(
        urlPatterns ={"/login"}
)
public class LoginServlet extends HttpServlet {
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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String sql = String.format("select * from usertable where username='%s' and password='%s'",username,password);
        System.out.println(sql);

        try {
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()){
                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthdate",rs.getString("birthdate"));
                request.getRequestDispatcher("userlist.jsp").forward(request,response);
                System.out.println(rs.getString("username"));

//                out.println("login successful");
//                out.println("welcome:"+username);
            }else {
                request.setAttribute("message",("Login failed"));

                request.getRequestDispatcher("login.jsp").forward(request,response);


            }
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }
}
