package com.chenzhong.week4.homework.exercise1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;


public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config=getServletConfig();
        String name=config.getInitParameter("name");
        String id=config.getInitParameter("id");
        PrintWriter out=response.getWriter();
        out.write("<br>username:"+name);
        out.write("<br>ID:"+id);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
