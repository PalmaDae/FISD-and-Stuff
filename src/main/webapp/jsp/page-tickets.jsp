<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="ru">

    <head>
        <title>Мастера</title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
    </head>

    <body class="radiant" id="change_theme">

    <jsp:include page="/jsp/header.jsp" />

    <div class="info">
        <h1 id="center_h1">Аренда мастера на партию</h1>
    </div>

    <table border="1" cellspacing="0" cellpadding="10">
        <tr>
            <th>Мастер</th>
            <th>Фото</th>
            <th>Описание</th>
            <th>Цена</th>
            <th>Добавить</th>
        </tr>


        <c:forEach var="ticket" items="${list}">

            <tr>
                <td>
                    ${ticket.name}
                </td>

                <td>
                    0_0
                </td>
                <td>
                    ${ticket.description}
                </td>
                <td>
                    ₽${ticket.price}
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/tickets" method="post">
                        <input type="hidden" name="ticketId" value="${ticket.id}">
                        <button type="submit">В корзину</button>
                    </form>
                </td>
            </tr>

        </c:forEach>

    </table>
    </body>

    <jsp:include page="/jsp/footer.jsp" />
</html>