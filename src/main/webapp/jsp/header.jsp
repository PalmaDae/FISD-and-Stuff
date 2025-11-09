<%@ page contentType="text/html; charset=UTF-8" %>

<header>

    <nav class ="denu">
            <ul>
                <li><a href = "${pageContext.request.contextPath}/main">Главная</a></li>
                <li class = "down">
                    <a href = "#" id = "menuButton">Разделы</a>
                    <ul class = "downContent" id = "menuList">
                        <li><a href="${pageContext.request.contextPath}/history">Справочник мира DnD</a></li>
                        <li><a href="${pageContext.request.contextPath}/picture">Галерея артов наших юзеров</a></li>
                        <li><a href="${pageContext.request.contextPath}/quiz">Насколько вы знаете BG3</a></li>
                        <li><a href="${pageContext.request.contextPath}/tickets">Аренда мастера</a></li>
                    </ul>
                </li>
                <li>
                    <button id = "changeButton" onclick="changeTheme()">Сменить тему</button>
                </li>
                <li>
                    <form action="${pageContext.request.contextPath}/logout" method="get" style="display:inline">
                        <button type="submit">Выйти</button>
                    </form>
                </li>
            </ul>
        </nav>

</header>