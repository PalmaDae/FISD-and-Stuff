package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import SixthHomeWork.Ticket;
import dao.TicketDAO;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private TicketDAO ticketDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("main/webapp/html/page-admin.html");

        BufferedReader reader = new BufferedReader((new InputStreamReader(inputStream)));

        PrintWriter out = resp.getWriter();

        String line;

        while ((line = reader.readLine()) != null) {
            out.println(line);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String ticketId = req.getParameter("ticketId");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String price = req.getParameter("price");

        try {
            if ("delete".equals(action) && ticketId != null) {
                int ticketid =  Integer.parseInt(ticketId);
                ticketDAO.deleteTicket(ticketid);
            } else if ("edit".equals(action) && ticketId != null) {
                int ticketid =  Integer.parseInt(ticketId);
                int price2 = Integer.parseInt(price);
                ticketDAO.updateTicket(new Ticket(ticketid, name, price2, description));
            } else {
                int price2 = Integer.parseInt(price);
                ticketDAO.createTicket(new Ticket(name, price2, description));
            }
        } catch (SQLException | NumberFormatException e) {
            throw new ServletException(e);
        }

        resp.sendRedirect("/admin");
    }

    @Override
    public void init() throws ServletException {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/beerfest", "postgres","010909");
            ticketDAO = new TicketDAO(connection);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
