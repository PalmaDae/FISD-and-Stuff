package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserServiceImpl;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/arts")
public class ArtsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String imagePath = getServletContext().getRealPath("/images/arts");
        File folder = new File(imagePath);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().matches(".*\\.(jpg|jpeg|png|gif)$"));

        List<String> images = files == null ? List.of() :
                Arrays.stream(files)
                        .map(File::getName)
                        .sorted()
                        .collect(Collectors.toList());

        req.setAttribute("images", images);
        req.getRequestDispatcher("/jsp/page-arts.jsp").forward(req, resp);
    }
}
