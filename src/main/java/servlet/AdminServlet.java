package servlet;

import entity.Master;
import entity.Role;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CharService;
import service.MasterService;
import service.UserServiceImpl;

import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private UserServiceImpl userService;
    private CharService charService;
    private MasterService masterService;

    @Override
    public void init() throws ServletException {
        this.userService = new UserServiceImpl();
        this.charService = new CharService();
        this.masterService = new MasterService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("errorMessage", "");
        req.getRequestDispatcher("/jsp/page-admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        String username = req.getParameter("username");
        String role = req.getParameter("role");
        String masterName = req.getParameter("masterName");
        String description = req.getParameter("description");
        String cost = req.getParameter("cost");
        String photoPath = req.getParameter("photo");

        String errorMessage = null;

        if (action == null) {
            errorMessage = "Не выбрано действие";
            req.setAttribute("errorMessage", errorMessage);
            req.getRequestDispatcher("/jsp/page-admin.jsp").forward(req, resp);
            return;
        }

        try {
            switch (action) {
                case "updateRole":
                    if (username != null && role != null && !role.isEmpty()) {
                        try {
                            Role newRole = Role.valueOf(role.toUpperCase());
                            userService.updateUserRole(username, String.valueOf(newRole));
                        } catch (IllegalArgumentException e) {
                            errorMessage = "Неверная роль: " + role;
                        }
                    } else {
                        errorMessage = "Имя пользователя или роль не могут быть пустыми";
                    }
                    break;
                case "deleteUser":
                    if (username != null && !username.isEmpty()) {
                        userService.deleteUser(username);
                    } else {
                        errorMessage = "Имя пользователя не может быть пустым";
                    }
                    break;

                case "addMaster":
                    if (masterName != null && !masterName.isEmpty() &&
                            description != null && !description.isEmpty() &&
                            cost != null && !cost.isEmpty() &&
                            photoPath != null && !photoPath.isEmpty()) {
                        Master master = Master.builder()
                                        .name(masterName)
                                        .description(description)
                                        .cost(Integer.parseInt(cost))
                                        .photoPath(photoPath)
                                                .build();

                        masterService.addMaster(master);
                    } else {
                        errorMessage = "Поля должны быть заполнены";
                    }
                    break;

                default:
                    errorMessage = "Неизвестное действие";
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorMessage = "Ошибка при выполнении действия: " + e.getMessage();
        }

        req.setAttribute("errorMessage", errorMessage != null ? errorMessage : "");
        req.getRequestDispatcher("/jsp/page-admin.jsp").forward(req, resp);
    }
}
