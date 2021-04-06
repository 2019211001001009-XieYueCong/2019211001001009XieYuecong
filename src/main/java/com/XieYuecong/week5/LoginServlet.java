package com.XieYuecong.week5;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException{
        super.init();
        ServletContext Context=getServletContext();
        String driver=Context.getInitParameter("driver");
        String url=Context.getInitParameter("url");
        String username=Context.getInitParameter("username");
        String password=Context.getInitParameter("password");

        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String username=request.getParameter("UserName");
        String password=request.getParameter("Password");
        System.out.println("hello world");
        String sql="select * from usertable where username=? and password=? ";
        PreparedStatement ps=null;
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                System.out.println(rs.getString(2)+ " "+ rs.getString(3));
                out.println("Login Success!!!" );
                out.println("Welcome,"+username);
            }
            else
                out.println("Username or Password Error!!!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
