package FourthHomeWork;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/tickets")
public class TicketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("page-tickets.html");

        BufferedReader reader = new BufferedReader((new InputStreamReader(inputStream)));

        PrintWriter out = resp.getWriter();

        String line;

        while ((line = reader.readLine()) != null) {
            out.println(line);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        List<Ticket> cart = (List<Ticket>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart",cart);
        }

        String name = req.getParameter("productName");
        int price = Integer.parseInt(req.getParameter("productPrice"));
        String description = req.getParameter("productDescription");

        Ticket ticket = new Ticket(name,price,description);

        cart.add(ticket);

        session.setAttribute("cart",cart);

        resp.sendRedirect("/cart");
    }
}
