package org.scoula.ex04.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cart_delete")
public class CartDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // MIME 타입 설정
        resp.setContentType("text/html;charset=UTF-8");

        // 자바 I/O
        PrintWriter out = resp.getWriter();

        // html 작성 및 출력
        out.print("<html><body>");
        out.print("장바구니 비웠음!!");
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        } else {
            out.print("세션 없음<br>");
        }
        out.print("<a href='session_product.jsp'>상품 선택 페이지</a><br>");
        out.print("</body></html>");

    }

}