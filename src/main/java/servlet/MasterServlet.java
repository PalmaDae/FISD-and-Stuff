package servlet;

import dao.MasterDAO;
import entity.Master;
import entity.Ticket;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MasterService;
import service.TicketServiceImpl;
import service.UserServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/masters")
public class MasterServlet extends HttpServlet {
    private MasterService masterService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = UserServiceImpl.checkUser(req);

        req.setAttribute("login",login);


        try {
            List<Master> list = masterService.getAllMasters();
            req.setAttribute("list", list);
        } catch (SQLException e) {
            throw new ServletException(e);
        }

        req.getRequestDispatcher("/jsp/page-masters.jsp").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        this.masterService = new MasterService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String masterParametr = req.getParameter("masterId");

//        if (masterParametr != null) {
//            int masterId = Integer.parseInt(masterParametr);
//
//            try {
//
//            } catch (SQLException e) {
//                throw new ServletException(e);
//            }
//        }
//
//        resp.sendRedirect("/cart");
    }
}
