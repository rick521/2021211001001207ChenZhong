package com.chenzhong.week3;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;


public class LifeCycleServlet extends HttpServlet {
    public LifeCycleServlet(){
        System.out.println("been new");//one time
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("been init");//one time
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet()");//many times

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("been destroy");

    }
}
