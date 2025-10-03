package ThirdHomeWork;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class JettyLauncher {
    public static void main(String[] args) throws Exception {
        Server server = new Server(6969);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(MaximServlet.class, "/hello");

        server.start();
        System.out.println("Server started at http://localhost:6969/hello");
        server.join();
    }
}