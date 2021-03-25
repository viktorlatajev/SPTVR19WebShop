<%-- 
    Document   : showLoginForm
    Created on : 17.03.2021, 12:06:27
    Author     : Elena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Войти</title>
    </head>
    <body>
        <h1>Войти</h1>
        <p>${info}</p>
        <form action="login" method="POST">
            Логин: <input type="text" name="login" value="${login}"><br>
            Пароль: <input type="password" name="password" value=""><br>
            <input type="submit" name="submit" value="Войти"><br>
        </form>
    </body>
</html>
