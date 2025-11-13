<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Dungeons and Gags</title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
    </head>
    <body class="radiant" id="change_theme">

        <jsp:include page="/jsp/header.jsp" />

        <div class="info">
            <h1 id="center_h1">Dungeons and Gags</h1>
        </div>

    <section class="random_fact">
        <h3>
            Случайный DnD факт!
        </h3>
        <h4 id="dnd_fact"></h4>
    </section>

    <section class="campaigns">
        <h3 class="campaign_title">Популярные компании</h3>
        <div class="cards">
            <div class="card">
                <h4>
                    Побег из МехМатЛенда!
                </h4>

                <p>
                    Эксклюзивная компания для студентов ИТИС. Победите всех боссов МехМатЛенда и станьте полноправным героем ИТфорда!
                </p>
            </div>
            <div class="card">
                <h4>
                    Хроники Лордерона!
                </h4>

                <p>
                    Земли некогда великого королевства погрузились во тьму. Разрушенные города, брошенные поля и отголоски погибшей чести — всё, что осталось после падения Лордерона
                </p>
            </div>
            <div class="card">
                <h4>
                    Защита Северного Сердца
                </h4>

                <p>
                    Окунитесь в приключение полное мистики и интриг. Деревня Северное Сердце уже много лет вымирает и только от вас, герои, зависит, умрет она окончательно или сможет вернуться к прежней жизни.
                </p>
            </div>

        </div>
    </section>

        <jsp:include page="/jsp/footer.jsp" />
    </body>
</html>
