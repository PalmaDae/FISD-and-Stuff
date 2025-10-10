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


@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("page-cart.html");

        BufferedReader reader = new BufferedReader((new InputStreamReader(inputStream)));

        PrintWriter out = resp.getWriter();

        String line;

        HttpSession session = req.getSession();

        List<Ticket> cart = (List<Ticket>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart",cart);
        }

        while ((line = reader.readLine()) != null) {
            out.println(line);
        }

        if (cart.isEmpty() || cart == null) {
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        List<Ticket> cart = (List<Ticket>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart",cart);
        }

        if (!cart.isEmpty()) {
            try(PrintWriter pw = new PrintWriter(new FileWriter("responds.txt", true))) {
                for (Ticket ticket : cart) {
                    pw.println(ticket.getName());
                    pw.println(ticket.getDescription());
                    pw.println(ticket.getPrice());
                    pw.println("--------");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            cart.clear();

            session.setAttribute("orderDone", "Заказ оформлен");
        }

        resp.sendRedirect("/cart");
    }
}
