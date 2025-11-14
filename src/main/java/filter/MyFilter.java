package filter;

import entity.Role;
import entity.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

//@WebFilter("/*")
public class MyFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        String requestURI = ((HttpServletRequest) req).getRequestURI();

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String path = ((HttpServletRequest) req).getServletPath();

        if (requestURI.startsWith(request.getContextPath() + "/css") ||
                requestURI.startsWith(request.getContextPath() + "/js") ||
                requestURI.startsWith(request.getContextPath() + "/images") ||
                requestURI.endsWith(".png") ||
                requestURI.endsWith(".jpg") ||
                requestURI.endsWith(".gif")) {
            chain.doFilter(req, res);
            return;
        }

        System.out.println("Filter check: " + path);

        System.out.println("Redirecting to /login");

        HttpSession session = ((HttpServletRequest) req).getSession(true);

        User user = (User) session.getAttribute("user");

        if (user == null) {
            user = new User(0, "guest", "", Role.GUEST, new ArrayList<>());
            session.setAttribute("user", user);
        }

        if (path.equals("/main") || path.equals("/registration") || path.equals("/login") || path.equals("/test")) {
            chain.doFilter(req, res);
            return;
        }

        if (path.equals("/admin") && !(user.getRole() == Role.ADMIN)) {
            response.sendRedirect(request.getContextPath() + "/main");
            return;
        }

        if (user.getRole() == Role.GUEST) {
            response.sendRedirect(request.getContextPath() + "/registration");
            return;
        }

        chain.doFilter(req,res);
    }
}
