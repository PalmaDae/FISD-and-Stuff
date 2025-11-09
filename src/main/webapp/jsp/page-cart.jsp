<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
    <head>
        <title>Корзина</title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
    </head>

    <body class="radiant" id="change_theme">

        <jsp:include page="/jsp/header.jsp" />

        <div class="info">
            <h1 id="center_h1">Ваша корзина</h1>
            <h2>Список выбранных билетов</h2>
        </div>

        <div id="cartContent">

        </div>

        <form action="/cart" method="post">
            <button type="submit">Оформить заказ</button>
        </form>

        <p><a href="/tickets">← Вернуться к билетам</a></p>

        <div class="sources">
            <p>Спасибо, что выбираете пивные фестивали с нами!</p>
        </div>

    </body>
</html>