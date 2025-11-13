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
            <a onclick="showInfo('Тифлинг')">Тифлинг</a>
            <a onclick="showInfo('Кенку')">Кенку</a>
            <a onclick="showInfo('Гитьянка')">Гитьянка</a>
            <a onclick="showInfo('Гном')">Гном</a>
            <a onclick="showInfo('Полу-Эльф')">Полу-Эльф</a>
            <a onclick="showInfo('Дроу')">Дроу</a>
            <a onclick="showInfo('Драконорождённый')">Драконорождённый</a>
            <a onclick="showInfo('Грунг')">Грунг</a>
            <a onclick="showInfo('Нага')">Нага</a>
            <a onclick="showInfo('')"></a>
            <header>
                Классы
            </header>
            <a onclick="showInfo('Плут')">Плут</a>
            <a onclick="showInfo('Бард')">Бард</a>
            <a onclick="showInfo('Воин')">Воин</a>
            <a onclick="showInfo('Колдун')">Колдун</a>
            <a onclick="showInfo('Варвар')">Варвар</a>
            <a onclick="showInfo('Волшебник')">Волшебник</a>
            <a onclick="showInfo('Друид')">Друид</a>
            <a onclick="showInfo('Жрец')">Жрец</a>
            <a onclick="showInfo('Монах')">Монах</a>
            <a onclick="showInfo('Паладин')">Паладин</a>
            <a onclick="showInfo('Следопыт')">Следопыт</a>
            <a onclick="showInfo('Чародей')">Чародей</a>
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

    <jsp:include page="/jsp/footer.jsp" />

</html>