package com.task2;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/head")
public class HeadServlet extends HttpServlet {

    // include() preserves the original method, so this fragment must also handle POST.
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var title = (String) request.getAttribute("pageTitle");
        var out = response.getWriter();

        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
        out.println("<title>" + FormServlet.escapeHtml(title == null ? "HTML Forms" : title) + "</title>");
        out.println("""
                <style>
                    body {
                        margin: 0;
                        padding: 2rem;
                        font-family: Arial, sans-serif;
                        background: #f4f6f8;
                        color: #202b38;
                    }
                    main {
                        max-width: 40rem;
                        margin: 2rem auto;
                        padding: 2rem;
                        background: white;
                        border-radius: 0.5rem;
                    }
                    h1 { overflow-wrap: anywhere; }
                    a { color: #185abc; }
                </style>
                """);
        out.println("</head>");
    }
}
