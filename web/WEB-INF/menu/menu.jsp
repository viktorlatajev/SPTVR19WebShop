<%-- 
    Document   : menu
    Created on : 20.05.2021, 13:43:54
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp">Магазин парников</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="listProducts">Список парников</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="buyProductForm">Купить товар</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="addProduct">Добавить парник</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="listConsumers">Список покупателей</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="showLoginForm">Войти</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="logout">Выйти</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
