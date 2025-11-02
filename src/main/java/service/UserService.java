package service;

import entity.User;

import java.sql.SQLException;

public interface UserService {
    User authenticateUser(String username, String pass) throws SQLException;

    boolean isUserExist(String login) throws SQLException;

    boolean saveNewUser(String username, String password) throws SQLException;

}
