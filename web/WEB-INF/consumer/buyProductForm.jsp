<%-- 
    Document   : buyProduct
    Created on : 19.01.2021, 14:53:41
    Author     : Elena
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <h3>Купить товар</h3>
        <p>${info}</p>
        <form action="buyProduct" method="POST">
            <select name="productId">
                <option value="">Выберите парник</option>
                <c:forEach var="product" items="${listProducts}">
                    <option value="${product.id}"><p>Название: ${product.name};</p> <p>Размер: ${product.size}м;</p> <p>Количество: ${product.amount}шт.;</p> <p>Цена: ${product.price}€.</p><br></option>
                </c:forEach>
            </select>
            <br>
            
            <br>
            <input type="submit" value="Купить товар">
        </form>

