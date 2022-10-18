<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL | <a href="/login">Авторизуватися</a> </h1><hr>
<h4>Товари зі всієї України-неньки!</h4>
<form action="/" method="get">
    пошук по назві оголошення: <input type="text" name="title"><br>
    <input type="submit" value="пошук">
</form>
<#list products as product>
    <div>
        <p><b>${product.title} </b>${product.price} ua | <a href="/product/${product.id}"> Детальніше...</a></p>
    </div>
    <#else>
    <h3>Товарів не знайдено</h3>
</#list>
<hr>
<h3>Створити новий товар</h3>
<form action="/product/create" method="post" enctype="multipart/form-data">
    Назва оголошення: <input type="text" name="title"/><br><br>
    Опис оголошення: <input type="text" name="description"/><br><br>
    Ціна: <input type="number" name="price"/><br><br>
    Місто: <input type="text" name="city"/><br><br>
    Ім'я: <input type="text" name="author"/><br><br>
    Перше фото: <input type="file" name="file1"/><br><br>
    Друге фото: <input type="file" name="file2"/><br><br>
    Третє фото: <input type="file" name="file3"/><br><br>

    <input type="submit" value="додати товар"/>
</form>
</body>
</html>