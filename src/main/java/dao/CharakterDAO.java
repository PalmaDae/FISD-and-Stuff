package dao;

import entity.Charakter;
import entity.Clasz;
import entity.Race;
import entity.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CharakterDAO {
    private Connection connection;

    public CharakterDAO(Connection connection) {
        this.connection = connection;
    }

    public long createCharacterAndAssignToUser(Charakter charakter, String username, UserDAO userDAO) throws SQLException {
        String sql = "INSERT INTO characters (" +
                "name, player_name, race, clasz, level, " +
                "strength, intelligence, wisdom, charisma, dexterity, constitution, " +
                "speed, armor_class, initiative, hit_points, temporary_hit_points, hit_dice, " +
                "gold, silver, copper" +
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id";

        long characterId;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
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

            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                characterId = rs.getLong("id");
            }
        }

        userDAO.addCharacterToUser(username, characterId);

        return characterId;
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

    public List<Charakter> getAllCharacters() throws SQLException {
        List<Charakter> characters = new ArrayList<>();
        String sql = "select * from characters";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Charakter c = Charakter.builder()
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
                        .armorClass(rs.getInt("armor_class"))
                        .initiative(rs.getInt("initiative"))
                        .speed(rs.getInt("speed"))
                        .hitPoints(rs.getInt("hit_points"))
                        .temporaryHitPoints(rs.getInt("temporary_hit_points"))
                        .hitDice(rs.getInt("hit_dice"))
                        .gold(rs.getInt("gold"))
                        .silver(rs.getInt("silver"))
                        .copper(rs.getInt("copper"))
                        .build();
                characters.add(c);
            }
        }
        return characters;
    }

    public void updateCharacter(Charakter charakter) throws SQLException {
        String sql = "UPDATE characters SET " +
                "name=?, player_name=?, race=?, clasz=?, level=?, strength=?, intelligence=?, wisdom=?, charisma=?, " +
                "dexterity=?, constitution=?, speed=?, armor_class=?, initiative=?, hit_points=?, temporary_hit_points=?, hit_dice=?, " +
                "gold=?, silver=?, copper=? " +
                "WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
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
            ps.setLong(21, charakter.getId());
            ps.executeUpdate();
        }
    }

    public void deleteCharacter(long id) {
        String sql = "DELETE FROM characters WHERE id = ?";

        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

