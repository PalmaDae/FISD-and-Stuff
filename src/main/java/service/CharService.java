package service;

import dao.CharakterDAO;
import dao.UserDAO;
import entity.Charakter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CharService {
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
        this.charDAO = createCharDAO();
    }

    public void addCharToDB(Charakter charakter) throws SQLException {
        charDAO.createCharacter(charakter);
    }

    public long getID(String name, String username) {
        return charDAO.getCharIdByNames(name, username);
    }
}
