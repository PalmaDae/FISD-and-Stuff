<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://jakarta.ee/jstl/core" %>

<header>

    <nav class ="denu">
            <ul>
                <li><a href = "${pageContext.request.contextPath}/">Главная</a></li>
                <li class = "down">
                    <a href = "#" id = "menuButton">Разделы</a>
                    <ul class = "downContent" id = "menuList">
                        <li><a href="${pageContext.request.contextPath}/main">Про пивоварни</a></li>
                        <li><a href="${pageContext.request.contextPath}/history">История крафтового пива</a></li>
                        <li><a href="${pageContext.request.contextPath}/picture">Крутые картинки пива</a></li>
                        <li><a href="${pageContext.request.contextPath}/quiz">Пивная викторина</a></li>
                        <li><a href="${pageContext.request.contextPath}/tickets">Пивные фестивали</a></li>
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