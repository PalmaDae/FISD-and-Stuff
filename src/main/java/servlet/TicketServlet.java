package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.TicketDAO;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@WebServlet("/tickets")
public class TicketServlet extends HttpServlet {
    private TicketDAO ticketDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        req.getRequestDispatcher("/html/page-tickets.html").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/beerfest", "postgres","010909");
            ticketDAO = new TicketDAO(connection);
        } catch (SQLException e)     {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ticketParametr = req.getParameter("ticketId");

        if (ticketParametr != null) {
            int ticketId = Integer.parseInt(ticketParametr);

            try {
                ticketDAO.addToCart(ticketId);
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }

        resp.sendRedirect("/cart");
    }
}
