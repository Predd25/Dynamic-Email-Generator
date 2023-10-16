package com.patrickredding.DEA

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.ServletContextHandler
// import org.eclipse.jetty.servlet.ServletHolder old

class Main {
    static void main(String[] args) {
        Server server = new Server(8080) // Set your desired port number
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS)

        context.setContextPath("/")
     // server.setHandler(context) old

     // context.addServlet(new ServletHolder(new EmailServlet()), "/api/email") old
        context.addServlet(EmailServlet, "/api/email")

        // Instantiate EmailService
        def emailService = new EmailService()

        try {
            server.setHandler(context)
            server.start()
            server.join()
        } catch (Exception e) {
            e.printStackTrace()
        }
    }
}
