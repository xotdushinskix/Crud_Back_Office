<%--
  Created by IntelliJ IDEA.
  User: nikita
  Date: 15.06.16
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html>
<head>
    <title>Admin login</title>
</head>
<body>
    <form action="login" method="post" style="position: fixed; top: 40%; left: 40%">
        Login: <input type="text" name="login"><br> </br>
        Password: <input type="password" name="password"><br> </br>
        <input type="submit" value="Enter"><br> </br>
    </form>
    <br>
    <p style="position: fixed; top: 50%; left: 40%">${message}</p>
</body>
</html>
