<%-- 
    Document   : listParniki
    Created on : 14.01.2021, 14:36:44
    Author     : Elena
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список парников</title>
    </head>
    <body>
        <h1>Список парников</h1>
        <ul>
            <c:forEach var="parnik" items="${listParniki}">
                <li><p>Название: ${parnik.name};</p> <p>Размер: ${parnik.size}м;</p> <p>Количество: ${parnik.amount}шт.;</p> <p>Цена: ${parnik.price}€.</p><br></li>
            </c:forEach>
        </ul>

    </body>
</html>
