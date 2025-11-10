package dao;

import entity.Charakter;
import entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CharakterDAO {
    private Connection connection;

    public CharakterDAO(Connection connection) {
        this.connection = connection;
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

    public void createCharacter(Charakter charakter) throws SQLException {
        String sql = "insert into characters (" +
                "name, player_name, race, clasz, level, " +
                "strength, intelligence, wisdom, charisma, dexterity, constitution, " +
                "speed, armor_class, initiative, hit_points, temporary_hit_points, hit_dice, " +
                "gold, silver, copper" +
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, charakter.getName());
            ps.setString(2, charakter.getPlayerName());
            ps.setString(3, charakter.getRace().name());
        }
    }
}

