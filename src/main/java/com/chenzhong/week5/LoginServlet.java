package com.chenzhong.week5;

import com.chenzhong.dao.UserDao;
import com.chenzhong.model.User;

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
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        UserDao userDao=new UserDao();
        try {
           User user= userDao.findByUsernamePassword(conn,username,password);
           if(user!=null){
               request.setAttribute("user",user);
               request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
           }else {
               request.setAttribute("message",("Login failed"));
               request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
