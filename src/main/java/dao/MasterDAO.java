package dao;

import entity.Master;
import entity.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Master> getAllMasters() throws SQLException {
        List<Master> masters = new ArrayList<>();
        String sql = "select * from masters order by id";

        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)
        ) {
            while (rs.next()) {
                masters.add(Master.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .photoPath(rs.getString("photo_path"))
                        .description(rs.getString("description"))
                        .cost(rs.getInt("cost"))
                        .build()
                );
            }
        }

        return masters;
    }
}
