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
        <form method="post" action="${pageContext.request.contextPath}/character">
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
                    <option value="WARRIOR">Воин</option>
                    <option value="ROGUE">Плут</option>
                    <option value="CLERIC">Жрец</option>
                    <option value="WARLOCK">Колдун</option>
                    <option value="WIZARD">Волшебник</option>
                    <option value="MONK">Монах</option>
                    <option value="BARD">Бард</option>
                    <option value="RANGER">Следопыт</option>
                    <option value="BARBARIAN">Варвар</option>
                    <option value="DRUID">Друид</option>
                    <option value="PALADIN">Паладин</option>
                    <option value="SORCERER">Чародей</option>
                </select>
            </div>

            <div class="race">
                <label for="race">Раса</label>
                <select id="race" name="race">
                    <option value="HUMAN">Человек</option>
                    <option value="DWARF">Дварф</option>
                    <option value="GNOM">Гном</option>
                    <option value="HALF_ELF">Полу-Эльф</option>
                    <option value="GITH">Гит</option>
                    <option value="TIEFLING">Тифлинг</option>
                    <option value="DROW">Дроу</option>
                    <option value="GRUNG">Грунг</option>
                    <option value="NAGA">Нага</option>
                    <option value="KENKU">Кенку</option>
                    <option value="DRAGONBORN">Драконорождённый</option>
                    <option value="ELF">Эльф</option>
                </select>
            </div>


            <div class="stats">
                <h3>Характеристики</h3>
                <div class="stat-group">
                    <label id="level-label">Уровень<input type="number" id="level" name="level" min="1" value="1" required></label>
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
                <label>Временное здоровье<input type="number" name="temporaryHitPoints" min="0" value="0"></label>
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

            <button type="submit" class="character_btn">Создать персонажа</button>
        </form>

    </div>

</body>
<jsp:include page="/jsp/footer.jsp" />
</html>