package ThirdHomeWork;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("someone.html");

        BufferedReader reader = new BufferedReader((new InputStreamReader(inputStream)));

        PrintWriter out = response.getWriter();

        String line;

        while ((line = reader.readLine()) != null) {
            out.println(line);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String message = request.getParameter("message");
        String password = request.getParameter("password");

        String error = "";

        if (email.isEmpty() || !email.contains("@")) {
            error += "Некорректный email<br>";
        }
        if (message.isEmpty()) {
            error += "Пустое сообщение<br>";
        }

        if (password.isEmpty()) {
            error += "Пустой пароль<br>";
        }

        if (!error.isEmpty()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>SomeTitle</title></head>");
            out.println("<body>");
            out.println("<h1>Это какой-то сервет</h1>");

            out.println("<h3 style = 'color:red;'>" + error + "</h3>");

            out.println("</body></html>");

            out.println("<form method='post' action='/first'>");
            out.println("Логин: <input name='email' type='text' value='" + (email != null ? email : "") + "'><br>");
            out.println("Пароль: <input name='password' type='password'><br>");
            out.println("Сообщение: <input name='message' type='text' value='" + (message != null ? message : "") + "'><br>");
            out.println("<input type='submit'>");
            out.println("</form>");
        }

        PrintWriter pw = new PrintWriter("responds.txt");
        pw.println(email);
        pw.println(password);
        pw.println(message);
        pw.println("-----");
        pw.close();


        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("thnx.html");

        BufferedReader reader = new BufferedReader((new InputStreamReader(inputStream)));

        String line;

        while ((line = reader.readLine()) != null) {
            out.println(line);
        }

    }
}
