<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
        <h2>JSP + JSTL 2.0 работает!</h2>
        <p>Текущее время: <%= new java.util.Date() %></p>

        <c:set var="name" value="Jetty"/>
        <c:out value="Привет, ${name}!"/>
    </body>
</html>