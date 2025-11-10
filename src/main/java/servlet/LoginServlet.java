package servlet;

import dao.UserDAO;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserDAO userDao;
    private UserServiceImpl userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.getRequestDispatcher("/jsp/page-login.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, RuntimeException {
        resp.setContentType("text/html;charset=UTF-8");

        String login = req.getParameter("login");
        String pass = req.getParameter("password");

        String errorMsg = "";

        if (login == null || login.trim().isEmpty()) {
            errorMsg += "Логин не может быть пустым ";
        }
        if (pass == null || pass.trim().isEmpty()) {
            errorMsg += "Пароль не может быть пустым ";
        }

        if (!errorMsg.isEmpty()) {
            resp.getWriter().write(errorMsg);
            return;
        }


        try {
            User user = userService.authenticateUser(login, pass);

            if (user == null) {
                resp.sendRedirect("/main");
            }
            else {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                resp.sendRedirect(req.getContextPath() + "/main");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void init() throws ServletException {
        this.userService = new UserServiceImpl();
    }
}
