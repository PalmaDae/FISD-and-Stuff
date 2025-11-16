<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>

  <head>
    <title>Галерея</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
  </head>

  <body class = "radiant" id = "change_theme">

  <jsp:include page="/jsp/header.jsp" />

  <div class="gallery">
    <c:forEach var="img" items="${images}">
      <div class="gallery-item">
        <img src="${pageContext.request.contextPath}/images/arts/${img}" alt="${img}">
      </div>
    </c:forEach>
  </div>



  </body>

  <jsp:include page="/jsp/footer.jsp" />

</html>