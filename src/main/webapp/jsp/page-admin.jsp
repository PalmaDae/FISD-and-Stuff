<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Админ - редактор пользователей</title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    </head>
    <body>
    <h1>Редактор пользователей</h1>

    <form action="${pageContext.request.contextPath}/admin" method="post">
        <input type="hidden" name="form" value="user">

        <label>Имя пользователя:</label>
        <input type="text" name="username" placeholder="Введите имя пользователя" required><br><br>

        <label>Новая роль:</label>
        <input type="text" name="role" placeholder="USER, ADMIN"><br><br>

        <button type="submit" name="action" value="updateRole">Обновить роль</button>
        <button type="submit" name="action" value="deleteUser">Удалить пользователя</button>
    </form>

    <h1>Добавление мастера</h1>

    <form action="${pageContext.request.contextPath}/admin" method="post"   >
        <input type="hidden" name="form" value="master">

        <label>Имя мастера:</label>
        <input type="text" name="masterName" placeholder="Введите имя" required><br><br>

        <label>Описание:</label><br>
        <textarea name="description" rows="4" cols="40" placeholder="Описание мастера"></textarea><br><br>

        <label>Стоимость услуги:</label>
        <input type="number" name="cost" required><br><br>

        <label>Фото мастера:</label>
        <input type="text" name="photo" placeholder="example.jpg" required><br><br>

        <button type="submit" name="action" value="addMaster">Добавить мастера</button>
    </form>

    </body>
</html>
