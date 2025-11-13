package dao;

import entity.Charakter;
import entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CharakterDAO {
    private Connection connection;

    public CharakterDAO(Connection connection) {
        this.connection = connection;
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
            ps.setString(4, charakter.getClasz().name());
            ps.setInt(5, charakter.getLevel());
            ps.setInt(6, charakter.getStrength());
            ps.setInt(7, charakter.getIntelligence());
            ps.setInt(8, charakter.getWisdom());
            ps.setInt(9, charakter.getCharisma());
            ps.setInt(10, charakter.getDexterity());
            ps.setInt(11, charakter.getConstitution());
            ps.setInt(12, charakter.getSpeed());
            ps.setInt(13, charakter.getArmorClass());
            ps.setInt(14, charakter.getInitiative());
            ps.setInt(15, charakter.getHitPoints());
            ps.setInt(16, charakter.getTemporaryHitPoints());
            ps.setInt(17, charakter.getHitDice());
            ps.setInt(18, charakter.getGold());
            ps.setInt(19, charakter.getSilver());
            ps.setInt(20, charakter.getCopper());
            ps.executeUpdate();

        }
    }

    public long getCharIdByNames(String name, String player) {
        String sql = "SELECT id FROM characters WHERE name = ? AND player_name = ? LIMIT 1";

        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, player);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getLong("id");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return -1;
    }
}

