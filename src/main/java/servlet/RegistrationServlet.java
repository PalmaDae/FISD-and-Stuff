package servlet;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.TicketServiceImpl;
import service.UserServiceImpl;
import util.HashUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private UserServiceImpl userService;
    private UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.getRequestDispatcher("/jsp/page-registration.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        try {
            if (userService.isUserExist(login)) {
                errorMsg += "Юзер существует ";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (!errorMsg.isEmpty()) {
            resp.getWriter().write(errorMsg);
            return;
        }

        pass = HashUtil.hashPassword(pass);

        try {
            userService.saveNewUser(login,pass);
            resp.sendRedirect(req.getContextPath() + "/login");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void init() throws ServletException {
        this.userService = new UserServiceImpl(userDao);
    }
}
