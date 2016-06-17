<%--
  Created by IntelliJ IDEA.
  User: nikita
  Date: 16.06.16
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Order Lines</title>
</head>
<body>
    <h3>Order lines:</h3>
    <table border="2">
        <thead>
        <tr>
            <th>User Id</th>
            <th>Name</th>
            <th>Last Name</th>
            <th>Product ID</th>
            <th>Brand</th>
            <th>Model</th>
            <th>Bought Quantity</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${orderLines}" var="orderLine">
            <tr>
                <td>${orderLine.user.userId}</td>
                <td>${orderLine.user.firstName}</td>
                <td>${orderLine.user.lastName}</td>
                <td>${orderLine.product.productId}</td>
                <td>${orderLine.product.productBrand}</td>
                <td>${orderLine.product.productModel}</td>
                <td>${orderLine.boughtQuantity}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <a href="/main">Back To Main Page</a>
    <jsp:include page="logout.html" />
</body>
</html>
