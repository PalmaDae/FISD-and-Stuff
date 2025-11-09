<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>


<html>

    <head>
        <title>Справочник</title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
    </head>


    <body class = "radiant" id = "change_theme">

    <jsp:include page="/jsp/header.jsp" />

    <div id="main">
        <div id="sidebar">
            <header>
                Расы
            </header>
            <a onclick="showInfo('Дварф')">Дварф</a>
            <a onclick="showInfo('Эльф')">Эльф</a>
            <a onclick="showInfo('Орк')">Орк</a>
            <a onclick="showInfo('Человек')">Человек</a>
            <header>
                Классы
            </header>
            <a onclick="showInfo('Плут')">Плут</a>
            <a onclick="showInfo('Бард')">Бард</a>
            <a onclick="showInfo('Воин')">Воин</a>
            <a onclick="showInfo('Колдун')">Колдун</a>
            <header>
                Чудовища
            </header>
            <a onclick="showInfo('Тараска')">Тараска</a>
            <a onclick="showInfo('Вурдалак')">Вурдалак</a>
            <a onclick="showInfo('Лич')">Лич</a>
            <a onclick="showInfo('Гончая')">Гончая</a>
        </div>

        <div id="content">
            <h1 id="info-title">
                Выберите элемент
            </h1>

            <div id="info-box">
                Информация будет здесь
            </div>
        </div>
    </div>

    </body>

</html>