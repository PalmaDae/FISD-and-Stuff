package ThirdHomeWork;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class JettyLauncher {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(MyServlet.class, "/hello");

        server.start();
        System.out.println("Server started at http://localhost:8081/hello");
        server.join();
    }
}