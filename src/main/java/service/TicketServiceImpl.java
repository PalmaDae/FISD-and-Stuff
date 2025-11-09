package service;


import dao.TicketDAO;
import entity.Ticket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class TicketServiceImpl {
    private TicketDAO ticketDAO;

    public TicketServiceImpl() {
        this.ticketDAO = createTicketDAO();
    }

    public TicketDAO createTicketDAO() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/beerfest",
                    "postgres",
                    "010909"
            );
            return new TicketDAO(connection);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Ticket> getTickets() throws SQLException {
        return ticketDAO.getAllTickets();
    }
}
