<%-- 
    Document   : editConsumerForm
    Created on : 17.03.2021, 11:16:51
    Author     : Elena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <h3>Редактирование покупателя</h3>
        <p>${info}</p>
        <form action="editConsumer" method="POST">
            <input type="hidden" name="consumerId" value="${consumer.id}">
            Имя: <input type="text" name="firstName" value="${consumer.firstName}"><br>
            Фамилия: <input type="text" name="lastName" value="${consumer.lastName}"><br>
            Деньги: <input type="text" name="money" value="${consumer.money}"><br>
            <input type="submit" name="submit" value="Изменить"><br>

