<%-- 
    Document   : buyProduct
    Created on : 19.01.2021, 14:53:41
    Author     : Elena
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Покупка товара</title>
    </head>
    <body>
        <h1>Купить товар</h1>
        <p>${info}</p>
        <form action="buyProduct" method="POST">
            <select name="productId">
                <option value="">Выберите парник</option>
                <c:forEach var="product" items="${listProducts}">
                    <option value="${product.id}"><p>Название: ${product.name};</p> <p>Размер: ${product.size}м;</p> <p>Количество: ${product.amount}шт.;</p> <p>Цена: ${product.price}€.</p><br></option>
                </c:forEach>
            </select>
            <br>
            
            <br>
            <input type="submit" value="Купить товар">
        </form>
    </body>
</html>
