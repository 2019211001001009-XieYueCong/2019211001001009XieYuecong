<%--
  Created by IntelliJ IDEA.
  User: 86153
  Date: 2021/4/5 0005
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if (!(request.getAttribute("message")==null)){
        //error
        out.println(request.getAttribute("message"));}

%>
<%
//read cookies
    Cookie[] allCookies=request.getCookies();
    String username="",password="",rememberMeVal="";
    if(allCookies!=null){
        for (Cookie c:allCookies) {
            if(c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password=c.getValue();
            }
            if(c.getName().equals("cRememberMe")){
                rememberMeVal=c.getValue();

            }
            
        }
    }
%>
<form method="post"  action="login">
    Username:<input type="text" name="username" value="<%=username%>"><br/>
    Password:<input type="password" name="password" value="<%=password%>"><br/>
        <input type="checkbox" name="rememberMe" value="1" <%=rememberMeVal.equals("1") ?"checked":""%>checked/>RememberMe<br/>
    <input type="submit" value="login"/>
</form>

<%@include file="footer.jsp"%>

