package October4Lesson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.*;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("page-first.html");

        BufferedReader reader = new BufferedReader((new InputStreamReader(inputStream)));

        PrintWriter out = resp.getWriter();

        String line;

        while ((line = reader.readLine()) != null) {
            out.println(line);
        }



        HttpSession session = req.getSession();

        Integer visitCnt = (Integer) session.getAttribute("visitCount");

        if (visitCnt == null) {
            visitCnt = 1;
        }else {
            visitCnt++;
        }

        session.setAttribute("visitCount", visitCnt);
        out.println("<p>Количество запросов из этой сессии: " + session.getAttribute("visitCount") + "</p>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}
