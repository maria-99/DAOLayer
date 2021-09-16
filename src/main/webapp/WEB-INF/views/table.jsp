<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<h1>Продукты:</h1>
<p><a href="/product?view=list">Отобразить списком</a></p>
<br />
<table border="1px">
    <c:forEach var="product" items="${productList}">
        <tr>
            <td width="80%" valign="top">
                <a href="product/${post.id}" >${product.name}</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/product/new">Добавить продукт</a>
</body>
</html>