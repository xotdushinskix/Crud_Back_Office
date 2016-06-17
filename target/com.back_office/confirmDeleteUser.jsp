<%--
  Created by IntelliJ IDEA.
  User: nikita
  Date: 15.06.16
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Confirm Delete</title>
</head>
<body>
    <form action="/delete" method="post">
        Are you sure to delete product with <input type="text" readonly="readonly" name="userId"
                                                   value="<c:out value="${userId}" />" /> id?
        <input type="submit" value="Delete" name="delete_user">
    </form>
    <br>
    <a href="/main">Back To Main Page</a>
    <jsp:include page="logout.html" />
</body>
</html>
