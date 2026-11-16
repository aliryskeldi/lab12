package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cabinet")
public class CabinetServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(false);

        PrintWriter out = response.getWriter();

        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.html");
            return;
        }

        String username = (String) session.getAttribute("username");

        out.println("<h1>Жеке кабинет</h1>");
        out.println("<h2>Қош келдіңіз, " + username + "!</h2>");
        out.println("<a href='logout'>Шығу</a>");
    }
}
