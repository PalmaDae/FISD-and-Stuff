package servlet;

import entity.Ticket;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.TicketDAO;
import service.TicketServiceImpl;
import service.UserServiceImpl;

import java.io.*;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/tickets")
public class TicketServlet extends HttpServlet {
    private TicketDAO ticketDAO;
    private TicketServiceImpl ticketService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String username = UserServiceImpl.checkUser(req);

        req.setAttribute("username",username);


        try {
            List<Ticket> list = ticketService.getTickets();
            req.setAttribute("list", list);
        } catch (SQLException e) {
            throw new ServletException(e);
        }

        req.getRequestDispatcher("/jsp/page-tickets.jsp").forward(req, resp);


    }

    @Override
    public void init() throws ServletException {
        this.ticketService = new TicketServiceImpl();
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
