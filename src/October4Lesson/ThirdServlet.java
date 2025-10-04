package October4Lesson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("page-third.html");

        BufferedReader reader = new BufferedReader((new InputStreamReader(inputStream)));

        PrintWriter out = resp.getWriter();

        String line;

        while ((line = reader.readLine()) != null) {
            out.println(line);
        }
    }
}
