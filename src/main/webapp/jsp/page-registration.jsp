<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>

<html>

<head>
    <title>Регистрация</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
</head>

    <body class="login-body">
    <div class="login-div">
        <h1 class="login-h1">Dungeons and Gags</h1>
        <h2>Форма регистрации</h2>

        <form method="post" action="${pageContext.request.contextPath}/registration">
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
                    Зарегистрироваться
                </button>
            </div>
        </form>
        <p>Уже зарегистрированы?
            <a href="${pageContext.request.contextPath}/login" style="text-decoration: none;">
                Войти в аккаунт
            </a>
        </p>
    </div>
    </body>

    <jsp:include page="/jsp/footer.jsp" />
</html>