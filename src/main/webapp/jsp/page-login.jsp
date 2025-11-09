<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Логин</title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
    </head>
    <body>
        <form method="post" action="${pageContext.request.contextPath}/login">
            <p>
                <input type="text" name="login" id="login" placeholder="Введи логин, блин">
            </p>
            <p>
                <input type="password" name="password" id="password" placeholder="Вводи пароль сюда">
            </p>
            <p>
                <input type="submit" placeholder="Оп, газуем">
            </p>
        </form>
    </body>
</html>