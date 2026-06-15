package com.multi.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String loginId = (String) session.getAttribute("loginId");

        if (loginId == null) {
            resp.sendRedirect(req.getContextPath() + "/loginPage");
            return;
        }

        boolean popupOpen = true;

        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("popupCookie".equals(cookie.getName())) {
                    if ("done".equals(cookie.getValue())) {
                        popupOpen = false;
                    }
                    break;
                }
            }
        }

        req.setAttribute("loginId", loginId);
        req.setAttribute("popupOpen", popupOpen);

        req.getRequestDispatcher("/cookie/main.jsp").forward(req, resp);
    }
}
