<%-- 
    Document   : addConsumerForm
    Created on : 14.01.2021, 15:02:41
    Author     : Elena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Регистрация</title>
    </head>
    <body>
        <h1>Регистрация</h1>
        <form action="createConsumer" method="POST">
            Имя: <input type="text" name="firstName" value="${firstName}"><br>
            Фамилия: <input type="text" name="lastName" value="${lastName}"><br>
            Деньги: <input type="text" name="money" value="${money}"><br>
            Логин: <input type="text" name="login" value="${login}"><br>
            Пароль: <input type="password" name="password" value=""><br>
            <input type="submit" name="submit" value="Добавить"><br>
        </form>
    </body>
</html>
