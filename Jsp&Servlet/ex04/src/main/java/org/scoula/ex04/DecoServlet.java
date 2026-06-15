package org.scoula.ex04;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deco/test")
public class DecoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // MIME 타입 설정
        resp.setContentType("text/html;charset=UTF-8");

        // 자바 I/O
        PrintWriter out = resp.getWriter();

        // html 작성 및 출력
        out.print("<html><body>");
        out.print("Deco Test");
        out.print("</body></html>");

    }

}