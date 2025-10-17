package FifthHomeWork;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class JettyLauncher {
    public static void main(String[] args) throws Exception {
        Server server = new Server(6968);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(MainServlet.class, "/main");
        context.addServlet(HistoryServlet.class, "/history");
        context.addServlet(PictureServlet.class, "/picture");
        context.addServlet(QuizServlet.class, "/quiz");
        context.addServlet(TicketServlet.class, "/tickets");
        context.addServlet(CartServlet.class, "/cart");

        server.start();
        System.out.println("Server started at http://localhost:6968/first");
        server.join();
    }
}