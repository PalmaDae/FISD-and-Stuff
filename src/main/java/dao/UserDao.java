package dao;

import entity.Role;
import entity.Ticket;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public User getUserById(long id) throws SQLException {
        String sql = "select * from users where id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getLong("id"),
                            rs.getString("username"),
                            rs.getString("hash_pass"),
                            Role.valueOf(rs.getString("role"))
                    );
                }
            }
        }
        return null;
    }

    public void createUser(String username, String pass) throws SQLException {
        String sql = "insert into users (username, hash_pass, role) values (?, ?, ?)";
        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, pass);
            ps.setString(3, Role.USER.name());
            ps.executeUpdate();
        }
    }

    public boolean isUserExist(String login) throws SQLException {
        String sql = "select 1 from users where username = ?";

        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, login);
            try(ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
}