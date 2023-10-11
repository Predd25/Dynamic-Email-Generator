package com.patrickredding.DEA

import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import java.io.IOException

class EmailServlet extends HttpServlet {
    // This is a simple in-memory storage for emails
    private List<String> emails = []

    // No-argument constructor
    EmailServlet() {
        // You can perform any necessary initialization here
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Handle GET request to retrieve emails
        resp.setContentType("application/json")
        resp.getWriter().println(emails.toString())
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Handle POST request to create a new email
        String emailContent = req.getParameter("content")

        if (emailContent != null) {
            emails.add(emailContent)
            resp.setStatus(HttpServletResponse.SC_CREATED)
            resp.getWriter().println("Email created successfully.")
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST)
            resp.getWriter().println("Email content is required.")
        }
    }
}
