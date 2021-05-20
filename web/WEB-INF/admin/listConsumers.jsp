<%-- 
    Document   : listConsumers
    Created on : 14.01.2021, 16:05:29
    Author     : Elena
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <h3>Список покупателей</h3>
        <form action="editConsumerForm" method="POST">
            <select name="consumerId" multiple="true">
                <option value="">Список покупателей</option>
                <c:forEach var="consumer" items="${listConsumers}">
                    <option value="${consumer.id}"><p>Имя: ${consumer.firstName};</p> <p>Фамилия: ${consumer.lastName};</p> <p>Деньги: ${consumer.money}€.</p><br></option>
                </c:forEach>
            </select>
        <input type="submit" value="Изменить">
        </form>

