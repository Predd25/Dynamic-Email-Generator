package com.patrickredding.DEA

import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import java.io.IOException
import org.apache.velocity.app.VelocityEngine
import org.apache.velocity.VelocityContext
import org.apache.velocity.Template
import java.io.StringWriter

class EmailServlet extends HttpServlet {
    private List<String> emails = []

    EmailServlet() {
        // You can perform any necessary initialization here
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json")
        resp.getWriter().println(emails.toString())
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String emailContent = req.getParameter("content")

        if (emailContent != null) {
            // Generate dynamic email content using EmailService
            String recipientName = req.getParameter("recipientName") // Assuming you have a recipientName parameter
            String mergedEmailContent = generateDynamicEmail(recipientName, emailContent)
            
            emails.add(mergedEmailContent) // Add the merged email content to the email list
            resp.setStatus(HttpServletResponse.SC_CREATED)
            resp.getWriter().println("Email created successfully.")
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST)
            resp.getWriter().println("Email content is required.")
        }
    }

    private String generateDynamicEmail(String recipientName, String emailContent) {
        VelocityEngine velocityEngine = new VelocityEngine()
        velocityEngine.init()

        VelocityContext velocityContext = new VelocityContext()
        velocityContext.put("emailContent", emailContent)
        velocityContext.put("recipientName", recipientName)
        velocityContext.put("emailSubject", "Daily Email Request")

        StringWriter writer = new StringWriter()
        def template = velocityEngine.getTemplate("/src/main/resources/emailTemplate.vm")
        template.merge(velocityContext, writer)

        return writer.toString()
    }
}
