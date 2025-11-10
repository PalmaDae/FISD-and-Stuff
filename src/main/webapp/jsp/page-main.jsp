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
<%--            <h2 id="dnd_fact"></h2>--%>
        </div>

    <section class="random_fact">
        <h3>
            Случайный DnD факт!
        </h3>
        <h4 id="dnd_fact"></h4>
    </section>

    <section class="campaigns">
        <h3>Популярные компании</h3>
        <div class="cards">
            <div class="card">
                <h4>

                </h4>

                <p>

                </p>
            </div>
            <div class="card">
                <h4>

                </h4>

                <p>

                </p>
            </div>
            <div class="card">
                <h4>

                </h4>

                <p>

                </p>
            </div>

        </div>
    </section>

        <jsp:include page="/jsp/footer.jsp" />

    </body>
</html>
