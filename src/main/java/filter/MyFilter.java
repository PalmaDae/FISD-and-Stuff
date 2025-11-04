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


public class MyFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        String requestURI = ((HttpServletRequest) req).getRequestURI();

        System.out.println("Filter check: " + requestURI);

        System.out.println("Redirecting to /login");

        HttpSession session = ((HttpServletRequest) req).getSession(true);

        User user = (User) session.getAttribute("user");

        if (user == null) {
            user = new User(0, "guest", "", Role.GUEST);
            session.setAttribute("user", user);
        }

        if (requestURI.equals("/main") || requestURI.equals("/registration") || requestURI.equals("/login")) {
            chain.doFilter(req, res);
            return;
        }

        if (requestURI.equals("/admin") && !(user.getRole() == Role.ADMIN)) {
            ((HttpServletResponse) res).sendRedirect("/main");
        }

        if (user.getRole() == Role.GUEST) {
            ((HttpServletResponse) res).sendRedirect("/registration");
            return;
        }

        chain.doFilter(req,res);
    }
}
