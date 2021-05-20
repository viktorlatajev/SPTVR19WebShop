<%-- 
    Document   : editProductForm
    Created on : 17.03.2021, 10:09:47
    Author     : Elena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <h3>Редактирование товара</h3>
        <p>${info}</p>
        <form action="editProduct" method="POST">
            <input type="hidden" name="productId" value="${product.id}">
            Название: <input type="text" name="name" value="${product.name}"><br>
            Размер: <input type="text" name="size" value="${product.size}"><br>
            Количество: <input type="text" name="amount" value="${product.amount}"><br>
            Цена: <input type="text" name="price" value="${product.price}"><br>
            <input type="submit" name="submit" value="Изменить"><br>
        </form>

