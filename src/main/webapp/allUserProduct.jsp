
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
    <th>Purchases</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${users}" var="user1">
    <tr>
      <td>${user1.userId}</td>
      <td>${user1.firstName}</td>
      <td>${user1.lastName}</td>
      <td>${user1.shopExperience}</td>
      <td><a href="ShowAll?action=updateUser&userId=<c:out value="${user1.userId}"/>">Update</a></td>
      <td><a href="ShowAll?action=deleteUser&userId=<c:out value="${user1.userId}"/>">Delete</a></td>
      <td><a href="ShowAll?action=watchUserPurchases&userId=<c:out value="${user1.userId}"/>">Show</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>



<p><a href="ShowAll?action=addUser">Add User</a></p>
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
    <th>Add to cart</th>
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
      <td><a href="ShowAll?action=updateProduct&productId=<c:out value="${product1.productId}"/>">Update</a></td>
      <td><a href="ShowAll?action=deleteProduct&productId=<c:out value="${product1.productId}"/>">Delete</a></td>
      <td><a href="ShowAll?action=purchase&productId=<c:out value="${product1.productId}"/>">To cart</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<p><a href="ShowAll?action=addProduct">Add Product</a></p>
</body>
</html>
