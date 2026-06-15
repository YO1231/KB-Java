package com.multi.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginPage")
public class LoginPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String savedId = "";

        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("saveId".equals(cookie.getName())) {
                    savedId = cookie.getValue();
                    break;
                }
            }
        }

        req.setAttribute("savedId", savedId);
        req.getRequestDispatcher("/cookie/login.jsp").forward(req, resp);
    }
}
