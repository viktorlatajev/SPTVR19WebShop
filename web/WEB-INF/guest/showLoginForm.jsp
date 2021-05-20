<%-- 
    Document   : showLoginForm
    Created on : 17.03.2021, 12:06:27
    Author     : Elena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <h1>Войти</h1>
        <p>${info}</p>
        <form action="login" method="POST">
            Логин: <input type="text" name="login" value="${login}"><br>
            Пароль: <input type="password" name="password" value=""><br>
            <input type="submit" name="submit" value="Войти"><br>
            <p><a href="addConsumer">Регистрация</a></p>
        </form>
