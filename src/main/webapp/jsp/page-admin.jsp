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
        <label>Имя пользователя:</label>
        <input type="text" name="username" placeholder="Введите имя пользователя" required><br><br>

        <label>Новая роль:</label>
        <input type="text" name="role" placeholder="USER, ADMIN"><br><br>

        <button type="submit" name="action" value="updateRole">Обновить роль</button>
        <button type="submit" name="action" value="deleteUser">Удалить пользователя</button>
    </form>

    <form action="${pageContext.request.contextPath}/admin" method="post">
        <label></label>

    </form>

    </body>
</html>
