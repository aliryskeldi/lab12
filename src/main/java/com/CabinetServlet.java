package com.example;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cabinet")
public class CabinetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws IOException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        if ("logout".equals(req.getParameter("action"))) {
            session.invalidate();
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().println(
            "<h2>Жеке кабинет</h2>" +
            "<p>Қош келдіңіз, " +
            session.getAttribute("user") + "!</p>" +
            "<a href='cabinet?action=logout'>Шығу</a>"
        );
    }
}
