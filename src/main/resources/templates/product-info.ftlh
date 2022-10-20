<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>HELLO BUYSELL!</h1><hr>
<h4>Детальна інформація про товар</h4>
<#list images as img>
    <img src="/images/${img.id}" height="60px"/><br><br>>
</#list>
<b>Назва товару: </b>${product.title}<br>
<b>Опис товару: </b>${product.description}<br>
<b>Ціна: </b>${product.price}<br>
<b>Місто: </b>${product.city}<br>
<b>Автор: </b><a href="/user/${product.user.id}">${product.user.name}</a><br>

<hr>
<h3>Створити новий товар</h3>
<form action="/product/delete/${product.id}" method="post">
Назва оголошення: <input type="text" name="title"/><br><br>
Опис оголошення: <input type="text" name="description"/><br><br>
Ціна: <input type="number" name="price"/><br><br>
Місто: <input type="text" name="city"/><br><br>
Ім'я: <input type="text" name="author"/><br><br>

    <input type="submit" value="додати товар"/>
</form>
</body>
</html>