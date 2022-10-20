<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL</h1><hr>
<h3>Детальна інформація про продавця</h3>
<b>email: </b>${user.email}<br>
<h4>Товари користувача ${user.name}</h4>
<#list products as product>
    <div>
        <p><b>${product.title} </b>${product.price} ua | <a href="/product/${product.id}"> Детальніше...</a></p>
    </div>
    <#else >
    <h3>товарів немає</h3>
</#list>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
</body>
</html>