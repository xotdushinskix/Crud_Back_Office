<%--
  Created by IntelliJ IDEA.
  User: FromxSoul
  Date: 07.06.2016
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Add or edit user</title>
</head>
<body>
<form action="/AddEdit" method="post">
  User ID : <input type="text" readonly="readonly" name="userIdAddEditPage" value="<c:out value="${user.userId}" />" />
  <br/>
  First Name : <input type="text" name="firstname" value="<c:out value="${user.firstName}" />" />
  <br/>
  Last Name : <input type="text" name="lastname" value="<c:out value="${user.lastName}" />" />
  <br/>
  Shop Experience : <input type="text" name="shopexperience" value="<c:out value="${user.shopExperience}" />" />
  <br/>
  <input type="submit" value="Submit" name="addEditUser"/>
</form>
<br>
<a href="/main">Back To Main Page</a>
<jsp:include page="logout.html" />
</body>
</html>