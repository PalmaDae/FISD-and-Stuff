package service;

import dao.UserDAO;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import util.HashUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserDAO userDao;

    public UserServiceImpl() {
        this.userDao = createUserDAO();
    }

    public User getUserByLogin(String username) throws ServletException, IOException, SQLException {
        return userDao.getUserByLogin(username);
    }

    public static String checkUser(HttpServletRequest req) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("user".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

    public UserDAO createUserDAO() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/characters",
                    "postgres",
                    "010909"
            );
            return new UserDAO(connection);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User authenticateUser(String username, String pass) throws SQLException {
        User user = userDao.getUserByLogin(username);

        if (HashUtil.verify(pass, user.getHashPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public boolean isUserExist(String login) throws SQLException {
        return userDao.isUserExist(login);
    }

    @Override
    public boolean saveNewUser(String username, String password) throws SQLException {
        userDao.createUser(username, password);
        return true;
    }
}