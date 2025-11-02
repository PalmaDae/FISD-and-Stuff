package dao;

import entity.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {
    private Connection connection;

    public TicketDAO(Connection connection) {
        this.connection = connection;
    }

    public void createTicket(Ticket ticket) throws SQLException {
        String sql = "insert into tickets (name, price, description) values (?, ?, ?)";
        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, ticket.getName());
            ps.setInt(2, ticket.getPrice());
            ps.setString(3, ticket.getDescription());
            ps.executeUpdate();
        }
    }

    public List<Ticket> getAllTickets() throws SQLException {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "select * from tickets order by id";

        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)
        ) {
            while (rs.next()) {
                tickets.add(new Ticket(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("description")
                ));
            }
        }

        return tickets;
    }

    public Ticket getTicketById(int id) throws SQLException {
        String sql = "select * from tickets where id = ?";

        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,id);

            try(ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return new Ticket(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("price"),
                            rs.getString("description")
                    );
                }
            }
        }

        return null;
    }

    public void updateTicket(Ticket ticket) throws SQLException {
        String sql = "update tickets set name = ?, price = ?, description = ? where id = ?";

        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, ticket.getName());
            statement.setInt(2, ticket.getPrice());
            statement.setString(3, ticket.getDescription());
            statement.setInt(4, ticket.getId());
            statement.executeUpdate();
        }
    }

    public void deleteTicket(int id) throws SQLException {
        String trSQL = "insert into trash (ticket_id) values (?)";

        try(PreparedStatement statement = connection.prepareStatement(trSQL)) {
            statement.setInt(1,id);
            statement.executeUpdate();
        }

        String delete = "delete from tickets where id = ?";

        try(PreparedStatement statement = connection.prepareStatement(delete)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public void clearCart() throws SQLException {
        String sql = "delete from cart";

        try(Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }
    }

    public void removeFromCart(int id) throws SQLException {
        String sql = "delete from cart where ticket_id = ?";

        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public void addToCart(int id) throws SQLException {
        String sql = "insert into cart (ticket_id) values (?)";

        try(PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1,id);
            statement.executeUpdate();

        }
    }

    public List<Ticket> getCartItems() throws SQLException {
        List<Ticket> cart = new ArrayList<>();

        String sql = "select t.id, t.name, t.price, t.description from tickets t join cart c on t.id = c.ticket_id order by c.id";

        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                cart.add(new Ticket(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getString("description")
                ));
            }
        }

        return cart;
    }

}