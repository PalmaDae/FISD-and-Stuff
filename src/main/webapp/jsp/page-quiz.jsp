<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>

<html>

<head>
    <title>Викторина</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
</head>



<body class = "radiant" id = "change_theme">
<jsp:include page="/jsp/header.jsp" />

<h1 id = "center_h1">Пройди тест на знание пива!</h1>

<form>

    <p>Какое пиво является самым лучшим?</p>
    <label><input type = "radio" name="q1">Волковская APA</label>
    <label><input type = "radio" name="q1">Волковская IPA</label>
    <label><input type = "radio" name="q1">Балтика 3</label>

    <p>Самый лучшее место чтобы выпить пиво в Казани?</p>
    <label><input type = "radio" name = "q2">Контакт-бар</label>
    <label><input type = "radio" name = "q2">Кабинет Абрамского</label>
    <label><input type = "radio" name = "q2">ДК</label>

    <p>Почему стоит любить пиво?</p>
    <label><input type = "radio" name = "q3">Оно вкусное</label>
    <label><input type = "radio" name = "q3">Оно холодное</label>
    <label><input type = "radio" name = "q3">Оно красивое</label>

    <button type = "submit">Отправить ответы</button>

</form>


<h2>Обратная связь</h2>

<form id = "feedbackForm" onsubmit="feedBack(event)">

    <label for = "email">Ваша почта:</label><br>
    <input type="email" id = "email" name="email" placeholder="example@mail.ru" required><br><br>

    <label for = "message">Ваше сообщение будет здесь:</label><br>
    <textarea type="message" id = "message" name="message" placeholder="Что же вы нам расскажите" rows = "3" required> </textarea>  <br><br>

    <button type="submit">Отправить</button>

</form>

<div id = "feedback"></div>

</body>
</html>