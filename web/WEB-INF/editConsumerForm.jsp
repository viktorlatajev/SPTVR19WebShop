<%-- 
    Document   : editConsumerForm
    Created on : 17.03.2021, 11:16:51
    Author     : Elena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Редактирование покупателя</title>
    </head>
    <body>
        <h1>Редактирование покупателя</h1>
        <p>${info}</p>
        <form action="editConsumer" method="POST">
            <input type="hidden" name="consumerId" value="${consumer.id}">
            Имя: <input type="text" name="firstName" value="${consumer.firstName}"><br>
            Фамилия: <input type="text" name="lastName" value="${consumer.lastName}"><br>
            Деньги: <input type="text" name="money" value="${consumer.money}"><br>
            <input type="submit" name="submit" value="Изменить"><br>
        </form>
    </body>
</html>
