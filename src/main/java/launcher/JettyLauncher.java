package launcher;

import filter.MyFilter;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import org.eclipse.jetty.jsp.JettyJspServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlet.*;

import java.util.EnumSet;

public class JettyLauncher {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.setContextPath("/");
        context.setResourceBase("src/main/webapp");

        ServletHolder defaultServlet = new ServletHolder("default", DefaultServlet.class);
        context.addServlet(defaultServlet, "/");

        ServletHolder jsp = new ServletHolder("jsp", JettyJspServlet.class);

        context.addFilter(MyFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));

        context.addServlet(MainServlet.class, "/main");
        context.addServlet(HistoryServlet.class, "/history");
        context.addServlet(PictureServlet.class, "/picture");
        context.addServlet(QuizServlet.class, "/quiz");
        context.addServlet(TicketServlet.class, "/tickets");
        context.addServlet(CartServlet.class, "/cart");
        context.addServlet(AdminServlet.class, "/admin");
        context.addServlet(LoginServlet.class, "/login");
        context.addServlet(RegistrationServlet.class, "/registration");

        server.setHandler(context);
        server.start();
        System.out.println("Server started at http://localhost:8080/main");
        server.join();
    }
}