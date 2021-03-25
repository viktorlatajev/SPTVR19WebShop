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
        <form action="editParnikForm" method="POST">
            <select name="parnikId" multiple="true">
                <option value="">Список парников</option>
                <c:forEach var="parnik" items="${listParniki}">
                    <option value="${parnik.id}"><p>Название: ${parnik.name};</p> <p>Размер: ${parnik.size}м;</p> <p>Количество: ${parnik.amount}шт.;</p> <p>Цена: ${parnik.price}€.</p><br></option>
                </c:forEach>
            </select>
            <input type="submit" value="Изменить">
        </form>

    </body>
</html>
