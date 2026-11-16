package com.example;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().println(
            "<h2>Жүйеге кіру</h2>" +
            "<form method='post' action='login'>" +
            "Логин: <input name='user'><br><br>" +
            "Құпиясөз: <input type='password' name='pass'><br><br>" +
            "<button type='submit'>Кіру</button>" +
            "</form>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws IOException {
        String u = req.getParameter("user");
        String p = req.getParameter("pass");

        if ("admin".equals(u) && "1234".equals(p)) {
            req.getSession().setAttribute("user", u);
            resp.sendRedirect(req.getContextPath() + "/cabinet");
        } else {
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().println(
                "<h3 style='color:red'>Логин немесе құпиясөз қате!</h3>"
            );
        }
    }
}
