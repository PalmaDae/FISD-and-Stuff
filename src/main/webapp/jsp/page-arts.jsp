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

  <div class="gallery">
    <div class="gallery-item"><img src="${pageContext.request.contextPath}/images/arts/art1.jpg" alt="art1"></div>
    <div class="gallery-item"><img src="${pageContext.request.contextPath}/images/arts/art2.jpg" alt="art2"></div>
    <div class="gallery-item"><img src="${pageContext.request.contextPath}/images/arts/art3.jpg" alt="art3"></div>
    <div class="gallery-item"><img src="${pageContext.request.contextPath}/images/arts/art4.jpg" alt="art4"></div>
    <div class="gallery-item"><img src="${pageContext.request.contextPath}/images/arts/art5.jpg" alt="art5"></div>
    <div class="gallery-item"><img src="${pageContext.request.contextPath}/images/arts/art6.jpg" alt="art6"></div>
    <div class="gallery-item"><img src="${pageContext.request.contextPath}/images/arts/art7.jpg" alt="art7"></div>
    <div class="gallery-item"><img src="${pageContext.request.contextPath}/images/arts/art8.jpg" alt="art8"></div>
    <div class="gallery-item"><img src="${pageContext.request.contextPath}/images/arts/art9.jpg" alt="art9"></div>
    <div class="gallery-item"><img src="${pageContext.request.contextPath}/images/arts/art10.jpg" alt="art10"></div>
    <div class="gallery-item"><img src="${pageContext.request.contextPath}/images/arts/art11.jpg" alt="art11"></div>
    <div class="gallery-item"><img src="${pageContext.request.contextPath}/images/arts/art12.jpg" alt="art12"></div>
    <div class="gallery-item"><img src="${pageContext.request.contextPath}/images/arts/art13.jpg" alt="art13"></div>
    <div class="gallery-item"><img src="${pageContext.request.contextPath}/images/arts/art14.jpg" alt="art14"></div>
    <div class="gallery-item"><img src="${pageContext.request.contextPath}/images/arts/art15.jpg" alt="art15"></div>
    <div class="gallery-item"><img src="${pageContext.request.contextPath}/images/arts/art16.jpg" alt="art16"></div>
    <div class="gallery-item"><img src="${pageContext.request.contextPath}/images/arts/art17.jpg" alt="art17"></div>
    <div class="gallery-item"><img src="${pageContext.request.contextPath}/images/arts/art18.jpg" alt="art18"></div>
    <div class="gallery-item"><img src="${pageContext.request.contextPath}/images/arts/art19.jpg" alt="art19"></div>
    <div class="gallery-item"><img src="${pageContext.request.contextPath}/images/arts/art20.jpg" alt="art20"></div>
  </div>



  </body>

  <jsp:include page="/jsp/footer.jsp" />

</html>