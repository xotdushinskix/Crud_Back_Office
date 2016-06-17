<%--
  Created by IntelliJ IDEA.
  User: nikita
  Date: 15.06.16
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Change Ship Status</title>
</head>
<body>
    <form action="/AddEdit" method="post">
        Change ship status to order id #<input type="text" readonly="readonly" name="orderId"
                                                   value="<c:out value="${orderId}" />" /> <br>
        <%--<select name="shipStatus">--%>
            <%--<option name="0">Not Shipped</option>--%>
            <%--<option name="1">Shipped</option>--%>
        <%--</select><br> </br>--%>
        <input type="checkbox" name="not_shipped" value="false" checked="checked">Order doesn't ship<br>
        <input type="checkbox" name="shipped" value="true">Order is shipped<br>
        <input type="submit" value="Change" name="ship_status">
    </form>
<br>
    <a href="/main">Back To Main Page</a>
    <jsp:include page="logout.html" />
</body>
</html>
