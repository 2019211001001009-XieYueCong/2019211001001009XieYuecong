package com.XieYuecong.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
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


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        //request.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        String sql ="insert into usertable(id,username,password,email,gender,birthdate)values(?,?,?,?,?,?)";
        String id=request.getParameter("id");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthdate=request.getParameter("birthdate");
        PreparedStatement ps=null;
        try{
            try {
                ps=con.prepareStatement(sql);
                ps.setString(1,id);
                ps.setString(2,username);
                ps.setString(3,password);
                ps.setString(4,email);
                ps.setString(5,gender);
                ps.setString(6,birthdate);
                ps.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql_1="select *from usertable";
        out.print("<html>");
        out.print("<table border='1'>");
        out.print("<tr>");
        out.print("<td>ID</td>");
        out.print("<td>UserName</td>");
        out.print("<td>Password</td>");
        out.print("<td>Email</td>");
        out.print("<td>gender</td>");
        out.print("<td>BirthDate</td>");
        out.print("</tr>");
        try {
            ResultSet rs=con.createStatement().executeQuery(sql_1);
            while(rs.next()){
                //get from rs - print - write into response
                out.print("<tr>");
                out.print("<td>"+rs.getString(1));
                out.print("</td>");
                out.print("<td>"+rs.getString(2));
                out.print("</td>");
                out.print("<td>"+rs.getString(3));
                out.print("</td>");
                out.print("<td>"+rs.getString(4));
                out.print("</td>");
                out.print("<td>"+rs.getString(5));
                out.print("</td>");
                out.print("<td>"+rs.getString(6));
                out.print("</td>");
                out.print("</tr>");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        out.print("</table>");
        out.print("</html>");

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
