<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Создание персонажа</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
</head>

<body class="radiant" id="change_theme">
<jsp:include page="/jsp/header.jsp" />

    <div class="character_content">
        <form method="post" action="/character">
            <div class="short_info">
                <label for="name">Имя персонажа</label>
                <input type="text" id="name" name="name" required>
            </div>

            <div class="short_info">
                <label for="player_name">Имя игрока</label>
                <input type="text" id="player_name" name="player_name" required>
            </div>

            <div class="clasz">
                <label for="clasz">Класс</label>
                <select id="clasz" name="clasz">
                    <option>Воин</option>
                    <option>Плут</option>
                    <option>Жрец</option>
                    <option>Колдун</option>
                    <option>Волшебник</option>
                    <option>Колдун</option>
                    <option>Монах</option>
                    <option>Бард</option>
                    <option>Следопыт</option>
                    <option>Варвар</option>
                    <option>Друид</option>
                    <option>Паладин</option>
                    <option>Чародей</option>
                </select>
            </div>

            <div class="race">
                <label for="race">Раса</label>
                <select id="race" name="race">
                    <option>Человек</option>
                    <option>Дварф</option>
                    <option>Гном</option>
                    <option>Полу-Эльф</option>
                    <option>Гит</option>
                    <option>Гном</option>
                    <option>Тифлинг</option>
                    <option>Дроу</option>
                    <option>Грунг</option>
                    <option>Нага</option>
                    <option>Дроу</option>
                    <option>Кенку</option>
                    <option>Драконорождённый</option>
                    <option>Эльф</option>
                </select>
            </div>

            <div class="stats">
                <h3>Характеристики</h3>
                <div class="stat-group">
                    <label>Сила <input type="number" name="strength" min="1" max="20" value="10"></label>
                    <label>Ловкость <input type="number" name="dexterity" min="1" max="20" value="10"></label>
                    <label>Телосложение <input type="number" name="constitution" min="1" max="20" value="10"></label>
                    <label>Интеллект <input type="number" name="intelligence" min="1" max="20" value="10"></label>
                    <label>Мудрость <input type="number" name="wisdom" min="1" max="20" value="10"></label>
                    <label>Харизма <input type="number" name="charisma" min="1" max="20" value="10"></label>
                </div>
            </div>

            <div class="combat_stats">
                <h3>Боевая информация</h3>
                <label>Класс доспеха<input type="number" name="armorClass" min="0" value="10"></label>
                <label>Инициатива<input type="number" name="initiative" min="0" value="10"></label>
                <label>Скорость<input type="number" name="speed" min="0" value="30"></label>
                <label>Текущее здоровье<input type="number" name="hitPoints" min="0" value="10"></label>
                <label>Временное здоровье<input type="number" name="!important;" min="0" value="0"></label>
                <label>Кубик атаки<input type="number" name="hitDice" min="0" value="1"></label>
            </div>

            <div class="resources">
                <h3>Ресурсы</h3>
                <div class="money">
                    <label>Золото <input type="number" name="gold" min="0" value="0"></label>
                    <label>Серебро <input type="number" name="silver" min="0" value="0"></label>
                    <label>Медь <input type="number" name="copper" min="0" value="0"></label>
                </div>
            </div>
        </form>

        <button type="submit" class="character_btn">Создать персонажа</button>

    </div>

</body>
<jsp:include page="/jsp/footer.jsp" />
</html>