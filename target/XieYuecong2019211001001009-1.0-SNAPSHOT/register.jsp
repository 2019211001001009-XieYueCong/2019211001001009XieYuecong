<%--
  Created by IntelliJ IDEA.
  User: 86153
  Date: 2021/3/17 0017
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body style="font-size: 8px;text-align: center">
<h1 style="color: gray">New User Registration!</h1>
<form method="post" action="register"> <!-- what is method when wo use form?--><!--its GET , why? default is GET,form data is added in the URL,you can see-->
    <!-- its better to use POST in form,data in not added in the URL-->
    <input type="text" name="username" placeholder="username" style="width: 200px;height: 25px;margin-top: 2px;background-color: antiquewhite"><br/>
    <input type="password" name="password" placeholder="password" style="width: 200px;height: 25px;margin-top: 5px;background-color: antiquewhite"><br/>
    <input type="text" name="email" placeholder="email" style="width: 200px;height: 25px;margin-top: 5px;background-color: antiquewhite"><br/>
    Gender <input type="radio" name="gender" value="male">Male
    <input type="radio" name="gender" value="female">Female<br/>
    <input type="text" name="birthDate" placeholder="Date of Birth(yyyy-mm-dd)" style="width: 200px;height: 25px;margin-top: 5px;margin-bottom: 5px;background-color: antiquewhite"><br/>
    <input type="submit" value="register" style="background-color:#ffa500;color: white;width: 100px;height: 25px;text-align: center;font-size: 15px">
</form>

</body>
</html>
