<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <title>Пиво - жизнь</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
</head>

<body class="radiant" id="change_theme">

<jsp:include page="/jsp/header.jsp" />

<div class="info">
    <h1 id="center_h1">Билеты на пивные фестивали</h1>
    <h2>Выберите событие и добавьте билет в корзину</h2>
</div>

<table border="1" cellspacing="0" cellpadding="10">
    <tr>
        <th>Фестиваль</th>
        <th>Постер</th>
        <th>Описание</th>
        <th>Цена</th>
        <th>Добавить</th>
    </tr>

    <tr>
        <td>Oktoberfest Munich</td>
        <td>
            <img src="" width="150" height="100" alt="Oktoberfest">
        </td>
        <td>Самый знаменитый фестиваль пива в Германии.</td>
        <td>₽4500</td>
        <td>
            <form action="/tickets" method="post">
                <input type="hidden" name="ticketId" value="1">
                <button type="submit">В корзину</button>
            </form>
        </td>
    </tr>

    <tr>
        <td>Belgian Beer Weekend</td>
        <td>
            <img src="" width="150" height="100" alt="Belgian Beer Weekend">
        </td>
        <td>Праздник пива в Брюсселе с участием более 50 пивоварен.</td>
        <td>₽3900</td>
        <td>
            <form action="/tickets" method="post">
                <input type="hidden" name="ticketId" value="2">
                <button type="submit">В корзину</button>
            </form>
        </td>
    </tr>

    <tr>
        <td>Craft Beer Helsinki</td>
        <td>
            <img src="" width="150" height="100" alt="Craft Beer Helsinki">
        </td>
        <td>Скандинавский фестиваль крафтового пива под открытым небом.</td>
        <td>₽3100</td>
        <td>
            <form action="/tickets" method="post">
                <input type="hidden" name="ticketId" value="3">
                <button type="submit">В корзину</button>
            </form>
        </td>
    </tr>
</table>

<div class="sources">
    <p>18+ Продажа алкоголя лицам младше 18 лет запрещена.</p>
</div>

</body>
</html>