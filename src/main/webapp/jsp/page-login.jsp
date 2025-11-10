<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Логин</title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
    </head>
    <body class="login-body">
    <div class="login-div">
        <h1 class="login-h1">Dungeons and Gags</h1>
        <h2>Впишите ваши данные для входа</h2>

        <form method="post" action="${pageContext.request.contextPath}/login">
            <label class="login-label" for="first">
                Login:
            </label>
            <input type="text" id="login" name="login"
                   placeholder="Введите ваш login" required class="login-input">
            <label class="login-label" for="password">
                Password:
            </label>
            <input type="password" id="password" name="password"
                   placeholder="Введите ваш пароль" required class="login-input">
            <div class="wrap">
                <button type="submit" class="login-button">
                    Войти в аккаунт
                </button>
            </div>
        </form>
        <p>Не зарегистрированы?
            <a href="${pageContext.request.contextPath}/registration" style="text-decoration: none;">
                Создать Аккаунт
            </a>
        </p>
    </div>
    </body>
</html>