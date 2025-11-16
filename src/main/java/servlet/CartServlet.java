//package servlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import service.UserServiceImpl;
//
//import java.io.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.List;
//
//
//@WebServlet("/cart")
//public class CartServlet extends HttpServlet {
//
//    private TicketDAO ticketDAO;
//
//    @Override
//    public void init() throws ServletException {
//        try {
//            Connection connection = DriverManager.getConnection(
//                    "jdbc:postgresql://localhost:5432/beerfest", "postgres","010909");
//            ticketDAO = new TicketDAO(connection);
//        } catch (SQLException e) {
//            throw new ServletException(e);
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String login = UserServiceImpl.checkUser(req);
//
//        req.setAttribute("login",login);
//
//        List<Ticket> cart;
//        try {
//            cart = ticketDAO.getCartItems();
//        } catch (SQLException e) {
//            throw new ServletException(e);
//        }
//
//        req.setAttribute("cart", cart);
//
//        HttpSession session = req.getSession();
//
//        String orderDone = (String) session.getAttribute("orderDone");
//
//        if (orderDone != null) {
//            req.setAttribute("orderDone", orderDone);
//            session.removeAttribute("orderDone");
//        }
//
//        req.getRequestDispatcher("/jsp/page-cart.jsp").include(req, resp);
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//
//        try {
//            ticketDAO.clearCart();
//        } catch (SQLException e) {
//            throw new ServletException(e);
//        }
//
//        session.setAttribute("orderDone", "Заказ сделан");
//
//        resp.sendRedirect("/cart");
//    }
//}
