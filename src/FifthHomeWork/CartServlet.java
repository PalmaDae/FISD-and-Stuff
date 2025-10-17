package FifthHomeWork;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private TicketDAO ticketDAO;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("page-cart.html");

        BufferedReader reader = new BufferedReader((new InputStreamReader(inputStream)));

        PrintWriter out = resp.getWriter();

        String line;

        List<Ticket> cart;
        try {
            cart = ticketDAO.getCartItems();
        } catch (SQLException e) {
            throw new ServletException(e);
        }

        HttpSession session = req.getSession();

        while ((line = reader.readLine()) != null) {
            if (line.contains("<div id=\"cartContent\">")) {
                out.println(line);

                if (cart.isEmpty()) {
                    out.println("<p>Корзина пустует</p>");
                } else {
                    out.println("<table border = '1' cellspacing = '0' cellpadding ='10'>");
                    out.println("<tr><th>Фестиваль</th><th>Описание</th><th>Цена</th></tr>");

                    for (Ticket ticket : cart) {
                        out.println("<tr>");
                        out.println("<td>" + ticket.getName() + "</td>");
                        out.println("<td>" + ticket.getDescription() + "</td>");
                        out.println("<td>" + ticket.getPrice() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                }
            }
            out.println(line);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        try {
            ticketDAO.clearCart();
        } catch (SQLException e) {
            throw new ServletException(e);
        }

        session.setAttribute("orderDone", "Заказ сделан");

        resp.sendRedirect("/cart");
    }
}
