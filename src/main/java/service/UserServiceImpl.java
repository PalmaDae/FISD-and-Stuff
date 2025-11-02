package service;

import dao.UserDao;
import entity.User;
import util.HashUtil;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
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