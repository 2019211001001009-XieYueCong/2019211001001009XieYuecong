package com.XieYuecong.week4.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

 /*@WebServlet(
        urlPatterns  ={"/jdbc"},
        initParams = {
                @WebInitParam(name="driver",value="com.microsoft.sqlserver.jdbc.sQlServerDriver"),
                @WebInitParam(name="url",value="jdbc:sqlserver://localhost;databaseName=userdb;"),
                @WebInitParam(name="username",value="sa"),
                @WebInitParam(name="password",value="123456")
        },loadOnStartup = 1
)*/

public class JDBCDemoServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException{
        //connect only once
        //String driver="com.microsoft.sqlserver.jdbc.sqlServerDriver";
        //String url="jdbc:sqlserver://localhost;databaseName=userdb;";
        //String username="sa";
        //String password="123456";
        ServletConfig config=getServletConfig();
        String driver=config.getInitParameter("driver");
        String url=config.getInitParameter("url");
        String username=config.getInitParameter("username");
        String password=config.getInitParameter("password");

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
    //connect many times--bad way
        System.out.println("I am in doGet()");
        String sql="select *from userdb.usertable";
        try {
            ResultSet rs=con.createStatement().executeQuery(sql);
            while(rs.next()){

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //print - write into response
    }

    @Override
    public void destroy(){
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
