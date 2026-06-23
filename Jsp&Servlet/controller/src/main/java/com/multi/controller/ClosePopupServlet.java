package com.multi.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/closePopup")
public class ClosePopupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String dontShowToday = req.getParameter("dontShowToday");

        if (dontShowToday != null) {
            Cookie cookie = new Cookie("popupCookie", "done");

            cookie.setMaxAge(60 * 60 * 24);
            cookie.setPath(req.getContextPath());
            resp.addCookie(cookie);
        }

        PrintWriter out = resp.getWriter();

        out.println("<script>");
        out.println("window.close();");
        out.println("</script>");
    }
}
