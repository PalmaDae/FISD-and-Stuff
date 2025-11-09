<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>

<html>

  <head>
    <title>Галерея</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
  </head>

  <body class = "radiant" id = "change_theme">

  <jsp:include page="/jsp/header.jsp" />

    <h1 id = "center_h1">Вы попали на сайт:Крутые пивные картиночки</h1>


    <div class ="background">

    </div>

    <h2 id = "center_h1">
    А теперь вот картиночки с пивом
    </h2>


    <div id = "carousel">

    <div id = "carousel_second">
      <button id = "prev"><-</button>
      <img id = "carouselImage" src = "" width="400" height="400"><br>
      <span id = "carouselCaption"></span>
      <button id = "next">
      ->
      </button>
    </div>

  </div>


  </body>


</html>