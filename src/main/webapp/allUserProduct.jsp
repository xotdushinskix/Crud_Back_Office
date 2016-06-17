
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>All users info</title>
</head>
<body>
<h3>Information and action</h3>


<h3>All users list:</h3>
<table border="2">
  <thead>
  <tr>
    <th>User Id</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Shop Experience</th>
    <th>Update</th>
    <th>Delete</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${users}" var="user1">
    <tr>
      <td>${user1.userId}</td>
      <td>${user1.firstName}</td>
      <td>${user1.lastName}</td>
      <td>${user1.shopExperience}</td>
      <td><a href="main/operation?action=updateUser&userId=<c:out value="${user1.userId}"/>">Update</a></td>
      <td><a href="main/operation?action=deleteUser&userId=<c:out value="${user1.userId}"/>">Delete</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>



<p><a href="main/operation?action=addUser">Add User</a></p>
<br>

<h3>All products list:</h3>
<table border="2">
  <thead>
  <tr>
    <th>Product Id</th>
    <th>Brand</th>
    <th>Model</th>
    <th>Stock</th>
    <th>MPN</th>
    <th>Update</th>
    <th>Delete</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${products}" var="product1">
    <tr>
      <td>${product1.productId}</td>
      <td>${product1.productBrand}</td>
      <td>${product1.productModel}</td>
      <td>${product1.productStock}</td>
      <td>${product1.productMPN}</td>
      <td><a href="main/operation?action=updateProduct&productId=<c:out value="${product1.productId}"/>">Update</a></td>
      <td><a href="main/operation?action=deleteProduct&productId=<c:out value="${product1.productId}"/>">Delete</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<p><a href="main/operation?action=addProduct">Add Product</a></p>



<h3>Order id:</h3>
<table border="2">
  <thead>
  <tr>
    <th>Order Id</th>
    <th>Created Date</th>
    <th>Order lines</th>
    <th>Change Status</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${ordersDNShip}" var="order">
    <tr>
      <td>${order.orderId}</td>
      <td>${order.currentData}</td>
      <td><a href="main/operation?action=orderLine&orderId=<c:out value="${order.orderId}"/>">Show</a></td>
      <td><a href="main/operation?action=changeShipStatus&orderId=<c:out value="${order.orderId}"/>">Change</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>



<h3>Shipped order id:</h3>
<table border="2">
  <thead>
  <tr>
    <th>Order Id</th>
    <th>Created Date</th>
    <th>Order lines</th>
    <%--<th>Ship Status</th>--%>
    <%--<th>Change Status</th>--%>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${ordersShip}" var="orderS">
    <tr>
      <td>${orderS.orderId}</td>
      <td>${orderS.currentData}</td>
      <td><a href="main/operation?action=orderLine&orderId=<c:out value="${orderS.orderId}"/>">Show</a></td>
      <%--<td>${orderS.shipStatus}</td>--%>
    </tr>
  </c:forEach>
  </tbody>
</table>




<%--<form action="ForA", method="post">--%>
  <%--<input type="submit" value="Logout" name="logout" style="position: absolute; top: 0; right: 0;">--%>
<%--</form>--%>
<jsp:include page="logout.html" />

</body>
</html>
