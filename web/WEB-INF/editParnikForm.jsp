<%-- 
    Document   : editParnikForm
    Created on : 17.03.2021, 10:09:47
    Author     : Elena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Редактирование товара</title>
    </head>
    <body>
        <h1>Редактирование товара</h1>
        <p>${info}</p>
        <form action="editParnik" method="POST">
            <input type="hidden" name="parnikId" value="${parnik.id}">
            Название: <input type="text" name="name" value="${parnik.name}"><br>
            Размер: <input type="text" name="size" value="${parnik.size}"><br>
            Количество: <input type="text" name="amount" value="${parnik.amount}"><br>
            Цена: <input type="text" name="price" value="${parnik.price}"><br>
            <input type="submit" name="submit" value="Изменить"><br>
        </form>
    </body>
</html>
