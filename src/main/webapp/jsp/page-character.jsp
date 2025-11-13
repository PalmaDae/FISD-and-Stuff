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
        <form>
            <div class="short_info">
                <label for="name">Имя персонажа</label>
                <input type="text" id="name" name="name" required>
                <label for="player_name">Имя игрока</label>
                <input type="text" id="player_name" name="player_name" required>
            </div>

            <div class="clasz">

            </div>

            <div class="race">
            </div>
        </form>

        <button type="submit" class="character_btn">Создать персонажа</button>

    </div>

</body>
<jsp:include page="/jsp/footer.jsp" />
</html>