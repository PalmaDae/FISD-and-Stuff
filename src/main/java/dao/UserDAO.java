package dao;

import entity.Role;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public User getUserByLogin(String username) throws SQLException {
        String sql = "select * from users where username = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    Array sqlArray = rs.getArray("character_ids");
                    List<Long> chacharacterIds = new ArrayList<>();

                    if (sqlArray != null) {
                        Long[] ids =  (Long[]) sqlArray.getArray();

                        for (Long id : ids) {
                            chacharacterIds.add(id);
                        }
                    }

                    return new User(
                            rs.getLong("id"),
                            rs.getString("username"),
                            rs.getString("hash_pass"),
                            Role.valueOf(rs.getString("role")),
                            chacharacterIds
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