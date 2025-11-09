<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>

<html>

<head>
    <title>Регистрация</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
</head>

    <body>

        <form method="post" action="${pageContext.request.contextPath}/registration" accept-charset="UTF-8">

            <input id = "login" name="login" type="text" placeholder="Введи логин, блин"> <br>
            <input id = "password" name="password" type="password" placeholder="Введи пароль, блин"><br>

            <input type="submit">

        </form>

        <form action="/login" method="get">

            <button type ="submit"?>
                У меня уже есть аккаунт
            </button>

        </form>

    </body>

</html>