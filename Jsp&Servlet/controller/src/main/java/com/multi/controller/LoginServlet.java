package com.multi.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String userId = req.getParameter("userId");
        String userPw = req.getParameter("userPw");
        String rememberId = req.getParameter("rememberId");

        if (rememberId != null) {
            Cookie cookie = new Cookie("saveId", userId);

            // 아이디 저장 쿠키 7일 유지
//            cookie.setMaxAge(60 * 60 * 24 * 7);
            cookie.setMaxAge(60);

            // 현재 프로젝트 전체에서 사용 가능
            cookie.setPath(req.getContextPath());
            resp.addCookie(cookie);

        } else {
            Cookie cookie = new Cookie("saveId", "");

            // 기존 아이디 저장 쿠키 삭제
            cookie.setMaxAge(60);
            cookie.setPath(req.getContextPath());
            resp.addCookie(cookie);
        }

        if ("admin".equals(userId) && "1234".equals(userPw)) {
            HttpSession session = req.getSession();
            session.setAttribute("loginId", userId);

            resp.sendRedirect(req.getContextPath() + "/cookie/main.jsp");

        } else {
            resp.sendRedirect(req.getContextPath() + "/cookie/login.jsp");
        }

    }
}
