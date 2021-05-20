<%-- 
    Document   : listProducts
    Created on : 14.01.2021, 14:36:44
    Author     : Elena
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h3>Список парников</h3>
<form action="editProductForm" method="POST">
    <select name="productId" multiple="true">
        <option value="">Список парников</option>
        <c:forEach var="product" items="${listProducts}">
            <option value="${product.id}"><p>Название: ${product.name};</p> <p>Размер: ${product.size}м;</p> <p>Количество: ${product.amount}шт.;</p> <p>Цена: ${product.price}€.</p><br></option>
        </c:forEach>
    </select>
    <input type="submit" value="Изменить">
</form>
    
