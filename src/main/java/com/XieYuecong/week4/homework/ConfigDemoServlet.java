package com.XieYuecong.week4.homework;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//now its just a java class
//extend HttpServlet
public class ConfigDemoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println( "name: XieYuecong");
        writer.println( "studentid: 2019211001001009");
        //next we need to tell about this servlet to tomcat - how ? - web.xml

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){
        //when client request method is Post - here - inside doPost()

    }
}