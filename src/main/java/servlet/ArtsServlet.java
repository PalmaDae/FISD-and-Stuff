package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserServiceImpl;

import java.io.*;

@WebServlet("/arts")
public class ArtsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String login = UserServiceImpl.checkUser(req);

        req.setAttribute("login",login);

        req.getRequestDispatcher("/jsp/page-arts.jsp").forward(req, resp);
    }
}
