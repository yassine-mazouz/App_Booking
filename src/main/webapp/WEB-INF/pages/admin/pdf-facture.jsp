<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%><%@ taglib
        prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<spring:url value="/resources/" var="resources" />


<!doctype html>
<html lang="en">
<head>
    <title>SpringHow html to pdf</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div>
    <p >Lorum ipsum some text before image. Lorum ipsum some text before image. Lorum ipsum some text before image. Lorum ipsum some text before image. Lorum ipsum some text before image. Lorum ipsum some text before image. Lorum ipsum some text before image. Lorum ipsum some text before image. </p>
    <img src="photo.jpg" alt="Orange">
    <p >Lorum ipsum some text after image. Lorum ipsum some text after image. Lorum ipsum some text after image. Lorum ipsum some text after image. Lorum ipsum some text after image. Lorum ipsum some text after image. Lorum ipsum some text after image. Lorum ipsum some text after image. Lorum ipsum some text after image.</p>
    <table>
        <tr><th>Product</th><th>Quantity</th><th>Price</th><th>Total</th></tr>
        <tr><td>Jeans</td><td>2</td><td>10.99</td><td>20.98</td></tr>
        <tr><td>Shirt</td><td>2</td><td>7.99</td><td>14.98</td></tr>
    </table>
</div>
</body>
</html>