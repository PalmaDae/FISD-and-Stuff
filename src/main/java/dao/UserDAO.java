package dao;

import entity.*;

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
                    User user = new User(
                            rs.getLong("id"),
                            rs.getString("username"),
                            rs.getString("hash_pass"),
                            Role.valueOf(rs.getString("role"))
                    );
                    user.setCharakters(getCharactersByUser(username));

                    return user;
                }
            }
        }
        return null;
    }

    public List<Charakter> getCharactersByUser(String username) throws SQLException {
        String sql = "select c.* from characters c " +
                "join user_characters uc on c.id = uc.character_id " +
                "join users u on u.id = uc.user_id " +
                "where u.username = ?";

        List<Charakter> characters = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    characters.add(Charakter.builder()
                            .id(rs.getLong("id"))
                            .name(rs.getString("name"))
                            .playerName(rs.getString("player_name"))
                            .race(Race.valueOf(rs.getString("race")))
                            .clasz(Clasz.valueOf(rs.getString("clasz")))
                            .level(rs.getInt("level"))
                            .strength(rs.getInt("strength"))
                            .dexterity(rs.getInt("dexterity"))
                            .constitution(rs.getInt("constitution"))
                            .intelligence(rs.getInt("intelligence"))
                            .wisdom(rs.getInt("wisdom"))
                            .charisma(rs.getInt("charisma"))
                            .speed(rs.getInt("speed"))
                            .armorClass(rs.getInt("armor_class"))
                            .initiative(rs.getInt("initiative"))
                            .hitPoints(rs.getInt("hit_points"))
                            .temporaryHitPoints(rs.getInt("temporary_hit_points"))
                            .hitDice(rs.getInt("hit_dice"))
                            .gold(rs.getInt("gold"))
                            .silver(rs.getInt("silver"))
                            .copper(rs.getInt("copper"))
                            .build());

                }
            }
        }
        return characters;
    }


    public void addCharacterToUser(String username, long characterId) throws SQLException {
        String sql = "insert into user_characters (user_id, character_id) " +
                "values ((select id from users where username = ?), ?) " +
                "on conflict do nothing";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setLong(2, characterId);
            ps.executeUpdate();
        }
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

    public void addCharToUser(String login, long charId) throws SQLException {
        String sql = "UPDATE users SET character_ids = COALESCE(character_ids, '{}') || ? WHERE username = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, charId);
            ps.setString(2, login);
            ps.executeUpdate();
        }
    }

    public void updateUserRole(String login, Role newRole)  throws SQLException {
        String sql = "UPDATE users SET role = ? WHERE username = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, newRole.name());
            ps.setString(2, login   );
            ps.executeUpdate();
        }
    }

    public void deleteUser(String login) throws SQLException {
        String sql = "DELETE FROM users WHERE username = ?";

        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, login);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}