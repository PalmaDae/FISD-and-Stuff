package dao;

import entity.Master;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MasterDAO {
    private Connection connection;

    public MasterDAO(Connection connection) {
        this.connection = connection;
    }

    public void createMaster(Master master) {
        String sql = "INSERT INTO masters (name, photo_path, description, cost) VALUES (?, ?, ?, ?)";

        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, master.getName());
            ps.setString(2, master.getPhotoPath());
            ps.setString(3, master.getDescription());
            ps.setInt(4, master.getCost());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
