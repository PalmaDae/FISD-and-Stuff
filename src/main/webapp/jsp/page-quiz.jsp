<%@ page contentType="text/html; charset=UTF-8" %>
<html>

    <head>
        <title>Викторина</title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/js/scripts.js" defer></script>
    </head>



    <body class = "radiant" id = "change_theme">
    <jsp:include page="/jsp/header.jsp" />

    <div class="quiz_wrapper">
        <div class="quiz_container">
            <div class="quiz" id="quiz">
                <div class="question" id="question"></div>
                <div class="options" id="options"></div>
                <button class="btn" id="nextBtn">Следующий вопрос</button>
            </div>
            <div class="result"></div>
        </div>
    </div>

    </body>

    <jsp:include page="/jsp/footer.jsp" />
</html>