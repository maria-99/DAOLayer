<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<h1>Продукты:</h1>
<p><a href="/product?view=table">Отобразить таблицей</a></p>
<br />
<ul type="square">
    <c:forEach var="product" items="${productList}">
        <li><a href="product/${product.productId}" >${product.name}</a></li>
        <ul type="disc">
        </ul>
    </c:forEach>
</ul>
<a href="/product/new">Добавить продукт</a>
</body>
</html>