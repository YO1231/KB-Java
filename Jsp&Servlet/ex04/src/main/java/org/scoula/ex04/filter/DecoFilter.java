package org.scoula.ex04.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter("/deco/*")
public class DecoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        // 요청 처리 전
        System.out.println(req.getRequestURI() + " ========>");

        // 다음 Filter 또는 Servlet 실행
        filterChain.doFilter(servletRequest, servletResponse);

        // 요청 처리 후
        System.out.println("<========");
    }
}
