<%-- 
    Document   : addProductForm
    Created on : 14.01.2021, 9:10:32
    Author     : Elena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <h3>Добавить парник</h3>
        <form action="createProduct" method="POST">
            Название: <input type="text" name="name" value="${name}"><br>
            Размер: <input type="text" name="size" value="${size}"><br>
            Количество: <input type="text" name="amount" value="${amount}"><br>
            Цена: <input type="text" name="price" value="${price}"><br>
            <input type="submit" name="submit" value="Добавить"><br>
        </form>

