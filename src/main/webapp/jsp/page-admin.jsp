<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Админ - панель</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
</head>
<body>

<h1>Админ-панель</h1>

<form action="/admin" method="post">
    <input type="hidden" name="ticketId" value="${ticketId}">
    <input type="hidden" name="action" value="${actionType}">

    <label>Название фестиваля:</label><br>
    <input type="text" name="name" value="ticketName" required><br>

    <label>Описание:</label><br>
    <textarea name="description" required>${ticketDescription}</textarea><br>

    <label>Цена:</label><br>
    <input type="number" name="price" value="ticketPrice" required><br>

    <button type="submit">Отправить</button>
</form>

<hr>

<h2>Существующие билеты</h2>
<table border="1" cellspacing="0" cellpadding="10">
    <tr>
        <th>Название</th>
        <th>Описание</th>
        <th>Цена</th>
        <th>Действие</th>
    </tr>
    <tr>
        <td>Oktoberfest Munich</td>
        <td>Самый знаменитый фестиваль пива в Германии.</td>
        <td>4500</td>
        <td>
            <form action="/admin" method="post" style="display:inline">
                <input type="hidden" name="ticketId" value="1">
                <input type="hidden" name="action" value="edit">
                <button type="submit">Редактировать</button>
            </form>
            <form action="/admin" method="post" style="display:inline">
                <input type="hidden" name="ticketId" value="1">
                <input type="hidden" name="action" value="delete">
                <button type="submit">Удалить</button>
            </form>
        </td>
    </tr>
</table>

<p><a href="/tickets">← Вернуться к билетам</a></p>

</body>
</html>