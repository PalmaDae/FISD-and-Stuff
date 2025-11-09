package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserServiceImpl;

import java.io.*;

@WebServlet("/guide")
public class GuideServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String username = UserServiceImpl.checkUser(req);

        req.setAttribute("username",username);

        req.getRequestDispatcher("/jsp/page-guide.jsp").forward(req, resp);
    }
}
