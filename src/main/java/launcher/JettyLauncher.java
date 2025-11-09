package launcher;

import filter.MyFilter;
import jakarta.servlet.DispatcherType;
import org.eclipse.jetty.jsp.JettyJspServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import servlet.*;

import java.util.EnumSet;

public class JettyLauncher {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        WebAppContext context = new WebAppContext();
        context.setContextPath("/");
        context.setResourceBase("src/main/webapp");
        context.setParentLoaderPriority(true);
        context.setContextPath("/");
        context.setResourceBase("src/main/webapp");
        context.setParentLoaderPriority(true);

        // JSP
        ServletHolder jsp = new ServletHolder("jsp", JettyJspServlet.class);
        jsp.setInitParameter("logVerbosityLevel", "DEBUG");
        jsp.setInitParameter("fork", "false");
        jsp.setInitParameter("xpoweredBy", "false");
        jsp.setInitParameter("compilerTargetVM", "1.8");
        jsp.setInitParameter("compilerSourceVM", "1.8");
        jsp.setInitParameter("keepgenerated", "true");
        context.addServlet(jsp, "*.jsp");

        // Статика
        ServletHolder defaultServlet = new ServletHolder("default", DefaultServlet.class);
        context.addServlet(defaultServlet, "/css/*");
        context.addServlet(defaultServlet, "/js/*");
        context.addServlet(defaultServlet, "/images/*");

        // Фильтр
        context.addFilter(MyFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));

        // Сервлеты
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
