<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<h1>${product.name}</h1>
<br />
<p>${product.description}</p>
<hr />
<p>Цена: ${product.price}</p>
<p>Код товара: ${product.code}</p>
<p>Категория товара: ${product.category.category}</p>


<a href="/product" >< Назад</a>
</body>
</html>