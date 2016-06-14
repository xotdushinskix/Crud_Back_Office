<%--
  Created by IntelliJ IDEA.
  User: FromxSoul
  Date: 07.06.2016
  Time: 21:22
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
<form action="AddEdit" method="post">
  Product ID : <input type="text" readonly="readonly" name="productIdAddEditPage" value="<c:out value="${product.productId}" />" />
  <br/>
  Product Brand : <input type="text" name="productbrand" value="<c:out value="${product.productBrand}" />" />
  <br/>
  Product Model : <input type="text" name="productmodel" value="<c:out value="${product.productModel}" />" />
  <br/>
  Product Stock : <input type="text" name="productstock" value="<c:out value="${product.productStock}" />" />
  <br/>
  Product MPN : <input type="text" name="productmpn" value="<c:out value="${product.productMPN}" />" />
  <br/>
  <input type="submit" value="Submit" name="addEditProduct"/>
</form>
<td><a href="ShowAll?action=showAllUserAndProduct">Back To Main Page</a></td>
</body>
</html>