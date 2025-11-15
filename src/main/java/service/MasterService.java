package service;

import dao.MasterDAO;
import dao.TicketDAO;
import entity.Master;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MasterService {
    private  MasterDAO masterDAO;

    public MasterService() {
        this.masterDAO = createMasterDAO();
    }

    public MasterDAO createMasterDAO() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/characters",
                    "postgres",
                    "010909"
            );
            return new MasterDAO(connection);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addMaster(Master master) {
        masterDAO.createMaster(master);

        System.out.println(master);
    }
}
