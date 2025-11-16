package service;

import dao.CharakterDAO;
import dao.UserDAO;
import entity.Charakter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CharService {
    private UserDAO userDAO;
    private CharakterDAO charDAO;

    public CharakterDAO createCharDAO() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/characters",
                    "postgres",
                    "010909"
            );
            return new CharakterDAO(connection);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CharService() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/characters",
                    "postgres",
                    "010909"
            );
            this.charDAO = new CharakterDAO(connection);
            this.userDAO = new UserDAO(connection);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public long addCharToUser(Charakter charakter, String username) throws SQLException {
        return charDAO.createCharacterAndAssignToUser(charakter, username, userDAO);
    }

    public long getID(String name, String username) {
        return charDAO.getCharIdByNames(name, username);
    }
}
