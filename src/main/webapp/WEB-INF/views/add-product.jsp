<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<h1>Добавление поста</h1>
<form method="POST" action="/product" id="newProduct" name ="newProduct" enctype="multipart/form-data">
    <p>Название продукта: </p>
    <input type="text" id="name" name="name" value="" /><br />
    <p>Описание продукта: </p>
    <input type="text" id="description" name="description" value="" /><br />
    <p>Код продукта: </p>
    <input type="text" id="code" name="code" value="" /><br />
    <p>Цена продукта: </p>
    <input type="text" id="price" name="price" value="" /><br />
    <p>Код категории продукта: </p>
    <input type="text" id="category.id" name="category" value="" /><br />

    <input type="submit" id="btnAddPost" name="btnAddPost" value="Add Product" onclick="" style="cursor:pointer"/>
</form>

<a href="/product" >< Назад</a>
</body>
</html>