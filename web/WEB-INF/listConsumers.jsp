<%-- 
    Document   : listConsumers
    Created on : 14.01.2021, 16:05:29
    Author     : Elena
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список покупателей</title>
    </head>
    <body>
        <h1>Список покупателей</h1>
        <ul>
            <c:forEach var="consumer" items="${listConsumers}">
                <li><p>Имя: ${consumer.firstName};</p> <p>Фамилия: ${consumer.lastName};</p> <p>Деньги: ${consumer.money}€.</p><br></li>
            </c:forEach>
        </ul>
    </body>
</html>
