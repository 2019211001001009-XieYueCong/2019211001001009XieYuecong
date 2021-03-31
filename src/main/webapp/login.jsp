<%--
  Created by IntelliJ IDEA.
  User: 86153
  Date: 2021/4/5 0005
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1>Login</h1>
<form method="post"  action="login">
    UserName:<input type="text" name="UserName"><br/>
    Password:<input type="text" name="Password"><br/>
    <input type="submit" value="login"/>
</form>
<%@include file="footer.jsp"%>
</body>
</html>
