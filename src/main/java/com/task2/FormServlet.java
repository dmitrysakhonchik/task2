package com.task2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/submit")
public class FormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(StandardCharsets.UTF_8.name());
        var name = request.getParameter("name");
        var method = request.getMethod();

        request.setAttribute("pageTitle", "Form Result");
        response.setContentType("text/html;charset=UTF-8");

        var out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");

        request.getRequestDispatcher("/head").include(request, response);

        out.println("<body>");
        out.println("<main>");
        out.println("<h1>Hello, " + escapeHtml(name == null || name.isBlank() ? "Guest" : name) + "!</h1>");
        out.println("<p>HTTP method: " + method + "</p>");
        out.println("<a href='index.html'>Back to forms</a>");
        out.println("</main>");
        out.println("</body>");
        out.println("</html>");
    }

    static String escapeHtml(String value) {
        return value.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}
